/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.impl.cliente;

import controller.action.ICommand;
import controller.action.impl.CallHomePage;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Endereco;
import model.Usuario;
import model.dao.EnderecoDAO;
import model.dao.UsuarioDAO;
import model.enumModel.ESexo;

/**
 *
 * @author Anderson2
 */
public class CallClienteSave implements ICommand{

    private Usuario usuario;
    private Endereco endereco;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getSession().getAttribute("user") == null){
            new CallHomePage().execute(request, response);
        }else if(((Usuario)request.getSession().getAttribute("user")).isCliente()){
            request.setAttribute("erro", "Sem acesso");
            new CallHomePage().execute(request, response);
        }else{
            
            MontaUsuarioComRequest(request);
            
            //Dados de usuarios vazios
            if(usuario.getLogin().isEmpty() || usuario.getLogin() == null || 
                    usuario.getSenha().isEmpty() || usuario.getSenha() == null){
                RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=clienteAdd");
                request.setAttribute("erroGravar", "Login e/ou senha vazio");
                request.setAttribute("retornoUsuario", usuario);
                request.setAttribute("retornoEndereco", endereco);
                rd.forward(request, response);
            }else 
                //Login ou CPF já existem no banco
                if(new UsuarioDAO().findUsuarioLoginCpf(usuario.getLogin(), usuario.getCpf()).size() > 0){
                RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=clienteAdd");
                request.setAttribute("erroGravar", "Login e/ou CPF informado já existe");
                request.setAttribute("retornoUsuario", usuario);
                request.setAttribute("retornoEndereco", endereco);
                rd.forward(request, response);
            }else{
                //Ok para gravar
                try{
                    new UsuarioDAO().SaveUsuario(usuario);
                    
                    endereco.setUsuario(usuario);
                    
                    new EnderecoDAO().SaveEndereco(endereco);
                    
                    RequestDispatcher rd = request.getRequestDispatcher("Home?ac=cliente_Index");
                    request.setAttribute("msgSucesso", "Cliente Cadastrado com Sucesso!");
                    rd.forward(request, response);
                }catch(Exception ex){//Falha ao gravar
                    RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=clienteAdd");
                    request.setAttribute("erroGravar", "Ocorreu uma falha ao salvar o registro.<br> Por favor tente novamente.");
                    request.setAttribute("retornoUsuario", usuario);
                    rd.forward(request, response);
                }
            }
        }
    }
    
    private void MontaUsuarioComRequest(HttpServletRequest request){
        usuario = new Usuario();
        usuario.setNome(request.getParameter("cpNome"));
        usuario.setCpf(request.getParameter("cpCpf"));
        usuario.setLogin(request.getParameter("cpLogin"));
        usuario.setSenha(request.getParameter("cpSenha"));
        usuario.setAtivo(
                request.getParameter("ckAtivo") != null &&
                "1".equals(request.getParameter("ckAtivo"))
        );
        if(request.getParameter("rdSexo") != null){
            usuario.setSexo((request.getParameter("rdSexo").equalsIgnoreCase("Masculino"))?ESexo.Masculino:ESexo.Feminino);
        }
        usuario.setCliente(true);
        
        endereco = new Endereco(
                        request.getParameter("cpRua"), 
                        request.getParameter("cpNumero"), 
                        request.getParameter("cpComplemento"), 
                        request.getParameter("cpBairro"), 
                        request.getParameter("cpCidade"), 
                        request.getParameter("cpUf"), 
                        request.getParameter("cpPais")
                    );
    }
    
}

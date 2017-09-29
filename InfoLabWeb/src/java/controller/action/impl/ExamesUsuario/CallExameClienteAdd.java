/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.impl.ExamesUsuario;

import controller.action.ICommand;
import controller.action.impl.CallHomePage;
import controller.action.impl.cliente.CallClienteIndex;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Exame;
import model.Usuario;
import model.dao.ExameDAO;
import model.dao.UsuarioDAO;

/**
 *
 * @author aluno
 */
public class CallExameClienteAdd implements ICommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getSession().getAttribute("user") == null){
            new CallHomePage().execute(request, response);
        }else if(((Usuario)request.getSession().getAttribute("user")).isCliente()){
            request.setAttribute("erro", "Sem acesso");
            new CallHomePage().execute(request, response);
        }else{
            if(request.getParameter("idCliente") != null){
                
            
                int IdCliente = Integer.parseInt(request.getParameter("idCliente"));

                Usuario cliente = new UsuarioDAO().findClienteById(IdCliente);


                if(cliente == null || !cliente.isCliente() || !cliente.isAtivo()){
                    String msgErro = "";
                    if(cliente == null || !cliente.isCliente()){
                        msgErro = "Cliente não encontrado";
                    }else if(!cliente.isAtivo()){
                        msgErro = "Cliente não está ativo";
                    }

                    request.setAttribute("msgErro", msgErro);
                    new CallClienteIndex().execute(request, response);
                }else{
                    List<Exame> lstExames = new ExameDAO().findAllExames();
                    
                    RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=exameClienteAdd");
                    request.setAttribute("lstExames", lstExames);
                    request.setAttribute("cliente", cliente);
                    
                    rd.forward(request, response);
                }
            }else{
                request.setAttribute("msgErro", "Cliente não Encontrado");
                new CallClienteIndex().execute(request, response);
            }
        }
    }
    
}

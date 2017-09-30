/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.impl.ExamesUsuario;

import controller.action.ICommand;
import controller.action.impl.CallHomePage;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ExamesUsuario;
import model.Usuario;
import model.dao.ExameUsuarioDAO;

/**
 *
 * @author aluno
 */
public class CallExameClienteViewPage implements ICommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getSession().getAttribute("user") == null){
            new CallHomePage().execute(request, response);
        }else{
            int IdExame = Integer.parseInt(request.getParameter("idExameCliente"));
            ExamesUsuario exameCliente = new ExameUsuarioDAO().findExameClienteById(IdExame);
            
            if(exameCliente == null){
                request.setAttribute("msgErro", "Exame Não Encontrado");
                new CallHomePage().execute(request, response);
            }else if(exameCliente.getIdusuario().getId() != ((Usuario)request.getSession().getAttribute("user")).getId()
                    && ((Usuario)request.getSession().getAttribute("user")).isCliente()){
                request.setAttribute("erro", "Sem acesso");
                new CallHomePage().execute(request, response);
            }else{
                RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=exibirExameCliente");
                request.setAttribute("exameCliente", exameCliente);
                rd.forward(request, response);
            }
        }
    }
    
}

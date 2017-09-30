/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.impl.ExamesUsuario;

import controller.action.ICommand;
import controller.action.impl.CallHomePage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ExamesUsuario;
import model.Usuario;
import model.dao.ExameUsuarioDAO;

/**
 *
 * @author aluno
 */
public class CallExameClientePagar implements ICommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getSession().getAttribute("user") == null){
            new CallHomePage().execute(request, response);
        }else if(((Usuario)request.getSession().getAttribute("user")).isCliente()){
            request.setAttribute("erro", "Sem acesso");
            new CallHomePage().execute(request, response);
        }else{
            int idExameCliente = Integer.parseInt(request.getParameter("idExameCliente"));
            ExamesUsuario exameCliente = new ExameUsuarioDAO().findExameClienteById(idExameCliente);
            if(exameCliente == null){
                request.setAttribute("erro", "Sem acesso");
                new CallHomePage().execute(request, response);
            }else{
                exameCliente.setExamePago(Boolean.TRUE);
                new ExameUsuarioDAO().UpdateExameUsuario(exameCliente);
                
                new CallPageExamesUsuarioIndex().execute(request, response);
            }
        }
    }
    
}

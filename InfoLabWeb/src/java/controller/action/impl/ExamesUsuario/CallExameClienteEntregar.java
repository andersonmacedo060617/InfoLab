/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.impl.ExamesUsuario;

import controller.action.ICommand;
import controller.action.impl.CallHomePage;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ExamesUsuario;
import model.Usuario;
import model.dao.ExameUsuarioDAO;

/**
 *
 * @author aluno
 */
public class CallExameClienteEntregar implements ICommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getSession().getAttribute("user") == null){
            new CallHomePage().execute(request, response);
        }else if(((Usuario)request.getSession().getAttribute("user")).isCliente()){
            request.setAttribute("erro", "Sem acesso");
            new CallHomePage().execute(request, response);
        }else{
            
            try{
                Calendar hoje = Calendar.getInstance();
                
            
                int idExame = Integer.parseInt(request.getParameter("idExameCliente"));
                ExamesUsuario exameCliente = new ExameUsuarioDAO().findExameClienteById(idExame);

                exameCliente.setDataEntregaConcluida(hoje.getTime());
                
                
                exameCliente.setExamePronto(Boolean.TRUE);
                exameCliente.setDataExamePronto(hoje.getTime());
                
                new ExameUsuarioDAO().UpdateExameUsuario(exameCliente);
                new CallPageExamesUsuarioIndex().execute(request, response);
            }catch(Exception ex){
                new CallHomePage().execute(request, response);
            }
        }
    }
    
}

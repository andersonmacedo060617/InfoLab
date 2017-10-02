/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.impl.ExamesUsuario;

import controller.action.ICommand;
import controller.action.impl.CallHomePage;
import java.util.Date;
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
public class CallExameClienteProntoPage implements ICommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        if(request.getSession().getAttribute("user") == null){
            new CallHomePage().execute(request, response);
        }else if(((Usuario)request.getSession().getAttribute("user")).isCliente()){
            request.setAttribute("erro", "Sem acesso");
            new CallHomePage().execute(request, response);
        }else{
            String dataExRequest = request.getParameter("cpDataExamePronto");
            String horaExRequest = request.getParameter("cpHoraExamePronto");      
            
            String[] sptData = dataExRequest.split("-");
            String[] sptHora = horaExRequest.split(":");
            try{
            Date dtExame = new Date(
                        (Integer.parseInt(sptData[0]) - 1900), 
                        (Integer.parseInt(sptData[1]) - 1), 
                        Integer.parseInt(sptData[2]), 
                        Integer.parseInt(sptHora[0]), 
                        Integer.parseInt(sptHora[1]));
            
            int idExame = Integer.parseInt(request.getParameter("cpIdExameCliente"));
            ExamesUsuario exameCliente = new ExameUsuarioDAO().findExameClienteById(idExame);
            
            exameCliente.setDataExamePronto(dtExame);
            exameCliente.setExamePronto(Boolean.TRUE);
            
            new ExameUsuarioDAO().UpdateExameUsuario(exameCliente);
            new CallPageExamesUsuarioIndex().execute(request, response);
            }catch(Exception ex){
                new CallHomePage().execute(request, response);
            }
        }
    }
    
}

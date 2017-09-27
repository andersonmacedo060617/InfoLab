/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.impl.exame;

import controller.action.ICommand;
import controller.action.impl.CallHomePage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Exame;
import model.Usuario;
import model.dao.ExameDAO;

/**
 *
 * @author Anderson2
 */
public class CallExameDelete implements ICommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getSession().getAttribute("user") == null){
            new CallHomePage().execute(request, response);
        }else if(((Usuario)request.getSession().getAttribute("user")).isCliente()){
            request.setAttribute("erro", "Sem acesso");
            new CallHomePage().execute(request, response);
        }else{
            int IdTipoExame = Integer.parseInt(request.getParameter("cpIdTipoExame"));
            Exame exame = new ExameDAO().findExameById(IdTipoExame);
            
            if(exame != null){
                new ExameDAO().deleteExame(exame);
            }
            response.sendRedirect("Home?ac=exames_Index");
        }
    }
    
}

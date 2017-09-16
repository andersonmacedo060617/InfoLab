/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.impl;

import controller.action.ICommand;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
public class CallHomePage implements ICommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        if(request.getSession().getAttribute("user") == null){
            request.setAttribute("erro", "Realize o login no sistema");
            new CallLoginPage().execute(request, response);
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=home");
            request.setAttribute("page", "home");
            rd.forward(request, response);
        }
        
        
    }
    
}

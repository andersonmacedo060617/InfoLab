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
 * @author Anderson2
 */
public class CallLogOutUsuario implements ICommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("userCliente");
        request.setAttribute("msg", "Usuario Deslogado!");
            new CallLoginPage().execute(request, response);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.impl;

import controller.action.ICommand;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import model.dao.UsuarioDAO;

/**
 *
 * @author aluno
 */
public class CallValidaAcesso implements ICommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String login = request.getParameter("cpLogin");
        String senha = request.getParameter("cpSenha");
        
        Usuario user = new UsuarioDAO().login(login, senha);
        
        if(user != null){
            request.getSession().setAttribute("user", user);
            new CallHomePage().execute(request, response);
        }else{
            request.setAttribute("erro", "Login ou senha Incorreta!!!");
            new CallLoginPage().execute(request, response);
        }
    }
    
}

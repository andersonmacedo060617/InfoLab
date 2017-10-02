/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.impl.ExamesUsuario;

import controller.action.ICommand;
import controller.action.impl.CallHomePage;
import java.util.List;
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
public class CallExameClienteViewMyExamesPage implements ICommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        if(request.getSession().getAttribute("user") == null){
            new CallHomePage().execute(request, response);
        }else{
            String IdUsuario = ((Usuario)request.getSession().getAttribute("user")).getId().toString();
            List<ExamesUsuario> meusExames = new ExameUsuarioDAO().findAllExamesUsuarioByIdUsuario(Integer.parseInt(IdUsuario));
            
            RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=meusExames");
            request.setAttribute("meusExames", meusExames);
            rd.forward(request, response);
        }
    }
    
}

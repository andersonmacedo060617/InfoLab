/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.impl.exame;

import controller.action.ICommand;
import controller.action.impl.CallHomePage;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Exame;
import model.Usuario;
import model.dao.ExameDAO;

/**
 *
 * @author aluno
 */
public class CallExameAlterPage implements ICommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        if(request.getSession().getAttribute("user") == null){
            new CallHomePage().execute(request, response);
        }else if(((Usuario)request.getSession().getAttribute("user")).isCliente()){
            request.setAttribute("erro", "Sem acesso");
            new CallHomePage().execute(request, response);
        }else{
            int idTipoExame = Integer.parseInt(request.getParameter("idTipoExame"));
            Exame tipoExame = new ExameDAO().findExameById(idTipoExame);
            if(tipoExame != null){
                RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=alteraTipoExame");
                request.setAttribute("tipoExame", tipoExame);   
                rd.forward(request, response);
            }else{
                request.setAttribute("msgErro", "Registro não encontrado");
                new CallPageExamesIndex().execute(request, response);
            }
        }
    }
    
}

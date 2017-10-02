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
import java.util.GregorianCalendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Exame;
import model.ExamesUsuario;
import model.Usuario;
import model.dao.ExameDAO;
import model.dao.ExameUsuarioDAO;
import model.dao.UsuarioDAO;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author aluno
 */
public class CallExameClienteSave implements ICommand{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        if(request.getSession().getAttribute("user") == null){
            new CallHomePage().execute(request, response);
        }else if(((Usuario)request.getSession().getAttribute("user")).isCliente()){
            request.setAttribute("erro", "Sem acesso");
            new CallHomePage().execute(request, response);
        }else{
            if(validaCampos(request)){
                Usuario cliente = new UsuarioDAO().findClienteById(Integer.parseInt(request.getParameter("cpIdCliente")));
                Exame tipoExame = new ExameDAO().findExameById(Integer.parseInt(request.getParameter("cpTipoExame")));
                
                String dataExRequest = request.getParameter("cpDataExame");
                String horaExRequest = request.getParameter("cpHoraExame");
                
                String[] sptData = dataExRequest.split("-");
                String[] sptHora = horaExRequest.split(":");
                try{
                    
                    
                Date dtExame = new Date(
                        (Integer.parseInt(sptData[0]) - 1900), 
                        (Integer.parseInt(sptData[1]) - 1), 
                        Integer.parseInt(sptData[2]), 
                        Integer.parseInt(sptHora[0]), 
                        Integer.parseInt(sptHora[1]));
                
                ExamesUsuario exameCli = new ExamesUsuario();
                exameCli.setIdusuario(cliente);
                exameCli.setIdexame(tipoExame);
                exameCli.setDataExame(dtExame);
                
                exameCli.CalculaDataPrevistaEntrega();
                
                exameCli.setValor(exameCli.getIdexame().getValor());
                exameCli.setExamePronto(false);
                exameCli.setExamePago(false);
                new ExameUsuarioDAO().SaveExame(exameCli);
                
                RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=exibirExameCliente");
                request.setAttribute("exameCliente", exameCli);
                rd.forward(request, response);
                }catch(Exception ex){
                    throw ex;
                }
            }else{
                request.setAttribute("msgErro", "Erro ao gravar dados!");
                response.sendRedirect("Home?ac=cliente_Index");
            }
        }
    }
    
    private boolean validaCampos(HttpServletRequest request){
        boolean frmValido = true;
        if(request.getParameter("cpIdCliente") == null){
            frmValido = false;
        }
        if(request.getParameter("cpTipoExame") == null){
            frmValido = false;
        }
        if(request.getParameter("cpDataExame") == null){
            frmValido = false;
        }
        if(request.getParameter("cpHoraExame") == null){
            frmValido = false;
        }
        
        return frmValido;
    }
}

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
public class CallExameAlterar implements ICommand{
    private Exame exame;
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getSession().getAttribute("user") == null){
            new CallHomePage().execute(request, response);
        }else if(((Usuario)request.getSession().getAttribute("user")).isCliente()){
            request.setAttribute("erro", "Sem acesso");
            new CallHomePage().execute(request, response);
        }else{
            MontaExameComRequest(request);
            
            if(exame.getNomeExame().isEmpty() || exame.getHorasEntrega() == 0){
                RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=alteraTipoExame");
                request.setAttribute("erroGravar", "Nome vazio ou Horas para entrega zerado!");
                request.setAttribute("retornoTipoExame", exame);
                rd.forward(request, response);
            }else{
                try{
                    new ExameDAO().AlterExame(exame);
                    
                    request.setAttribute("msgSucesso", "Tipo de exame Alterado com Sucesso!");
                    new CallPageExamesIndex().execute(request, response);
//                    response.sendRedirect("Home?ac=exames_Index");
                }catch(Exception ex){
                    RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=tipoExameAdd");
                    request.setAttribute("erroGravar", "Ocorreu uma falha ao salvar o registro.<br> Por favor tente novamente.");
                    request.setAttribute("retornoTipoExame", exame);
                    rd.forward(request, response);
                }
            }
        
        }
    }

    private void MontaExameComRequest(HttpServletRequest request){
        exame = new Exame();
        
        exame.setId(Long.parseLong(request.getParameter("cpIdTipoExame")));
        exame.setNomeExame(request.getParameter("cpNomeExame"));
        exame.setHorasEntrega(Integer.parseInt(request.getParameter("cpHoraEntrega")));
        exame.setHorasJejum(Integer.parseInt(request.getParameter("cpHoraJejum")));
        exame.setValor(Double.parseDouble(request.getParameter("cpValor")));
    }
}
    

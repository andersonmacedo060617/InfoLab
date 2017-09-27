/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.action.ICommand;
import controller.action.impl.cliente.CallClienteIndex;
import controller.action.impl.funcionario.CallFuncionarioIndex;
import controller.action.impl.CallLogOutUsuario;
import controller.action.impl.CallLoginPage;
import controller.action.impl.CallValidaAcesso;
import controller.action.impl.ExamesUsuario.CallPageExamesUsuarioIndex;
import controller.action.impl.cliente.CallClientePageAdd;
import controller.action.impl.cliente.CallClienteSave;
import controller.action.impl.exame.CallExamePageAdd;
import controller.action.impl.exame.CallExameSave;
import controller.action.impl.exame.CallPageExamesIndex;
import controller.action.impl.ExamesUsuario.CallPageMeusExames;
import controller.action.impl.exame.CallExameDelete;
import controller.action.impl.funcionario.CallFuncionarioPageAdd;
import controller.action.impl.funcionario.CallFuncionarioSave;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
@WebServlet(name = "HomeController", urlPatterns = {"/Home"})
public class HomeController extends HttpServlet {

    static Map<String, ICommand> comandos = new HashMap<>();
    
    //Adicionar ações
    static{
        //Acesso ao sistema
        comandos.put("LOGIN".toUpperCase(), new CallLoginPage());
        comandos.put("LOGAR".toUpperCase(), new CallValidaAcesso());
        comandos.put("LOGOUT".toUpperCase(), new CallLogOutUsuario());
        
        //Clientes
        comandos.put("CLIENTE_INDEX".toUpperCase(), new CallClienteIndex());
        comandos.put("CLIENTE_ADD".toUpperCase(), new CallClientePageAdd());
        comandos.put("CLIENTE_SAVE".toUpperCase(), new CallClienteSave());
        
        //Funcionarios
        comandos.put("FUNCIONARIO_INDEX".toUpperCase(), new CallFuncionarioIndex());
        comandos.put("FUNCIONARIO_ADD".toUpperCase(), new CallFuncionarioPageAdd());
        comandos.put("FUNCIONARIO_SAVE".toUpperCase(), new CallFuncionarioSave());
        
        //Exames Usuario
        comandos.put("meus_exames".toUpperCase(), new CallPageMeusExames());
        comandos.put("examesUsuario_Index".toUpperCase(), new CallPageExamesUsuarioIndex()); 
        
        //Tipos de Exame
        comandos.put("exames_Index".toUpperCase(), new CallPageExamesIndex());
        comandos.put("exame_add".toUpperCase(), new CallExamePageAdd());
        comandos.put("tipoExame_Save".toUpperCase(), new CallExameSave());
        comandos.put("apagar_Tipoexame".toUpperCase(), new CallExameDelete());
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String acao = request.getParameter("ac");
        acao = acao== null?"login":acao;
        try {
            //upper para resolver problema de case
            comandos.get(acao.toUpperCase()).execute(request, response);
        } catch (Exception ex) {
            //Tratar erro
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

<%-- 
    Document   : exibirTipoExame
    Created on : 02/10/2017, 19:31:07
    Author     : aluno
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="pt-BR" />
<!DOCTYPE html>
<div class="row">
    <div class="col-lg-10">
        <div class="panel panel-green">
            <div class="panel-heading">
                Tipo de Exame - <b>${requestScope.tipoExame.nomeExame}</b>
            </div>
            <div class="panel-body">
                <div class="col-lg-10">
                    <fieldset>
                        <legend>Dados do Tipo Exame</legend>
                        <table>
                            <tr>
                                <td>Codigo do Tipo Exame:</td>
                                <td>${requestScope.tipoExame.id}</td>
                            </tr>
                            <tr>
                                <td>Tipo de Exame:</td>
                                <td>${requestScope.tipoExame.nomeExame}</td>
                            </tr>
                            <tr>
                                <td>Horas para Entrega:</td>
                                <td>${requestScope.tipoExame.horasEntrega} horas</td>
                            </tr>
                            <tr>
                                <td>Horas de Jejum:</td>
                                <td>${requestScope.tipoExame.horasJejum}</td>
                            </tr>
                            <tr>
                                <td>Valor:</td>
                                <td><fmt:formatNumber value="${requestScope.tipoExame.valor}" type="currency" /></td>
                            </tr>
                            
                            
                        </table>
                    </fieldset>
                    <div class="form-group">
                        <a class="btn btn-info" href="Home?ac=exames_Index">Voltar</a>
                    </div>    
                </div>
            </div>
            <div class="panel-footer">
            </div>
        </div>
        <!-- /.col-lg-4 -->
    </div>
</div>
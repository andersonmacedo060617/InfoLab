<%-- 
    Document   : alteraTipoExame
    Created on : 02/10/2017, 20:04:03
    Author     : aluno
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="row">
    <div class="col-lg-10">
        <div class="panel panel-yellow">
            <div class="panel-heading">
                Alterar Tipo de Exame <b>${requestScope.tipoExame.nomeExame}</b>
            </div>
            <div class="panel-body">
                <c:if test="${requestScope.erroGravar != null}" >
                    <div class="alert alert-danger alert-dismissible">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <strong>${requestScope.erroGravar}</strong>
                    </div>
                </c:if>
                <form action="Home?ac=tipoExame_Altera" method="POST">
                    <div class="col-lg-10">
                        <fieldset>
                            <legend>Dados do Tipo de Exame</legend>
                            
                            <div class="form-group">
                                <input type="hidden" name="cpIdTipoExame" class="form-control" 
                                             value="${requestScope.tipoExame.id}"/>
                            </div>
                            <div class="form-group">
                                Nome do Exame: <input type="text" name="cpNomeExame" class="form-control" 
                                             value="${requestScope.tipoExame.nomeExame}"/>
                            </div>
                            <div class="form-group">
                                Horas para Entrega <input type="number" name="cpHoraEntrega" class="form-control"
                                           value="${requestScope.tipoExame.horasEntrega}"/>
                            </div>
                            <div class="form-group">
                                Horas em Jejum <input type="number" name="cpHoraJejum" class="form-control"
                                           value="${requestScope.tipoExame.horasJejum}"/>
                            </div>
                            <div class="form-group">
                                Valor <input type="number" name="cpValor" class="form-control"
                                           step="0.01" value="${requestScope.tipoExame.valor}"/>
                            </div>
                            
                        </fieldset>
                        
                        <div class="form-group">
                            <a class="btn btn-info" href="Home?ac=exames_Index">Voltar</a>
                            <input type="submit" class="btn btn-success" value="Gravar"/>
                        </div>
                    </div>
                </form>
            </div>
            <div class="panel-footer">
            </div>
        </div>
        <!-- /.col-lg-4 -->
    </div>
</div>

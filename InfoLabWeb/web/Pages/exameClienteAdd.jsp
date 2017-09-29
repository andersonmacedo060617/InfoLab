<%-- 
    Document   : exameClienteAdd
    Created on : 28/09/2017, 19:56:23
    Author     : aluno
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row">
    <div class="col-lg-10">
        <div class="panel panel-green">
            <div class="panel-heading">
                Criar Exame
            </div>
            <div class="panel-body">
                <c:if test="${requestScope.erroGravar != null}" >
                    <div class="alert alert-danger alert-dismissible">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <strong>${requestScope.erroGravar}</strong>
                    </div>
                </c:if>
                <form action="Home?ac=exame_cliente_save" method="POST">
                    <div class="col-lg-10">
                        <fieldset>
                            <legend>Exame para o cliente <b>${requestScope.cliente.nome}</b></legend>
                            <c:if test="${requestScope.cliente == null}">
                                <c:redirect url="/Home?ac=cliente_Index"/>
                            </c:if>
                            <input type="hidden" name="cpIdCliente" value="${requestScope.cliente.id}">                            
                            <div class="form-group">
                                Tipo de Exame: 
                                <select name="cpTipoExame" class="form-control">
                                    <option value="0">Selecione...</option>
                                    <c:forEach items="${requestScope.lstExames}" var="tipoExame">
                                        <option value="${tipoExame.id}">${tipoExame.nomeExame}</option> 
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-lg-4">
                                Data do Exame <input type="date" name="cpDataExame" class="form-control"
                                           value="${requestScope.retornoExameCliente !=null ? requestScope.retornoExameCliente.dataExame : ""}"/>
                            </div>
                            <div class="form-group col-lg-4">
                                Horas em Jejum <input type="time" name="cpHoraExame" class="form-control"
                                           value="${requestScope.retornoExameCliente !=null ? requestScope.retornoExameCliente.dataEntregaPrevista : ""}"/>
                            </div>
                            
                        </fieldset>
                        

                        <div class="form-group">
                            <a class="btn btn-info" href="Home?ac=cliente_Index">Voltar</a>
                            <input type="submit" class="btn btn-success" value="Marcar"/>
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
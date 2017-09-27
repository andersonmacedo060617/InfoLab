<%-- 
    Document   : tipoExameAdd
    Created on : 26/09/2017, 22:04:34
    Author     : aluno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-lg-10">
        <div class="panel panel-green">
            <div class="panel-heading">
                Criar Tipo de Exame
            </div>
            <div class="panel-body">
                <c:if test="${requestScope.erroGravar != null}" >
                    <div class="alert alert-danger alert-dismissible">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <strong>${requestScope.erroGravar}</strong>
                    </div>
                </c:if>
                <form action="Home?ac=tipoExame_Save" method="POST">
                    <div class="col-lg-10">
                        <fieldset>
                            <legend>Dados do Tipo de Exame</legend>
                            <div class="form-group">
                                Nome do Exame: <input type="text" name="cpNomeExame" class="form-control" 
                                             value="${requestScope.retornoTipoExame != null ? requestScope.retornoTipoExame.nomeExame : ""}"/>
                            </div>
                            <div class="form-group">
                                Horas para Entrega <input type="number" name="cpHoraEntrega" class="form-control"
                                           value="${requestScope.retornoTipoExame !=null ? requestScope.retornoTipoExame.horasEntrega : ""}"/>
                            </div>
                            <div class="form-group">
                                Horas em Jejum <input type="number" name="cpHoraJejum" class="form-control"
                                           value="${requestScope.retornoTipoExame !=null ? requestScope.retornoTipoExame.horasJejum : ""}"/>
                            </div>
                            <div class="form-group">
                                Valor <input type="number" name="cpValor" class="form-control"
                                           value="${requestScope.retornoTipoExame !=null ? requestScope.retornoTipoExame.valor : ""}"/>
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
<%-- 
    Document   : examesUsuarioIndex
    Created on : 27/09/2017, 07:26:19
    Author     : Anderson2
--%>
<!DOCTYPE html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="pt-BR" />
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Lista de Exames de Clientes
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <c:if test="${requestScope.msgErro != null}" >
                    <div class="alert alert-danger alert-dismissible">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <strong>${requestScope.msgErro}</strong>
                    </div>
                </c:if>
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Codigo</th>
                                <th>Nome do Exame</th>
                                <th>Data do Exame</th>
                                <th>Data Prevista para Entrega</th>
                                <th>Exame Pronto?</th>
                                <th>Data que foi entregue</th>
                                <th>Valor do Exame</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.lstExamesUsuario}" var="exameUsuario">
                            <tr>
                                <td>${exameUsuario.id}</td>
                                <td>${exameUsuario.idexame.nomeExame}</td>
                                <td><fmt:formatDate value="${exameUsuario.dataExame}" pattern="dd/MM/yyyy HH:mm" /></td>
                                <td><fmt:formatDate value="${exameUsuario.dataEntregaPrevista}" pattern="dd/MM/yyyy HH:mm" /></td>
                                <td></td>
                                <td align="center">
                                    <a class="btn btn-info" title="Visualizar" href="Home?ac=exame_view&id=${exameUsuario.id}"><i class="fa fa-eye"></i> </a>
                                    <a class="btn btn-warning" title="Alterar" href="Home?ac=exame_alter&id=${exameUsuario.id}"><i class="fa fa-pencil-square-o"></i> </a>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.table-responsive -->
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-6 -->
</div>

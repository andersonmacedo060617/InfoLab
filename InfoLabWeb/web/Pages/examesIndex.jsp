<%-- 
    Document   : examesIndex
    Created on : 26/09/2017, 21:35:58
    Author     : aluno
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Lista de Exames
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <a class="btn btn-success" title="Novo Exame" href="Home?ac=exame_add"><i class="fa fa-plus"></i></a>
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Codigo</th>
                                <th>Nome do Exame</th>
                                <th>Horas em Jejum</th>
                                <th>Horas para Entrega</th>
                                <th>Valor do Exame</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.lstExames}" var="exame">
                            <tr>
                                <td>${exame.id}</td>
                                <td>${exame.nomeExame}</td>
                                <td>${exame.horasJejum}</td>
                                <td>${exame.horasEntrega}</td>
                                <td>${exame.valor}</td>
                                <td align="center">
                                    <a class="btn btn-info" title="Visualizar" href="Home?ac=exame_view&id=${exame.id}"><i class="fa fa-eye"></i> </a>
                                    <a class="btn btn-warning" title="Alterar" href="Home?ac=exame_alter&id=${exame.id}"><i class="fa fa-pencil-square-o"></i> </a>
                                    <a class="btn btn-danger" title="Apagar" href="Home?ac=exame_delete&id=${exame.id}"><i class="fa fa-trash"></i></a>
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

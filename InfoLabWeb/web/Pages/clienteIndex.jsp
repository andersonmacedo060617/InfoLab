<%-- 
    Document   : clienteIndex
    Created on : 16/09/2017, 21:30:35
    Author     : Anderson2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Lista de Clientes
            </div>
            
            <!-- /.panel-heading -->
            <div class="panel-body">
                <c:if test="${requestScope.msgSucesso != null}" >
                    <div class="alert alert-success alert-dismissible">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <strong>${requestScope.msgSucesso}</strong>
                    </div>
                </c:if>
                <a class="btn btn-success" title="Novo Cliente" href="Home?ac=cliente_add"><i class="fa fa-plus"></i></a>
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Cadastrar Exame</th>
                                <th>Codigo</th>
                                <th>Nome</th>
                                <th>CPF</th>
                                <th>Login</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.lstClientes}" var="cliente">
                            <tr>
                                <td>
                                    <a class="btn btn-success" title="Cadastrar Exame" href="Home?ac=exame_cliente_add&id=${cliente.id}"><i class="fa fa-plus"></i> <i class="fa fa-list-alt"></i></a>
                                </td>
                                <td>${cliente.id}</td>
                                <td>${cliente.nome}</td>
                                <td>${cliente.cpf}</td>
                                <td>${cliente.login}</td>
                                <td align="center">
                                    <a class="btn btn-info" title="Visualizar" href="Home?ac=cliente_view&id=${cliente.id}"><i class="fa fa-eye"></i> </a>
                                    <a class="btn btn-warning" title="Alterar" href="Home?ac=cliente_alter&id=${cliente.id}"><i class="fa fa-pencil-square-o"></i> </a>
                                    <a class="btn btn-danger" title="Apagar" href="Home?ac=cliente_delete&id=${cliente.id}"><i class="fa fa-trash"></i></a>
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

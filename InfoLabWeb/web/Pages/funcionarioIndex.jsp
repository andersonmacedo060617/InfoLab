<%-- 
    Document   : funcionarioIndex
    Created on : 16/09/2017, 21:59:35
    Author     : Anderson2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Lista de Funcionarios
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <a class="btn btn-success" title="Novo Cliente" href="Home?ac=funcionario_add"><i class="fa fa-plus"></i></a>
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>Codigo</th>
                                <th>Nome</th>
                                <th>CPF</th>
                                <th>Login</th>
                                <th>Sexo</th>
                                <th>Ativo</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.lstFuncionario}" var="funcionario">
                            <tr>
                                <td>${funcionario.id}</td>
                                <td>${funcionario.nome}</td>
                                <td>${funcionario.cpf}</td>
                                <td>${funcionario.login}</td>
                                <td>${funcionario.sexo}</td>
                                <td><c:if test="${funcionario.ativo}">
                                        <i class="fa fa-check-square-o" style="color: green;" title="Sim"></i>
                                    </c:if>
                                    <c:if test="${!funcionario.ativo}">
                                        <i class="fa fa-square-o" style="color: red;" title="Não"></i>
                                    </c:if>
                                </td>
                                <td align="center">
                                    <a class="btn btn-info" title="Visualizar" href="Home?ac=funcionario_view&id=${funcionario.id}"><i class="fa fa-eye"></i> </a>
                                    <a class="btn btn-warning" title="Alterar" href="Home?ac=funcionario_alter&id=${funcionario.id}"><i class="fa fa-pencil-square-o"></i> </a>
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

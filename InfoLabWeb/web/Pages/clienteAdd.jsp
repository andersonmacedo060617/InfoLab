<%-- 
    Document   : clienteAdd
    Created on : 16/09/2017, 22:34:19
    Author     : Anderson2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="row">
    <div class="col-lg-10">
        <div class="panel panel-green">
            <div class="panel-heading">
                Criar Cliente
            </div>
            <div class="panel-body">
                <c:if test="${requestScope.erroGravar != null}" >
                    <div class="alert alert-danger alert-dismissible">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <strong>${requestScope.erroGravar}</strong>
                    </div>
                </c:if>
                <form action="Home?ac=cliente_save" method="POST">
                    <div class="col-lg-10">
                        <div class="form-group">
                            Nome: <input type="text" name="cpNome" class="form-control" 
                                         value="${requestScope.retornoUsuario !=null ? requestScope.retornoUsuario.nome : ""}"/>
                        </div>
                        <div class="form-group">
                            CPF <input type="number" name="cpCpf" class="form-control"
                                       value="${requestScope.retornoUsuario !=null ? requestScope.retornoUsuario.cpf : ""}"/>
                        </div>
                        <div class="form-group">
                            Login: <input type="text" name="cpLogin" class="form-control"
                                          value="${requestScope.retornoUsuario !=null ? requestScope.retornoUsuario.login : ""}"/>
                        </div>
                        <div class="form-group">
                            Senha: <input type="password" name="cpSenha" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <a class="btn btn-info" href="Home?ac=cliente_index">Voltar</a>
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
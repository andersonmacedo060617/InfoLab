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
                        <fieldset>
                            <legend>Dados Pessoais</legend>
                            <div class="form-group">
                                Nome: <input type="text" name="cpNome" class="form-control" 
                                             value="${requestScope.retornoUsuario !=null ? requestScope.retornoUsuario.nome : ""}"/>
                            </div>
                            <div class="form-group">
                                CPF <input type="number" name="cpCpf" class="form-control"
                                           value="${requestScope.retornoUsuario !=null ? requestScope.retornoUsuario.cpf : ""}"/>
                            </div>
                            <div class="form-group">
                                Sexo:
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="rdSexo" id="rdSexo" value="masculino" ${requestScope.retornoUsuario !=null && requestScope.retornoUsuario.sexo == "Masculino" ? "Checked" : ""}/>Masculino
                                        </label>           
                                        <label>
                                            <input type="radio" name="rdSexo" id="rdSexo" value="feminino" ${requestScope.retornoUsuario !=null && requestScope.retornoUsuario.sexo == "Feminino" ? "Checked" : ""}/>Feminino
                                        </label>
                                    </div>
                            </div>
                        </fieldset>
                                        <fieldset>
                                            <legend>Endereço</legend>
                                            <div class="form-group">
                                                Rua: <input type="text" name="cpRua" class="form-control" 
                                                             value="${requestScope.retornoUsuario !=null ? requestScope.retornoEndereco.rua : ""}"/>
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="form-group">
                                                    Numero: <input type="text" name="cpNumero" class="form-control" 
                                                                 value="${requestScope.retornoUsuario !=null ? requestScope.retornoEndereco.numero : ""}"/>
                                                </div>
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="form-group">
                                                    Complemento: <input type="text" name="cpComplemento" class="form-control" 
                                                                 value="${requestScope.retornoUsuario !=null ? requestScope.retornoEndereco.complemento : ""}"/>
                                                </div>
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="form-group">
                                                    Bairro: <input type="text" name="cpBairro" class="form-control" 
                                                                 value="${requestScope.retornoUsuario !=null ? requestScope.retornoEndereco.bairro : ""}"/>
                                                </div>
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="form-group">
                                                    Cidade: <input type="text" name="cpCidade" class="form-control" 
                                                                 value="${requestScope.retornoUsuario !=null ? requestScope.retornoEndereco.cidade : ""}"/>
                                                </div>
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="form-group">
                                                    Estado: <input type="text" name="cpUf" class="form-control" 
                                                                 value="${requestScope.retornoUsuario !=null ? requestScope.retornoEndereco.uf : ""}"/>
                                                </div>
                                            </div>
                                            <div class="col-lg-6">
                                                <div class="form-group">
                                                    País: <input type="text" name="cpPais" class="form-control" 
                                                                 value="${requestScope.retornoUsuario !=null ? requestScope.retornoEndereco.pais : ""}"/>
                                                </div>
                                            </div>
                                        </fieldset> 

                        <fieldset>
                        <legend>Dados de usuario</legend>                    
                                        
                        <div class="form-group">
                            <label>Usuario Ativo:</label>
                            <input type="checkbox" name="ckAtivo" value="1" ${requestScope.retornoUsuario != null && requestScope.retornoUsuario.ativo ? "Checked" : ""}>
                        </div>
                                               
                                               
                        <div class="form-group">
                            Login: <input type="text" name="cpLogin" class="form-control"
                                          value="${requestScope.retornoUsuario !=null ? requestScope.retornoUsuario.login : ""}"/>
                        </div>
                        <div class="form-group">
                            Senha: <input type="password" name="cpSenha" class="form-control"/>
                        </div>
                        </fieldset>
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
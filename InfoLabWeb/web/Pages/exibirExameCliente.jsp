<%-- 
    Document   : exibirExameCliente
    Created on : 28/09/2017, 21:21:09
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row">
    <div class="col-lg-10">
        <div class="panel panel-green">
            <div class="panel-heading">
                Exame de <b>${requestScope.exameCliente.idexame.nomeExame}</b>
            </div>
            <div class="panel-body">
                <div class="col-lg-10">
                    <fieldset>
                        <legend>Dados do Exame</legend>
                        <table>
                            <tr>
                                <td>Codigo do Exame:</td>
                                <td>${requestScope.exameCliente.idexame.id}</td>
                            </tr>
                            <tr>
                                <td>Tipo de Exame:</td>
                                <td>${requestScope.exameCliente.idexame.nomeExame}</td>
                            </tr>
                            <tr>
                                <td>Data do Exame:</td>
                                <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${requestScope.exameCliente.dataExame}" /></td>
                            </tr>
                            <tr>
                                <td>Data do Prevista para entrega:</td>
                                <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${requestScope.exameCliente.dataEntregaPrevista}" /></td>
                            </tr>
                        </table>
                    </fieldset>
                    <div class="form-group">
                        <a class="btn btn-info" href="Home?ac=cliente_index">Voltar</a>
                    </div>
                </div>
            </div>
            <div class="panel-footer">
            </div>
        </div>
        <!-- /.col-lg-4 -->
    </div>
</div>
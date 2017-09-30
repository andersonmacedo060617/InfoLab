<%-- 
    Document   : exibirExameCliente
    Created on : 28/09/2017, 21:21:09
    Author     : aluno
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                                <td>${requestScope.exameCliente.id}</td>
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
                                <td>Horas de Jejum:</td>
                                <td>${requestScope.exameCliente.idexame.horasJejum}</td>
                            </tr>
                            <tr>
                                <td>Data do Prevista para entrega:</td>
                                <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${requestScope.exameCliente.dataEntregaPrevista}" /></td>
                            </tr>
                            <tr>
                                <td>
                                    Data que foi Entregue
                                </td>
                                <td>
                                    <c:if test="${requestScope.exameCliente.dataEntregaConcluida != null}">
                                        <fmt:formatDate value="${exameUsuario.dataEntregaConcluida}" pattern="dd/MM/yyyy HH:mm" />
                                    </c:if>
                                    <c:if test="${requestScope.exameCliente.dataEntregaConcluida == null}">
                                        <u>Exame não entregue.</u>
                                    </c:if>
                                </td>
                            </tr>
                            
                            <tr>
                                <td>Exame Pronto</td>
                                <td>
                                    <c:if test="${requestScope.exameCliente.examePronto}">
                                        <i class="fa fa-check-square-o fa-2x" style="color: green;" title="Sim"></i>
                                    </c:if>
                                    <c:if test="${!requestScope.exameCliente.examePronto}">
                                        <i class="fa fa-square-o fa-2x" style="color: red;" title="Não"></i>
                                    </c:if>
                                </td>
                            </tr>
                            
                            <c:if test="${requestScope.exameCliente.examePronto}">
                                <tr>
                                    <td>Data Exame Ficou Pronto</td>
                                    <td>
                                        <c:if test="${requestScope.exameCliente.dataExamePronto != null}">
                                            <fmt:formatDate value="${requestScope.exameCliente.dataExamePronto}" pattern="dd/MM/yyyy HH:mm" />
                                        </c:if>
                                        <c:if test="${requestScope.exameCliente.dataExamePronto == null}">
                                            <u>Exame não entregue.</u>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:if>
                            
                            
                            
                            <tr>
                                <td colspan="2">
                                    <hr>
                                </td>
                            </tr>
                            
                            <tr>
                                <td>Valor do Exame:</td>
                                <td>${requestScope.exameCliente.valor}</td>
                            </tr>
                            <tr>
                                <td>Está Pago?</td>
                                <td>
                                    <c:if test="${requestScope.exameCliente.examePago}">
                                        <i class="fa fa-check-square-o fa-2x" style="color: green;" title="Sim"></i>
                                    </c:if>
                                    <c:if test="${!requestScope.exameCliente.examePago}">
                                        <i class="fa fa-square-o fa-2x" style="color: red;" title="Não"></i>
                                    </c:if>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                    <div class="form-group">
                    <c:if test="${sessionScope.userCliente}">
                        <a class="btn btn-info" href="Home?ac=meus_exames">Voltar</a>
                    </c:if>
                    <c:if test="${!sessionScope.userCliente}">
                        <a class="btn btn-info" href="Home?ac=examesUsuario_Index">Voltar</a>
                        
                            <a class="btn btn-success" title="Efetuar Pagamento" 
                               href="Home?ac=exame_cliente_pagar&idExameCliente=${requestScope.exameCliente.id}">
                                <i class="fa fa-usd"></i>
                            </a>
                                
                            <button class="btn btn-success" title="Exame Pronto" data-toggle="modal" data-target="#modalExamePronto"
                                            ><i class="fa fa-thumbs-o-up"></i></button>
                            
                        </c:if>   
                    </div>
                        
                            
                     
                            
                </div>
            </div>
            <div class="panel-footer">
            </div>
        </div>
        <!-- /.col-lg-4 -->
    </div>
</div>
                            
                            
<div class="modal fade" id="modalExamePronto" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Exame Pronto</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          Informe a data que o exame ficou pronto <label id="nomeTipoExame"></label>
      </div>
      <div class="modal-footer">
          <form action="Home?ac=exame_cliente_pronto" method="POST">
              <input type="hidden" name="cpIdExameCliente" value="${requestScope.exameCliente.id}" />
            <div class="col-lg-4">
                <input type="date" name="cpDataExamePronto" class="form-control" /> 
            </div>
            <div class="col-lg-3">
                <input type="time" name="cpHoraExamePronto" class="form-control"/>
            </div>
            <p>
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            <input type="submit" class="btn btn-success" value="Enviar" />
            
        </form>
      </div>
    </div>
  </div>
</div>


<%-- 
    Document   : examesIndex
    Created on : 26/09/2017, 21:35:58
    Author     : aluno
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="pt-BR" />
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Lista de Exames
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <c:if test="${requestScope.msgErro != null}" >
                    <div class="alert alert-danger alert-dismissible">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <strong>${requestScope.msgErro}</strong>
                    </div>
                </c:if>
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
                                <td>${exame.horasJejum} Horas</td>
                                <td>${exame.horasEntrega} Horas</td>
                                <td><fmt:formatNumber value="${exame.valor}" type="currency" /></td>
                                <td align="center">
                                    <a class="btn btn-info" title="Visualizar" href="Home?ac=exame_view&idTipoExame=${exame.id}"><i class="fa fa-eye"></i> </a>
                                    <a class="btn btn-warning" title="Alterar" href="Home?ac=exame_alter&idTipoExame=${exame.id}"><i class="fa fa-pencil-square-o"></i> </a>
                                    <button class="btn btn-danger" title="Apagar" data-toggle="modal" data-target="#modalExcluirTipoExame"
                                            onclick="apagarTipoExame('${exame.id}', '${exame.nomeExame}');"><i class="fa fa-trash"></i></button>
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

<div class="modal fade" id="modalExcluirTipoExame" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Apagar Tipo de Exame</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          Deseja realmente apagar o tipo de exame <label id="nomeTipoExame"></label>
      </div>
      <div class="modal-footer">
          <form action="Home?ac=apagar_Tipoexame" method="POST">
            <input type="hidden" name="cpIdTipoExame" id="idTipoExame"/>
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
            <input type="submit" class="btn btn-danger" value="Apagar" />
        </form>
      </div>
    </div>
  </div>
</div>

<script>
    function apagarTipoExame(idTipoExame, NomeTipoExame){
        $("#idTipoExame").val(idTipoExame);
        $("#nomeTipoExame").html(NomeTipoExame);
    }
</script>
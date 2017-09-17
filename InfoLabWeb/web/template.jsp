<%-- 
    Document   : template
    Created on : 16/09/2017, 07:08:47
    Author     : Anderson2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <link href="img/icon02-2.png" rel="shortcut icon" type="image/x-icon" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Info Lab - Sistema de Laboratorios</title>

    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    
    <!-- MetisMenu CSS -->
    <link href="metisMenu/metisMenu.min.css" rel="stylesheet" type="text/css"/>
    
    <!-- Custom CSS -->
    <link href="css/estiloProjeto.css" rel="stylesheet" type="text/css"/>

    
    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="Home">Info Lab Web 1.0</a>
            </div>
            <!-- /.navbar-header -->
            <c:if test="${sessionScope.user == null}">
                <c:redirect url="/Home"/>
            </c:if>
            
            <c:if test="${sessionScope.user != null}">
                <c:if test="${sessionScope.userCliente}">
                    <jsp:include page="Pages/Componentes/menuTopCliente.jsp"/>
                    <jsp:include page="Pages/Componentes/menuLeftCliente.jsp"/>
                </c:if>
                <c:if test="${!sessionScope.userCliente}">
                    <jsp:include page="Pages/Componentes/menuTopFuncionario.jsp"/>
                    <jsp:include page="Pages/Componentes/menuLeftFuncionario.jsp"/>
                </c:if>
            </c:if>
            
        </nav>
        <div id="page-wrapper">
            
            <c:if test="${requestScope.erro != null}">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="alert alert-danger alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                            <strong>${requestScope.erro}</strong>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${param.page != null}">
                <jsp:include page="Pages/${param.page}.jsp"/>
            </c:if>
            
        </div>
    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="jquery/jquery.min.js" type="text/javascript"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="metisMenu/metisMenu.min.js" type="text/javascript"></script>
    

   

    <!-- Custom Theme JavaScript -->
    <script src="js/scriptProjeto.js" type="text/javascript"></script>
</body>

</html>

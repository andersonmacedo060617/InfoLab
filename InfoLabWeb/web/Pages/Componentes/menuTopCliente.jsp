<%-- 
    Document   : menuCliente
    Created on : 16/09/2017, 18:12:05
    Author     : Anderson2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<ul class="nav navbar-top-links navbar-right">
                
    <li>Acesso de Cliente</li><li> - Bem Vindo <b>${sessionScope.user.getNome()}</b></li>
    
    <!-- /.dropdown -->
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-user">
            <li><a href="Home?ac=logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
            </li>
        </ul>
        <!-- /.dropdown-user -->
    </li>
    <!-- /.dropdown -->
</ul>

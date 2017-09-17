<%-- 
    Document   : menuLeftFuncionario
    Created on : 16/09/2017, 19:23:16
    Author     : Anderson2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
            
            <li>
                <a href="Home"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-users"></i> Usuarios<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="Home?ac=cliente_Index">Clientes</a>
                    </li>
                    <li>
                        <a href="Home?ac=funcionario_Index">Funcionarios</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="Home?ac=exames_Index"><i class="fa fa-list-alt"></i> Exames</a>
            </li>
            
        </ul>
    </div>
    <!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->
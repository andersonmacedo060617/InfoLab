<%-- 
    Document   : template
    Created on : 16/09/2017, 07:08:47
    Author     : Anderson2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
 
 
</head>

<body>

    <div id="wrapper">

       
        <div id="page-wrapper">
            ${param.pagina}
            <br>
            ==>${ requestScope.pagina}
            <br>==> 
            <c:if test="${ requestScope.pagina != null}">
                
                <jsp:include page="Pages/${ requestScope.pagina}.jsp"/>
            </c:if>
                <c:if test="${requestScope.pagina == null}">
                    Ainda está nulo
                </c:if>
        </div>
    </div>
    
</body>

</html>

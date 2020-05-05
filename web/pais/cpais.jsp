<%-- 
    Document   : cpais
    Created on : 04/05/2020, 21:04:42
    Author     : LRR_1
--%>

<%@page import="DAO.DAOPais"%>
<%@page import="Model.Pais"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <%
            Pais objP = new Pais();
            objP.setNome(request.getParameter("nome"));
            objP.setSigla(request.getParameter("sigla"));
            DAOPais objDP = new DAOPais();
            objDP.CadastrarPais(objP);
            response.sendRedirect("cadpais.jsp");
            
        %>
        
    </body>
</html>

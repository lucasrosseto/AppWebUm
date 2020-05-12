<%-- 
    Document   : alogin
    Created on : 11/05/2020, 22:44:05
    Author     : LRR_1
--%>

<%@page import="Controller.CtrUsuarios"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Model.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pagina interna do sistema</h1>
        
        <%
            Usuarios objU = new Usuarios();
            List<Usuarios> lista = new ArrayList<Usuarios>();
            CtrUsuarios objCtr = new CtrUsuarios();
            
            objU.setLogin(request.getParameter("login"));
            objU.setSenha(request.getParameter("senha"));
            
            lista = objCtr.ListarUsuario(objU);
            
            for(int i=0; i<lista.size(); i++)
            {
                if(lista.size()==1)
                    out.print("Usuario Conectado");
                
            }
            
            if(lista.size()==0)
                    response.sendRedirect("login.jsp");
            
        %>
        
    </body>
</html>

<%-- 
    Document   : teste
    Created on : 18/05/2020, 20:10:32
    Author     : LRR_1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%
            HttpSession sessao = request.getSession();
            out.print(sessao.getAttribute("var_sessao_login"));
            
            if (sessao.getAttribute("var_sessao_login")==null)
                response.sendRedirect("login.jsp");
            
        %>
   
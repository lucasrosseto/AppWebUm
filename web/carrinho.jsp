<%-- 
    Document   : addproduto
    Created on : 01/06/2020, 20:37:32
    Author     : LRR_1
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Model.Cliente"%>
<%@page import="DAO.DAOProdutos"%>
<%@page import="Model.Produtos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <%@include file="validalogin.jsp"%>
        <%@include file="menu.jsp"%>
        
    </head>
    <body>
        
        
        <%
            
            //Produtos objP = new Produtos();
            List<Produtos> lista = new ArrayList<Produtos>();
            //objP.setId_produto(Integer.parseInt(request.getParameter("id_produto")));
            DAOProdutos objDAOP = new DAOProdutos();
            Cliente objC = new Cliente();
            objC.setId_cliente(Integer.parseInt(sessao.getAttribute("id_cliente").toString()));
            
            lista = objDAOP.ListarCarrinho(objC);
            
            for(int i=0; i<lista.size(); i++)
            {
            out.print("<form name='f' action='addpedido.jsp' method='POST'>");
            
            out.print("<h1>"+lista.get(i).getDescricao()+"</h1>");
            out.print("<p>Cod.(");
            out.print(lista.get(i).getId_produto());
            out.print("<input name='id_produto' type='hidden' value='"+lista.get(i).getId_produto()+"' />");
            out.print(")<br>");
            out.print(lista.get(i).getDescricao());
            out.print("<br>");
            out.print("R$ ");
            out.print(lista.get(i).getPreco());
            out.print("<input name='valor_venda' type='hidden' value='"+lista.get(i).getPreco()+"' />");
            out.print("<br>");
            out.print("Em estoque: ");
            out.print(lista.get(i).getEstoque());
            out.print("<br>");
            out.print("<select name='quantidade'>");
            for(int j=0;j<=lista.get(i).getEstoque(); j++)
            {
                if(j != 0)
                out.print("<option value='"+j+"'>"+j+"</option>");
            }
            out.print("</select>");
            out.print("<input type='submit' value='Comprar' />");
            
            out.print("</form>");
            }
        %>
      
        
    </body>
</html>

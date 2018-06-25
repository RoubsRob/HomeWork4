<%-- 
    Document   : Form_Compras_Excluir
    Created on : 09/12/2017, 20:01:01
    Author     : Roberta
--%>

<%@page import="br.DAO.Compras"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Excluir Compras</h1>
        <% Compras compras = (Compras) request.getAttribute("compras"); 
        %>
        <form action="ExcluirCompras" method="Post">
            
            <input type="hidden" name="id" value="<%=compras.getId()%>" >
            <br>
            Id cliente<br>
            <input type="text" name="idcliente" value="<%=compras.getIdcliente() %>" >
            <br>
            <br>
            Id produto<br>
            <input type="text" name="idproduto" value="<%=compras.getIdproduto() %>" >
            <br>
            <br>
            <input type="submit" value="Confirmar Exclusão">
            <br><a href="ListaCompras">Retorna</a>
        </form> 
    </body>
    
</html>

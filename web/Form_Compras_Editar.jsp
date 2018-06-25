<%-- 
    Document   : Form_Compras_Editar
    Created on : 17/12/2017, 22:04:20
    Author     : Roberta
--%>

<%@page import="br.DAO.Compras"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compras</title>
    </head>
    <body>
        <h1>Lista de Compras</h1>
        <h1>Alterar Dados de Compras</h1>
        <% Compras compras = (Compras) request.getAttribute("compras"); 
        %>
        <form action="EditarCompras" method="POST">
            
            <input type="hidden" name="id" value="<%=compras.getId()%>" >
            <br>
            Id cliente<br>
            <input type="text" name="idcliente" value="<%=compras.getIdcliente() %>" >
            <br>
            <br>
            Id produto<br>
            <input type="text" name="idproduto" value="<%=compras.getIdproduto() %>" >
            <br>
            <br><br>
            <input type="submit" value="Confirmar Editar">
            
            <form action="<% out.println(request.getAttribute("retorna"));%>" 
          method="POST">
        <input type="submit" value="Retornar">
    
        </form> 

    </body>
</html>

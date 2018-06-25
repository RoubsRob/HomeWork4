<%-- 
    Document   : Form_Compras_Visualizar
    Created on : 09/12/2017, 20:13:33
    Author     : Roberta
--%>

<%@page import="br.DAO.Compras"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Compras</title>
    </head>
<body>
<h1>Lista de Compras</h1>
        <h1>Dados de Compras</h1>
        <% Compras compras = (Compras) request.getAttribute("compras"); 
        %>
        <form action="ListaCompras" method="Post">
            
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
            <form action="<% out.println(request.getAttribute("retorna"));%>" 
                  method="POST"> <br>
    <form action="<% out.println(request.getAttribute("retorna"));%>" 
          method="POST">
        <input type="submit" value="Retornar"></form>
    
        </body> 
</html>

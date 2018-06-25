<%-- 
    Document   : Form_Categorias_Visualizar
    Created on : 16/12/2017, 17:11:01
    Author     : Roberta
--%>

<%@page import="br.DAO.Categorias"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title>
    </head>
<body>
<h1>Lista de Categorias</h1>
        <h1>Dados do Categorias</h1>
        <% Categorias categorias = (Categorias) request.getAttribute("categorias"); 
        %>
        <form action="ListaCategorias" method="Post">
            
            <input type="hidden" name="id" value="<%=categorias.getId()%>" >
            
            Descricao:<br>
            <input type="text" name="descricao" value="<%=categorias.getDescricao() %>" readonly="true" >
            <br>
            
            <br><br>
            <form action="<% out.println(request.getAttribute("retorna"));%>" 
          method="POST">
    <form action="<% out.println(request.getAttribute("retorna"));%>" 
          method="POST">
        <input type="submit" value="Retornar"></form>
    
        </body> 
    
        </html>

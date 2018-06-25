<%-- 
    Document   : Form_Categorias_Editar
    Created on : 16/12/2017, 17:10:48
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
        <h1>Alterar Dados do Categorias</h1>
        <% Categorias categorias = (Categorias) request.getAttribute("categorias"); 
        %>
        <form action="EditarCategorias" method="POST">
            
            <input type="hidden" name="id" value="<%=categorias.getId()%>" >
            
            Descricao<br>
            <input type="text" name="descricao" value="<%=categorias.getDescricao() %>" >
            <br>
            <br><br>
            <input type="submit" value="Confirmar Editar">
            
            <form action="<% out.println(request.getAttribute("retorna"));%>" 
          method="POST">
        <input type="submit" value="Retornar">
    
        </form> 

    </body>
</html>

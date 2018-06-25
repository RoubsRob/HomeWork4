<%-- 
    Document   : Form_Categorias_Excluir
    Created on : 09/12/2017, 20:00:46
    Author     : Roberta
--%>

<%@page import="br.DAO.Categorias"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir Categoria</title>
    </head>
    <body>
        <h1>Excluir Categorias</h1>
        <% Categorias categorias = (Categorias) request.getAttribute("categorias"); 
        %>
        <form action="ExcluirCategorias" method="Post">
            
            <input type="hidden" name="id" value="<%=categorias.getId()%>" >
            
            <input type="text" name="descricao" value="<%=categorias.getDescricao() %>" readonly="" >
            <br>
            <input type="submit" value="Confirmar Exclusão">
            <a href="ListaCategorias">Retorna</a>
        </form> 
    </body>
    
</html>

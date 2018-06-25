<%-- 
    Document   : Form_Produtos_Visualizar
    Created on : 09/12/2017, 20:15:18
    Author     : Roberta
--%>

<%@page import="br.DAO.Produtos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
    </head>
<body>
<h1>Lista de Produtos</h1>
        <h1>Dados do Produtos</h1>
        <% Produtos produtos = (Produtos) request.getAttribute("produtos"); 
        %>
        <form action="ListaProdutos" method="Post">
            
            <input type="hidden" name="id" value="<%=produtos.getId()%>" >
            
            Id Categoria:<br>
            <input type="text" name="idcategoria" value="<%=produtos.getIdcategoria() %>" readonly="true" >
            <br>
            Nome:<br>
            <input type="text" name="nome" value="<%=produtos.getNome()%>" readonly="true" >
            <br><br>
            Descricao:<br>
            <input type="text" name="descricao" value="<%=produtos.getDescricao()%>" readonly="true" >
            <br><br>
            Valor:<br>
            <input type="text" name="valor" value="<%=produtos.getValor()%>" readonly="true" >
            <br>
            <br>
            <form action="<% out.println(request.getAttribute("retorna"));%>" 
          method="POST">

        <a href="IncluirCarrinho?id=<%=produtos.getId()%>">Comprar</a>          

                
    <form action="<% out.println(request.getAttribute("retorna"));%>" 
          method="POST">
        <input type="submit" value="Retornar"></form>
          <br>
    
        </form> 
    </body>
        </html>

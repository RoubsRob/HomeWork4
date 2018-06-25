<%-- 
    Document   : Form_Produtos_Editar
    Created on : 17/12/2017, 20:56:05
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
<h1>Lista de Produtos</h1>
        <h1>Alterar Dados do Produtos</h1>
        <% Produtos produtos = (Produtos) request.getAttribute("produtos"); 
        %>
        <form action="EditarProdutos" method="POST" onsubmit="return testaProd();">
                    
            <input type="hidden" name="id" value="<%=produtos.getId()%>" >
            


            Nome<br>
            <input type="text" name="nome" value="<%=produtos.getNome()%>" >
            <br><br>
            Descricao<br>
            <input type="text" name="descricao" value="<%=produtos.getDescricao()%>" >
            <br><br>
            Valor<br>
            <input type="text" name="valor" value="<%=produtos.getValor()%>" >
            
            <br><br>
            Categoria: <select name="idcategoria" value="<%=produtos.getIdcategoria() %>">
            <option value="1">Eletrodomésticos</option>
            <option value="2">Informática</option>
            <option value="3">Eletroportateis</option>
            <option value="4">Smartphones</option>
            <br><br>
            <br><br>
            <input type="submit" value="Confirmar Editar">
            <form action="<% out.println(request.getAttribute("retorna"));%>" 
          method="POST">
                <br><br>
        <input type="submit" value="Retornar"></form>
    
        </form> 
<script src='arquivo.js' type='text/javascript'></script>
    </body>
</html>

<%-- 
    Document   : Form_Produtos_Excluir
    Created on : 09/12/2017, 20:03:03
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
        <h1>Excluir Produtos</h1>
        <% Produtos produtos = (Produtos) request.getAttribute("produtos"); 
        %>
        <form action="ExcluirProdutos" method="Post">
            
            <input type="hidden" name="id" value="<%=produtos.getId()%>" >
            
            Categoria: <select name="idcategoria" value="<%=produtos.getIdcategoria()%>">
            <option value="1">Eletrodomésticos</option>
            <option value="2">Informática</option>
            <option value="3">Eletroportateis</option>
            <option value="4">Smartphones</option>
            
            <br><br>
            Nome: <input type="text" name="nome" value="<%=produtos.getNome()%>">
            <br><br>
            Descrição: <input type="text" name="descricao" value="<%=produtos.getDescricao()%>">
            <br><br>
            Valor: <input type="text" name="valor" value="<%=produtos.getValor()%>">
            <br><br>

            <input type="submit" value="Confirmar Exclusão">
            <form action="<% out.println(request.getAttribute("retorna"));%>" 
          method="POST">
        <input type="submit" value="Retornar"></form>
    
          <br>
        <a href="areaRestritaLogin.jsp">Menu</a>
        
          
        </form> 
    </body>
</html>

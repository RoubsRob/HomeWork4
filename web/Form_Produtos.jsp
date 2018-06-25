<%-- 
    Document   : Form_Produtos
    Created on : 09/12/2017, 19:42:49
    Author     : Roberta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incluir Produto</title>
    </head>
        <body>
        <h1>Incluir Produtos</h1>
        <form action="IncluirProdutos" method="POST" onsubmit="return testaProd();">
            

            
            <br>
            <br>
            
            Nome:<input type="text" name="nome" >
            <br><br>
            Descrição: <input type="text" name="descricao" >
            <br><br>
            Valor: <input type="text" name="valor" >
            <br><br>
            
            Categoria: <select name="idcategoria">
            <option value="1">Eletrodomésticos</option>
            <option value="2">Informática</option>
            <option value="3">Eletroportateis</option>
            <option value="4">Smartphones</option>
            <br><br>
            <br><br>
            
            <input type="submit" value="Submit">
        </form> 
<script src='arquivo.js' type='text/javascript'></script>
        </body>

</html>

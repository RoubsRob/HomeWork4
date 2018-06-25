<%-- 
    Document   : Form_Categorias
    Created on : 09/12/2017, 19:31:14
    Author     : Roberta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incluir Categoria</title>
    </head>
   <body>
        <h1>Incluir Categoria</h1>
        <form action="IncluirCategorias" method="POST">
            
            Descricao:<br>
            <input type="text" name="descricao" >
            <br>
            <input type="submit" value="Submit">
        </form> 
    </body>
</html>

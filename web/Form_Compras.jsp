<%-- 
    Document   : Form_Compras
    Created on : 09/12/2017, 19:34:56
    Author     : Roberta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incluir Compras</title>
    </head>
   <body>
        <h1>Incluir Compras</h1>
        <form action="IncluirCompras" method="POST">
            
            Id Cliente:<br>
            <input type="text" name="idcliente" >
            <br>
            Id Produto:<br>
            <input type="text" name="idproduto" >
            <br>
            <input type="submit" value="Submit">
        </form> 
        <a href="index.jsp">Página inicial</a>
    </body>
</html>

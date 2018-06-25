<%-- 
    Document   : Form_Administrador
    Created on : 09/12/2017, 19:47:18
    Author     : Roberta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Administrador</title>
    </head>
    <body>
        <h1>Incluir Administrador</h1>
        <form action="IncluirAdministrador" method="POST" onsubmit="return testaLogin();">
            Login:<br>
            <input type="text" name="login" >
            <br>
            Senha:<br>
            <input type="text" name="senha" >
            <br><br>
            <input type="submit" value="Submit">
        </form> 
        <script src='arquivo.js' type='text/javascript'></script>
    </body>
</html>

<%-- 
    Document   : login_criar
    Created on : 17/12/2017, 23:02:49
    Author     : Roberta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar Login</title>
    </head>
<body>
        <h1>Criar Login</h1>
        <form action="IncluirLoginCliente" method="POST" onsubmit="return testaLogin();">
            Login:<br>
            <input type="text" name="login" >
            <br>
            Senha:<br>
            <input type="text" name="senha" >
            <br><br>
            <input type="submit" value="Submit">
        </form> 
        <br><br><a href="index.jsp">Página Inicial</a>
        
        <script src='arquivo.js' type='text/javascript'></script>
    </body>
</html>

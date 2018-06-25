<%-- 
    Document   : areaRestrita
    Created on : 15/12/2017, 00:47:49
    Author     : Roberta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Area Restrita</title>
    </head>
    <body>        Area restrita! 
        Login autorizado somente para administradores do site
            <form action="VerificarLogin" method="POST" onsubmit="return testaBusca();">
                Nome <input type="text" name="nome"> <br><br>
                Senha <input type="password" name="senha"><br><br>
        <input type="submit" value="Login">
            </form>
            <a href="index.jsp">Página inicial</a>
            
<script src='arquivo.js' type='text/javascript'></script>
        
        </body>

</html>

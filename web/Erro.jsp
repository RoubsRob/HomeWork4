<%-- 
    Document   : Erro
    Created on : 06/10/2017, 14:58:36
    Author     : Leo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro</title>
    </head>
    <body>
        <h1>Erro! Não Foi possível processar a solicitação</h1>
    
        <form action="<% out.println(request.getAttribute("retorna"));%>" 
          method="POST">
        <input type="submit" value="Retornar"></form>
    
    
    </body>
</html>

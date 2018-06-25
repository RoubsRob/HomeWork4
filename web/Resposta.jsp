<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resposta</title>
    </head>
    <body>
        <h1>Resposta</h1>
        <h1><% out.println(request.getAttribute("mensagem"));    %></h1>
        <p></p>
        <form action="<% out.println(request.getAttribute("retorna"));%>" 
          method="POST">
        <input type="submit" value="Retornar"></form>
    
    </body>
    
</html>

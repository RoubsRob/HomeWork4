<%-- 
    Document   : Form_Administrador_Editar
    Created on : 15/12/2017, 01:09:26
    Author     : Roberta
--%>

<%@page import="br.DAO.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Administrador</h1>
        <h1>Alterar Dados do Administrador</h1>
        <% Administrador administrador = (Administrador) request.getAttribute("administrador"); 
        %>
        <form action="EditarAdministrador" method="POST" onsubmit="return testaLogin();">
            
            <input type="hidden" name="id" value="<%=administrador.getId()%>" >
            
            Login:<br>
            <input type="text" name="login" value="<%=administrador.getLogin() %>" >
            <br>
            Senha:<br>
            <input type="text" name="senha" value="<%=administrador.getSenha()%>" >
            <br><br>
            <input type="submit" value="Confirmar Editar">
            
            <form action="<% out.println(request.getAttribute("retorna"));%>" 
          method="POST">
        <input type="submit" value="Retornar"></form>
    
        </form> 
        <script src='arquivo.js' type='text/javascript'></script>

    </body>
</html>

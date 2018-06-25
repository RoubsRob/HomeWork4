<%-- 
    Document   : Form_Administrador_Visualizar
    Created on : 09/12/2017, 20:10:37
    Author     : Roberta
--%>

<%@page import="br.DAO.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administradores</title>
    </head>
    <body>
<h1>Lista de Administradores</h1>
        <h1>Dados do Administrador</h1>
        <% Administrador administrador = (Administrador) request.getAttribute("administrador"); 
        %>
        <form action="ListaAdministrador" method="Post">
            
            <input type="hidden" name="id" value="<%=administrador.getId()%>" >
            
            <% if(request.getAttribute("erro_nome") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="login" value="<%=administrador.getLogin() %>" readonly="true" >
            <br>
            <% if(request.getAttribute("erro_idade") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_idade"));%></h3>        
            <% }%>
            Idade:<br>
            <input type="text" name="senha" value="<%=administrador.getSenha()%>" readonly="true" >
            <br><br>
            <form action="<% out.println(request.getAttribute("retorna"));%>" 
          method="POST">
                
    <form action="<% out.println(request.getAttribute("retorna"));%>" 
          method="POST">
        <input type="submit" value="Retornar"></form>
    
        </form> 
    </body>
</html>

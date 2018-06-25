<%-- 
    Document   : Form_Administrador_Excluir
    Created on : 09/12/2017, 20:04:49
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
    </head><h1>Lista de Administrador</h1>
    <body>
        <h1>Excluir Administrador</h1>
        <% Administrador administrador = (Administrador) request.getAttribute("administrador"); 
        %>
        <form action="ExcluirAdministrador" method="Post">
            
            <input type="hidden" name="id" value="<%=administrador.getId()%>" >
            
            <% if(request.getAttribute("erro_login") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_login"));%></h3>        
            <% }%>
            Nome:<br>
            <input type="text" name="login" value="<%=administrador.getLogin() %>" readonly="" >
            <br>
            <% if(request.getAttribute("erro_senha") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_senha"));%></h3>        
            <% }%>
            Idade:<br>
            <input type="text" name="senha" value="<%=administrador.getSenha()%>" readonly="" >
            <br><br>
            <input type="submit" value="Confirmar Exclusão">
            <form action="<% out.println(request.getAttribute("retorna"));%>" 
          method="POST">
        <input type="submit" value="Retornar"></form>
    
          <br>
        <a href="areaRestritaLogin.jsp">Menu</a>
        
          
        </form> 
    </body>
</html>

<%-- 
    Document   : ListaAdministradorView
    Created on : 15/12/2017, 01:15:34
    Author     : Roberta
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.DAO.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Administrador</title>
    </head>
    <body>
        <h1>Lista de Administradores</h1>
        <a href="Form_Administrador.jsp">Incluir Administrador</a>
        <p></p>
        <table>
            <thead>
            <th>Id</th>
            <th>Login</th>
            <th>Senha</th>
            <th>Ações</th>
        </thead>
        <%
            ArrayList<Administrador> resultado = (ArrayList) request.getAttribute("meusAdministradores");
            for (int i = 0; i < resultado.size(); i++) {
                Administrador aux = (Administrador)resultado.get(i);
        %>
        <tr>
        <td><%=aux.getId()%></td>
        <td><%=aux.getLogin()%></td> 
        <td><%=aux.getSenha()%></td>
        <td><a href="VisualizarAdministrador?id=<%=aux.getId()%>">Visualizar</a> | <a href="EditarAdministrador?id=<%=aux.getId()%>">Editar</a> | <a href="ExcluirAdministrador?id=<%=aux.getId()%>">Excluir</a></td>
        </tr>
        <%
            }
        %>

    </table>
        <br>
        <a href="areaRestritaLogin.jsp">Menu</a>
        
    </body>
</html>

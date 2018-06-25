<%-- 
    Document   : ListaCategoriasView
    Created on : 07/12/2017, 02:21:41
    Author     : Roberta
--%>

<%@page import="br.DAO.Categorias"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categorias</title>
    </head>
    <body>
    <h1>Lista de Categorias</h1>
        <a href="Form_Categorias.jsp">Incluir Categorias</a>
        <p></p>
        <table>
            <thead>
            <th>Id</th>
            <th>Descricao</th>
            <th>Ações</th>
        </thead>
        <%
            ArrayList<Categorias> resultado = (ArrayList) request.getAttribute("meusCategorias");
            for (int i = 0; i < resultado.size(); i++) {
                Categorias aux = (Categorias)resultado.get(i);
        %>
        <tr>
        <td><%=aux.getId()%></td>
        <td><%=aux.getDescricao()%></td> 
        <td><a href="VisualizarCategorias?id=<%=aux.getId()%>">Visualizar</a> | <a href="EditarCategorias?id=<%=aux.getId()%>">Editar</a> | <a href="ExcluirCategorias?id=<%=aux.getId()%>">Excluir</a></td>
        </tr>
        <%
            }
        %>
    </table>
    <br>
        <a href="areaRestritaLogin.jsp">Menu</a>
        
    </body>
</html>

<%-- 
    Document   : ListaComprasView
    Created on : 16/12/2017, 01:33:58
    Author     : Roberta
--%>

<%@page import="br.DAO.Carrinho"%>
<%@page import="br.DAO.Compras"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compras</title>
    </head>
    <body><h1>Compras</h1>
    
        <p></p>
        <table>
            <thead>
            <th>Id</th>
            <th>Id Cliente</th>
            <th>Id Produto</th>
            <th>Ações</th>
        </thead>
        
        <%
            
            ArrayList<Compras> resultado = (ArrayList) request.getAttribute("meusCompras");
            for (int i = 0; i < resultado.size(); i++) {
                Compras aux = (Compras)resultado.get(i);
                
        %>
        <tr>
            
        <td><%=aux.getId()%></td>
        <td><%=aux.getIdcliente()%></td> 
        <td><%=aux.getIdproduto()%></td>
        <td><a href="VisualizarCompras?id=<%=aux.getId()%>">Visualizar</a> | <a href="EditarCompras?id=<%=aux.getId()%>">Editar</a> | <a href="ExcluirCompras?id=<%=aux.getId()%>">Excluir</a></td>
        </tr>
        <%
            }
        %>

    </table>
       
<br>
        <a href="areaRestrita.jsp">Menu</a>
        
    </body>
</html>

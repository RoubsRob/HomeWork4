<%-- 
    Document   : ListaBuscaProdutosView
    Created on : 18/12/2017, 21:39:21
    Author     : Roberta
--%>

<%@page import="br.DAO.Produtos"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado da busca</title>
    </head>
    <body>
        <h1>Resultado da busca:</h1>
        <a href="menuCliente.jsp">Menu</a>
        <p></p>
        <table>
            <thead>
            <th>Id</th>
            <th>Id Categoria</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Valor</th>
            <th>Ações</th>
        </thead>
        
        <%
            ArrayList<Produtos> resultado = (ArrayList) request.getAttribute("meusProdutosBusca");
            for (int i = 0; i < resultado.size(); i++) {
                Produtos aux = (Produtos)resultado.get(i);
        %>
        <tr>
        <td><%=aux.getId()%></td>
        <td><%=aux.getIdcategoria()%></td> 
        <td><%=aux.getNome()%></td>
        <td><%=aux.getDescricao()%></td>
        <td><%=aux.getValor()%></td>
        <td><a href="VisualizarProdutos?id=<%=aux.getId()%>">Visualizar</a> | <a href="IncluirCarrinho?id=<%=aux.getId()%>">Comprar</a> </td>
        </tr>
        <%
            }
        %>

    </table>
<br>
        <a href="index.jsp">Página principal</a>
        
    </body>
</html>

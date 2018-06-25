<%-- 
    Document   : ListaProdutosView
    Created on : 16/12/2017, 01:34:56
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
        <title>Produtos</title>
    </head>
    <body>
        
        <h1>Lista de Produtos</h1>
        <a href="Form_Produtos.jsp">Incluir Produtos</a>
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
            ArrayList<Produtos> resultado = (ArrayList) request.getAttribute("meusProdutos");
            for (int i = 0; i < resultado.size(); i++) {
                Produtos aux = (Produtos)resultado.get(i);
        %>
        <tr>
        <td><%=aux.getId()%></td>
        <td><%=aux.getIdcategoria()%></td> 
        <td><%=aux.getNome()%></td>
        <td><%=aux.getDescricao()%></td>
        <td><%=aux.getValor()%></td>
        <td><a href="VisualizarProdutos?id=<%=aux.getId()%>">Visualizar</a> | <a href="EditarProdutos?id=<%=aux.getId()%>">Editar</a> | <a href="ExcluirProdutos?id=<%=aux.getId()%>">Excluir</a></td>
        </tr>
        <%
            }
        %>

    </table>
<br>
        <a href="areaRestritaLogin.jsp">Menu</a>
        
    </body>
</html>

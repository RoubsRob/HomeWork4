<%-- 
    Document   : ListaCarrinhoView
    Created on : 18/12/2017, 14:55:08
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
        <title>Carrinho</title>
    </head>
    <body>
        
        <body><h1>Meu carrinho</h1>
    BEM VINDO AO SEU CARRINHO, ${sessionScope.NomeUsuarioLogado}
        <p></p>
        <table>
            <thead>
            <th>Id Compra</th>
            <th>Id Cliente</th>
            <th>Id Produto</th>
            <th>Id Categoria</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Valor</th>
            <th>Ações</th>
        </thead>
        
        <%
            int total = 0;
            ArrayList<Carrinho> resultado = (ArrayList) request.getAttribute("meuCarrinho");
            for (int i = 0; i < resultado.size(); i++) {
                Carrinho aux = (Carrinho)resultado.get(i);
                total += aux.getValor();
        %>
        <tr>
            
        <td><%=aux.getIdcompra()%></td>
        <td><%=aux.getIdcliente()%></td> 
        <td><%=aux.getIdproduto()%></td>
        <td><%=aux.getIdcategoria()%></td>
        <td><%=aux.getNome()%></td>
        <td><%=aux.getDescricao()%></td>
        <td><%=aux.getValor()%>,00</td>
        <td><a href="VisualizarCompras?id=<%=aux.getIdcompra()%>">Visualizar</a> | <a href="ExcluirCarrinho?id=<%=aux.getIdcompra()%>">Excluir</a></td>
        </tr>
        <%
            }
        %>

    </table>
        Total: R$ <%=total%>,00<br><br>
        <a href="FinalizarCompra">Finalizar Compra</a>
<br>
        <a href="menuCliente.jsp">Menu</a>
        
    </body>
</html>
<%-- 
    Document   : ListaClientesView
    Created on : 16/12/2017, 01:25:54
    Author     : Roberta
--%>

<%@page import="br.DAO.Clientes"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
    </head>
<body>
    <h1>Lista de Clientes</h1>
        <a href="Form_Clientes.jsp">Incluir Clientes</a>
        <p></p>
        <table>
            <thead>
            <th>Id</th>
            <th>Nome</th>
            <th>Endereço</th>
            <th>Bairro</th>
            <th>CEP</th>
            <th>CPF</th>
            <th>Identidade</th>
            <th>Referencia</th>
            <th>Tel</th>
            <th>Cel</th>
            <th>Cartao de Crédito</th>
            <th>Bandeira Cartao</th>
            <th>Ações</th>
        </thead>
        <%
            ArrayList<Clientes> resultado = (ArrayList) request.getAttribute("meusClientes");
            for (int i = 0; i < resultado.size(); i++) {
                Clientes aux = (Clientes)resultado.get(i);
        %>
        <tr>
        <td> <%=aux.getId()%></td>
            <td><%=aux.getNome()%> </td>
            <td><%=aux.getEndereco()%> </td>
            <td><%=aux.getBairro()%> </td>
            <td><%=aux.getCep()%> </td>
            <td><%=aux.getCpf()%> </td>
            <td><%=aux.getIdentidade()%> </td>
            <td><%=aux.getReferencia()%> </td>
            <td><%=aux.getTel()%> </td>
            <td><%=aux.getCel()%> </td>
            <td><%=aux.getNumcartaocredito()%> </td>
            <td><%=aux.getBandeiracartao()%> </td>
            <td><a href="VisualizarClientes?id=<%=aux.getId()%>">Visualizar</a> | <a href="EditarClientes?id=<%=aux.getId()%>">Editar</a> | <a href="ExcluirClientes?id=<%=aux.getId()%>">Excluir</a></td>
        </tr>
        <%
            }
        %>
</table>
<br>
        <a href="areaRestritaLogin.jsp">Menu</a>
        
    </body>
</html>

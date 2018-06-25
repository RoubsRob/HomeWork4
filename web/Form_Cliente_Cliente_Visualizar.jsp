<%-- 
    Document   : Form_Cliente_Cliente_Visualizar
    Created on : 18/12/2017, 11:47:55
    Author     : Roberta
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="br.DAO.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        <h1>Lista de Clientess</h1>
        <a href="Form_Cadastro.jsp">Incluir Cadastro</a>
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
            System.out.println("entrouFormClienteVisual1"+session.getAttribute("id"));
            //int id = Integer.parseInt(
            int id = (Integer.parseInt(session.getAttribute("id").toString()) + 100);
            System.out.println("entrouFormClienteVisual"+id);
            ArrayList<Clientes> resultado = (ArrayList) request.getAttribute("meusClientes");
            for (int i = 0; i < resultado.size(); i++) {
                Clientes aux = (Clientes)resultado.get(i);
                if (aux.getId()==(id)){
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
            <td><a href="EditarCadastro?id=<%=aux.getId()%>">Editar</a> </td>
        </tr>
        <%
            }
        }
        %>
</table>
<br>
        <a href="menuCliente.jsp">Menu</a>
</html>

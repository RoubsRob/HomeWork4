<%-- 
    Document   : Form_Cadastro_Editar
    Created on : 18/12/2017, 12:06:22
    Author     : Roberta
--%>

<%@page import="br.DAO.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Clientes</h1>
        <h1>Alterar Dados do Clientes</h1>
        <% Clientes clientes = (Clientes) request.getAttribute("clientes"); 
        %>
        <form action="EditarClientes" method="POST">
            
            <input type="hidden" name="id" value="<%=clientes.getId()%>" >
            
            <br>
            Nome<br>
            <input type="text" name="nome" value="<%=clientes.getNome()%>">
            <br>
            Endereco<br>
            <input type="text" name="endereco" value="<%=clientes.getEndereco()%>">
            <br>
            Bairro:<br>
            <input type="text" name="bairro" value="<%=clientes.getBairro()%>">
            <br>
            CEP:<br>
            <input type="text" name="cep" value="<%=clientes.getCep()%>">
            <br>
            Estado:
            <select name="estado" value="<%=clientes.getEstado()%>">
            <option value="AC">AC</option>
            <option value="AL">AL</option>
            <option value="AM">AM</option>
            <option value="AP">AP</option>
            <option value="BA">BA</option>
            <option value="CE">CE</option>
            <option value="DF">DF</option>
            <option value="ES">ES</option>
            <option value="GO">GO</option>
            <option value="MA">MA</option>
            <option value="MG">MG</option>
            <option value="MS">MS</option>
            <option value="MT">MT</option>
            <option value="PA">PA</option>
            <option value="PB">PB</option>
            <option value="PE">PE</option>
            <option value="PI">PI</option>
            <option value="PR">PR</option>
            <option value="RJ">RJ</option>
            <option value="RN">RN</option>
            <option value="RO">RO</option>
            <option value="RR">RR</option>
            <option value="RS">RS</option>
            <option value="SC">SC</option>
            <option value="SE">SE</option>
            <option value="SP">SP</option>
            <option value="TO">TO</option>
            </select>            <br>
            Referencia:<br>
            <input type="text" name="referencia" value="<%=clientes.getReferencia()%>">
            <br>
            CPF:<br>
            <input type="text" name="cpf" value="<%=clientes.getCpf()%>">
            <br>
            Identidade:<br>
            <input type="text" name="identidade" value="<%=clientes.getIdentidade()%>" >
            <br>
            Telefone:<br>
            <input type="text" name="tel" value="<%=clientes.getTel()%>">
            <br>
            Celular:<br>
            <input type="text" name="cel" value="<%=clientes.getCel()%>">
            <br>
            Numero Cartão de Crédito<br>
            <input type="text" name="numcartaocredito" value="<%=clientes.getNumcartaocredito()%>">
            <br>
            Bandeira do Cartão de Crédito<br>
            <select name="bandeiracartao" value="<%=clientes.getBandeiracartao()%>">
            <option value="Visa">Visa</option>
            <option value="Mastercard">Mastercard</option>
            <option value="American Express">American Express</option>
            <option value="Elo">Elo</option>
            
            <br><br>
            <input type="submit" value="Submit">
        </form>
            
            <form action="<% out.println(request.getAttribute("retorna"));%>" 
          method="POST">
        <input type="submit" value="Retornar"></form>
    
        </form> 

    </body>
</html>

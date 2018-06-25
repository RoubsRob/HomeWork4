<%-- 
    Document   : Form_Cadastro
    Created on : 18/12/2017, 12:06:09
    Author     : Roberta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incluir Cadastro</title>
    </head>
    <form action="IncluirCadastro" method="POST" onsubmit="return testaCadastro2();">

            <br>
            Nome: <br>
            <input type="text" name="nome" >
            <br>
            Endereco: <br>
            <input type="text" name="endereco" >
            <br>
            Bairro: <br>
            <input type="text" name="bairro" >
            <br>
            CEP: <br>
            <input type="text" name="cep" >
            <br>
            Estado:
            <select name="estado">
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
            <input type="text" name="referencia" >
            <br>
            CPF:<br>
            <input type="text" name="cpf" >
            <br>
            Identidade:<br>
            <input type="text" name="identidade" >
            <br>
            Telefone:<br>
            <input type="text" name="tel" >
            <br>
            Celular:<br>
            <input type="text" name="cel" >
            <br>
            Numero Cartão de Crédito<br>
            <input type="text" name="numcartaocredito" >
            <br>
            Bandeira do Cartão de Crédito<br>
            <select name="bandeiracartao">
            <option value="Visa">Visa</option>
            <option value="Mastercard">Mastercard</option>
            <option value="American Express">American Express</option>
            <option value="Elo">Elo</option>
            
            <br><br>
            <input type="submit" value="Submit">
        </form> 

    <script src='arquivo.js' type='text/javascript'></script>

    </body>
</html>

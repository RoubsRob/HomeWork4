<%-- 
    Document   : areaRestritaLogin
    Created on : 07/12/2017, 16:02:20
    Author     : Roberta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Rules Store</title>
    </head>
    <body>
        <h1>Area restrita! 
<h1>SEJA BEM VINDO, ${sessionScope.NomeUsuarioLogado} <br>
            ESCOLHA UMA OPCAO PARA CONTINUAR</h1>
        
        <h1>
            
            <form action="ListaAdministrador" method="POST">
        <input type="submit" value="Menu Administrador"></form>
            
            <form action="ListaCategorias" method="POST">
        <input type="submit" value="Menu Categorias"></form>
            
            <form action="ListaClientes" method="POST">
        <input type="submit" value="Menu Clientes"></form>
            
            <form action="ListaCompras" method="POST">
        <input type="submit" value="Menu Compras"></form>

            <form action="ListaProdutos" method="POST">
                <input type="submit" value="Menu Produtos"></form><br><br>
                <br><br><br><br><br><br><br><br><br><br><br><br>
                <a href="index.jsp">Página principal</a>
        </body>

</html>

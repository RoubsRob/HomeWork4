<%-- 
    Document   : menuCliente
    Created on : 17/12/2017, 22:54:32
    Author     : Roberta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Cliente</title>
    </head>
    <body>
        
        <h1>SEJA BEM VINDO, ${sessionScope.NomeUsuarioLogado}
            ${sessionScope.id}<br>
            ESCOLHA UMA OPCAO PARA CONTINUAR</h1>
        
            <a href="Logout">Logout</a>

            <a href="ListaCadastros">Meu cadastro</a><br>
            <br>
            <a href="ListaCarrinho"><img src="kart.png" alt="Carrinho" width="50" height="50"/></a>

            <br>
    <a href="ListaEletrodomesticos">Eletrodomesticos</a>
        <a href="ListaInformatica">Informatica</a>
        <a href="ListaEletroportateis">Eletroportateis</a>
        <a href="ListaSmartphones">Smartphones</a><br>
        
        <form action="BuscaProduto" method="POST" onsubmit = "return testaForm();">
            
            <input type="text" name="campoBusca" >
        <input type="submit" value="PESQUISAR">
                    </form>
    <br><a href="index.jsp">Página Inicial</a>        
    
        <!-- Início JavaScript-->
<script type= "text/javascript">
function testaForm(){
	if (document.getElementsByName("campoBusca")[0].value == "" 
                || document.getElementsByName("campoBusca")[0].value.length < 2){
            alert("Entre com uma pesquisa válida!");
            return false;
	}
        return true;
}
</script>


    </body>
</html>

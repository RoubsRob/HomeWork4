<%-- 
    Document   : login
    Created on : 07/12/2017, 02:19:12
    Author     : Roberta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
    <form action="VerificarLoginCliente" method="POST" onsubmit="testaForm()">
        Login <input type="text" name="login"> <br><br>
        Senha <input type="password" name="senha"><br>
        <input type="submit" value="Login"></h1>
            </form>
        <br><br>
        <a href="login_criar.jsp">Criar Login</a><br><br><br>
        <a href="index.jsp">Página Inicial</a>
        
<!-- Início JavaScript-->
<script type= "text/javascript">
function testaForm(){
	if (document.getElementsByName("nome")[0].value == "" || document.getElementsByName("nome")[0].value.length < 2){
	alert("Entre com login corretamente!");
	return false;
	}
	if (document.getElementsByName("senha")[0].value == ""){
	alert("Entre com senha!");
	return false;
	}
        return true;
}
</script>

    </body>
</html>

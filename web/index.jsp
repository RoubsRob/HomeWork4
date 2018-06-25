<%-- 
    Document   : index
    Created on : 07/12/2017, 16:00:46
    Author     : Roberta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Rules Store</title>
        <link rel="stylesheet" type="text/css" href="estilo.css" />
    </head>
<body>
    <a href="areaRestrita.jsp"> Área Restrita</a>
    <a href="login.jsp"> Login</a><br><br>
    <h1>New Rules Store</h1><br><br>
                   
        <a href="ListaEletrodomesticos">Eletrodomesticos</a>
        <a href="ListaInformatica">Informatica</a>
        <a href="ListaEletroportateis">Eletroportateis</a>
        <a href="ListaSmartphones">Smartphones</a><br>
        
        
        <form action= "BuscaProduto" method= "POST" onsubmit = "return testaBusca();">
        <input type ="text" name= "campoBusca">
        <input type= "submit" value= "PESQUISAR">
                    </form>
        <br><br>
        
                    
           </div><h1>
       </div> 
        </div>
<script src='arquivo.js' type='text/javascript'></script>

</body>
</html>

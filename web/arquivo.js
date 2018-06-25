/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function testaBusca(){
	if (document.getElementsByName("campoBusca")[0].value == "" || 
                document.getElementsByName("campoBusca")[0].value.length < 2){
            alert("Entre com busca válida!");
            return false;

            }
        return true;
}
function testaLogin(){
	if (document.getElementsByName("login")[0].value == "" || 
                document.getElementsByName("login")[0].value.length < 2){
            alert("Entre com login válido!");
            return false;
            }
	if (document.getElementsByName("senha")[0].value == "" || 
                document.getElementsByName("senha")[0].value.length < 2){
            alert("Entre com senha válida!");
            return false;
        return true;    
    }
    }
    
    
function testaCadastro2(){
	if (document.getElementsByName("nome")[0].value == "" || document.getElementsByName("nome")[0].value.length < 4){
            alert("Entre com nome corretamente!");
            return false;
	}
	if (document.getElementsByName("endereco")[0].value == "" || document.getElementsByName("endereco")[0].value.length < 6){
	alert("Entre com endereço corretamente!");
	return false;
	}
	if (document.getElementsByName("bairro")[0].value == "" || document.getElementsByName("bairro")[0].value.length < 3){
	alert("Entre com bairro corretamente!");
	return false;
	}
	if (document.getElementsByName("cidade")[0].value == "" || document.getElementsByName("cidade")[0].value.length < 3){
	alert("Entre com cidade corretamente!");
	return false;
	}	
	if (document.getElementsByName("cep")[0].value == "" || document.getElementsByName("cep")[0].value.length < 8){
	alert("Entre com cep corretamente!");
	return false;
	}	
	if (document.getElementsByName("referencia")[0].value == "" || document.getElementsByName("referencia")[0].value.length < 3){
	alert("Entre com referencia corretamente!");
	return false;
	}
	if (document.getElementsByName("cpf")[0].value == "" || document.getElementsByName("cpf")[0].value.length < 11){
	alert("Entre com cpf corretamente!");
	return false;
	}
	if (document.getElementsByName("identidade")[0].value == "" || document.getElementsByName("identidade")[0].value.length < 5){
	alert("Entre com identidade corretamente!");
	return false;
	}	
	if (document.getElementsByName("fixo")[0].value == "" || document.getElementsByName("fixo")[0].value.length < 10){
	alert("Entre com telefone fixo corretamente!");
	return false;
	}
	if (document.getElementsByName("celular")[0].value == "" || document.getElementsByName("celular")[0].value.length < 11){
	alert("Entre com telefone celular corretamente!");
	return false;
	}
	if (document.getElementsByName("numCartao")[0].value == "" || document.getElementsByName("numCartao")[0].value.length < 16){
	alert("Entre com numeração de cartão corretamente!");
	return false;
	}  
	return true;
}


function testaProd(){ 
	if (document.getElementsByName("nome")[0].value == "" || 
                document.getElementsByName("nome")[0].value.length < 2){
            alert("Entre com nome válido!");
            return false;
            }
	if (document.getElementsByName("descricao")[0].value == "" || 
                document.getElementsByName("descricao")[0].value.length < 2){
            alert("Entre com descricao válida!");
            return false;
                }
	if (document.getElementsByName("valor")[0].value == "" || 
                document.getElementsByName("valor")[0].value.length < 2){
            alert("Entre com valor válida!");
            return false;
                }
	if (document.getElementsByName("idcategoria")[0].value == "") {
            alert("Entre com categoria válida!");
            return false;
                }
        return true;    
    }
    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Clientes;
import br.DAO.Clientes_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Roberta
 */
@WebServlet(name = "IncluirCadastro", urlPatterns = {"/IncluirCadastro"})
public class IncluirCadastro extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        String endereco = request.getParameter("endereco");
        String nome = request.getParameter("nome");
        String bairro = request.getParameter("bairro");
        String estado = request.getParameter("estado");
        String referencia = request.getParameter("referencia");
        String bandeiracartao = request.getParameter("bandeiracartao");
        
        System.out.println("entrou incl clientes");
        System.out.println("parametros:"+estado+bandeiracartao);
        
        try {
            HttpSession session = request.getSession();
            
            int id = Integer.parseInt(session.getAttribute("id").toString());
            
            int cep = Integer.parseInt(request.getParameter("cep"));
            int cpf = Integer.parseInt(request.getParameter("cpf"));
            int identidade = Integer.parseInt(request.getParameter("identidade"));
            int tel = Integer.parseInt(request.getParameter("tel"));
            int cel = Integer.parseInt(request.getParameter("cel"));
            int numcartaocredito = Integer.parseInt(request.getParameter("numcartaocredito"));
            request.setAttribute("erro_id", "");

                Clientes clientes = new Clientes(id,endereco,bairro,cep,estado,referencia,cpf,identidade,
                tel,cel,numcartaocredito,bandeiracartao,nome);
                Clientes_DAO clientes_dao = new Clientes_DAO();
                try {
                    clientes_dao.Inserir(clientes);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
                    request.setAttribute("retorna", "ListaCadastros");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }
            

        } catch (Exception e) {
            request.setAttribute("erro_cliente", "Erro cliente");
            RequestDispatcher rd = request.getRequestDispatcher("Form_Clientes.jsp");
            rd.forward(request, response);
        }

    }

}
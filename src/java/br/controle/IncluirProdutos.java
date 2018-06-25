/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;


import br.DAO.Produtos;
import br.DAO.Produtos_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Roberta
 */
@WebServlet(name = "IncluirProdutos", urlPatterns = {"/IncluirProdutos"})
public class IncluirProdutos extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        String descricao = request.getParameter("descricao");
        String nome = request.getParameter("nome");

        try {

            int idcategoria = Integer.parseInt(request.getParameter("idcategoria"));
            int valor = Integer.parseInt(request.getParameter("valor"));
            request.setAttribute("erro_id", "");

            if (descricao.isEmpty()) // verifica os dados
            {  // retorna para o formulario de contato

                if (descricao.isEmpty()) {
                    request.setAttribute("erro_descricao", "A descricao não pode ser vazio");
                }

                RequestDispatcher rd = request.getRequestDispatcher("Form_Produtos.jsp");
                rd.forward(request, response);
            } else {

                Produtos produtos = new Produtos(idcategoria, nome, descricao,valor);
                Produtos_DAO produtos_dao = new Produtos_DAO();
                try {
                    produtos_dao.Inserir(produtos);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
                    request.setAttribute("retorna", "ListaProdutos");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_descricao", "A descricao não pode ser vazio");
            RequestDispatcher rd = request.getRequestDispatcher("Form_Produtos.jsp");
            rd.forward(request, response);
        }

    }

}

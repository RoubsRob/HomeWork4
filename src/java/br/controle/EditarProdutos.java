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
@WebServlet(name = "EditarProdutos", urlPatterns = {"/EditarProdutos"})
public class EditarProdutos extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Produtos produtos = new Produtos(id);
        Produtos_DAO produtos_dao = new Produtos_DAO();
        try {
            produtos_dao.get(produtos);
            request.setAttribute("produtos", produtos);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Produtos_Editar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        int idcategoria = Integer.parseInt(request.getParameter("idcategoria"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        int valor = Integer.parseInt(request.getParameter("valor"));
        
        Produtos produtos = new Produtos(id, idcategoria,nome, descricao,valor);
        try {
            if (valor==0) // verifica os dados
            {  // retorna para o formulario de contato

                if (valor==0) {
                    request.setAttribute("erro_valor", "O valor produto não pode ser 0");
                }

                request.setAttribute("produtos", produtos);
                RequestDispatcher rd = request.getRequestDispatcher("Form_Produtos_Editar.jsp");
                rd.forward(request, response);
            } else {

                Produtos_DAO produtos_dao = new Produtos_DAO();
                try {
                    System.out.println("Entrou no editar prod2");
                    System.out.println("Parametro ID"+ id );
                    produtos_dao.Alterar(produtos);
                    request.setAttribute("mensagem", "Alterado Com Sucesso");
                    request.setAttribute("retorna", "ListaProdutos");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
//            request.setAttribute("erro_idproduto", "O id não pode ser vazia");
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Categorias;
import br.DAO.Categorias_DAO;
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
@WebServlet(name = "IncluirCategorias", urlPatterns = {"/IncluirCategorias"})

public class IncluirCategorias extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        String descricao = request.getParameter("descricao");

        Categorias categorias = new Categorias(descricao);
        Categorias_DAO categorias_dao = new Categorias_DAO();
                try {
                    categorias_dao.Inserir(categorias);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
                    request.setAttribute("retorna", "ListaCategorias");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

       
}


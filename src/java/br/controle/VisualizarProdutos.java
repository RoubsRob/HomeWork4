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
@WebServlet(name = "VisualizarProdutos", urlPatterns = {"/VisualizarProdutos"})
public class VisualizarProdutos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Produtos produtos = new Produtos(id);
        Produtos_DAO produtos_dao = new Produtos_DAO();
        try {
            System.out.println("Entrou visualizar prod2");
            produtos_dao.get(produtos);
            request.setAttribute("produtos", produtos);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Produtos_Visualizar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

}

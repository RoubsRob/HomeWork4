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
@WebServlet(name = "VisualizarCategorias", urlPatterns = {"/VisualizarCategorias"})
public class VisualizarCategorias extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Categorias categorias = new Categorias(id);
        Categorias_DAO categorias_dao = new Categorias_DAO();
        System.out.println("entrou visualizar categ");
        try {
            categorias_dao.get(categorias);
            request.setAttribute("categorias", categorias);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Categorias_Visualizar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

}


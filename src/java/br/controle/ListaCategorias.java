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
import java.util.ArrayList;
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
@WebServlet(name = "ListaCategorias", urlPatterns = {"/ListaCategorias"})
public class ListaCategorias extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Categorias_DAO categorias_dao = new Categorias_DAO();
        ArrayList<Categorias> meusCategorias = categorias_dao.Listar();
        request.setAttribute("meusCategorias", meusCategorias);
        RequestDispatcher rd = request.getRequestDispatcher("ListaCategoriasView.jsp");
        rd.forward(request, response);

    }

}

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
@WebServlet(name = "ListaInformatica", urlPatterns = {"/ListaInformatica"})
public class ListaInformatica extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Produtos_DAO produtos_dao = new Produtos_DAO();
        ArrayList<Produtos> meusProdutos = produtos_dao.ListarInformatica();
        request.setAttribute("meusInfo", meusProdutos);
        RequestDispatcher rd = request.getRequestDispatcher("ListaInformaticaView.jsp");
        rd.forward(request, response);

    }
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Produtos_DAO produtos_dao = new Produtos_DAO();
        ArrayList<Produtos> meusProdutos = produtos_dao.ListarInformatica();
        request.setAttribute("meusInfo", meusProdutos);
        RequestDispatcher rd = request.getRequestDispatcher("ListaInformaticaView.jsp");
        rd.forward(request, response);

    }

}

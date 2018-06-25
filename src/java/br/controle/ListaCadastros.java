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
@WebServlet(name = "ListaCadastros", urlPatterns = {"/ListaCadastros"})
public class ListaCadastros extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Clientes_DAO clientes_dao = new Clientes_DAO();
        ArrayList<Clientes> meusClientes = clientes_dao.Listar();
        request.setAttribute("meusClientes", meusClientes);
        RequestDispatcher rd = request.getRequestDispatcher("Form_Cliente_Cliente_Visualizar.jsp");
        rd.forward(request, response);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Clientes_DAO clientes_dao = new Clientes_DAO();
        ArrayList<Clientes> meusClientes = clientes_dao.Listar();
        request.setAttribute("meusClientes", meusClientes);
        RequestDispatcher rd = request.getRequestDispatcher("Form_Cliente_Cliente_Visualizar.jsp");
        rd.forward(request, response);

    }

}

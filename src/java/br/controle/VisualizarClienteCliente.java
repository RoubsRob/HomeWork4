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

/**
 *
 * @author Roberta
 */
@WebServlet(name = "VisualizarClienteCliente", urlPatterns = {"/VisualizarClienteCliente"})
public class VisualizarClienteCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        Clientes_DAO clientes_dao = new Clientes_DAO();
        try {

            //int id = Integer.parseInt(request.getParameter("id"));
            Clientes clientes = new Clientes();
            clientes_dao.get(clientes);
            request.setAttribute("clientes", clientes);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Cliente_Cliente_Visualizar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

}

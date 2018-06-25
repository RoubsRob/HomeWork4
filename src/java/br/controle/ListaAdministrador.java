/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Administrador;
import br.DAO.Administrador_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "ListaAdministrador", urlPatterns = {"/ListaAdministrador"})
public class ListaAdministrador extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Administrador_DAO administrador_dao = new Administrador_DAO();
        ArrayList<Administrador> meusAdministradores = administrador_dao.Listar();
        request.setAttribute("meusAdministradores", meusAdministradores);
        
        RequestDispatcher rd = request.getRequestDispatcher("ListaAdministradorView.jsp");

        rd.forward(request, response);
        

    }

}

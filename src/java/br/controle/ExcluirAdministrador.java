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
@WebServlet(name = "ExcluirAdministrador", urlPatterns = {"/ExcluirAdministrador"})
public class ExcluirAdministrador extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Administrador administrador = new Administrador(id);
        Administrador_DAO administrador_dao = new Administrador_DAO();
        try {
            administrador_dao.get(administrador);
            request.setAttribute("administrador", administrador);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Administrador_Excluir.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Administrador administrador = new Administrador(id);
        try {
                Administrador_DAO administrador_dao = new Administrador_DAO();
                try {
                    administrador_dao.Excluir(administrador);
                    request.setAttribute("mensagem", "Exclusão Com Sucesso");
                    request.setAttribute("retorna", "ListaAdministrador");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);
                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }

    }
}

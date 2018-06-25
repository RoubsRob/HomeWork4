/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Compras;
import br.DAO.Compras_DAO;
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
@WebServlet(name = "ExcluirCompras", urlPatterns = {"/ExcluirCompras"})
public class ExcluirCompras extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Compras compras = new Compras(id);
        Compras_DAO compras_dao = new Compras_DAO();
        try {
            
            System.out.println("entrou no excluir compras servlet");
            
            compras_dao.get(compras);
            request.setAttribute("compras", compras);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Carrinho_Excluir.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Compras compras = new Compras(id);
        try {
                Compras_DAO compras_dao = new Compras_DAO();
                try {
                    compras_dao.Excluir(compras);
                    request.setAttribute("mensagem", "Exclusão Com Sucesso");
                    request.setAttribute("retorna", "ListaCarrinho");
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

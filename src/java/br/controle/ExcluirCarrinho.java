/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Carrinho;
import br.DAO.Carrinho_DAO;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Roberta
 */
@WebServlet(name = "ExcluirCarrinho", urlPatterns = {"/ExcluirCarrinho"})
public class ExcluirCarrinho extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // Carrinho carrinho = new Carrinho(id,id_user);
        try {
            int id = Integer.parseInt(request.getParameter("id"));
        
            HttpSession session = request.getSession();
            int id_user = Integer.parseInt(session.getAttribute("id").toString());

            System.out.println("entrou no excluir compras servletPost");
            
            Carrinho_DAO carrinho_dao = new Carrinho_DAO();
                try {
                    
                    System.out.println("Entrou no excluir carrinho");
                    
                    carrinho_dao.Excluir(id,id_user);
                    request.setAttribute("mensagem", "Exclusão Com Sucesso");
                    request.setAttribute("retorna", "ListaCarrinho");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);
                } catch (Exception e) {
                    request.setAttribute("retorna", "ListaCarrinho"); 
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }

    }

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Carrinho carrinho = new Carrinho(id);
        Carrinho_DAO carrinho_dao = new Carrinho_DAO();
               
        try {
            carrinho_dao.get(carrinho);
            request.setAttribute("meuCarrinho", carrinho);
            request.setAttribute("retorna", "ListaCarrinho");
            RequestDispatcher rd = request.getRequestDispatcher("Form_Carrinho_Excluir.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }


}

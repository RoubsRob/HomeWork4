/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Carrinho_DAO;
import br.DAO.Compras;
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
@WebServlet(name = "IncluirCarrinho", urlPatterns = {"/IncluirCarrinho"})
public class IncluirCarrinho extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int idproduto = Integer.parseInt(request.getParameter("id"));
            HttpSession session = request.getSession();
            int idcliente = Integer.parseInt(session.getAttribute("id").toString());
                
            Compras compras = new Compras(idcliente, idproduto);
            Carrinho_DAO carrinho_dao = new Carrinho_DAO();
            
            
//            RequestDispatcher rd = request.getRequestDispatcher("ListaCarrinhoView.jsp");
            
            
            try {
                    carrinho_dao.Inserir(compras);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
                    request.setAttribute("retorna", "ListaCarrinho");
                    RequestDispatcher rp = request.getRequestDispatcher("Resposta.jsp");
                    rp.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rdd = request.getRequestDispatcher("Erro.jsp");
                    rdd.forward(request, response);
                }

            

        } catch (Exception e) {
            RequestDispatcher rdd = request.getRequestDispatcher("Erro.jsp");
            rdd.forward(request, response);}

    }

}

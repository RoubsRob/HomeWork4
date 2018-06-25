/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Categorias;
import br.DAO.Categorias_DAO;
import br.DAO.Produtos;
import br.DAO.Produtos_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Roberta
 */
@WebServlet(name = "BuscaProduto", urlPatterns = {"/BuscaProduto"})
public class BuscaProduto extends HttpServlet {

    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String descricao = request.getParameter("campoBusca");
        
        Produtos produtos = new Produtos();
        Produtos_DAO produtos_dao = new Produtos_DAO();
        
        try {
            
                Cookie meuCookie = new Cookie("Pesquisa", descricao);
                meuCookie.setMaxAge(60*30);
                response.addCookie(meuCookie);

            
                ArrayList<Produtos> meusProdutos = new ArrayList();
                meusProdutos = produtos_dao.ListarBusca(descricao);
                request.setAttribute("meusProdutosBusca", meusProdutos);
                RequestDispatcher rd = request.getRequestDispatcher("ListaBuscaProdutosView.jsp");
                rd.forward(request, response);

                } catch (Exception e) {
                    request.setAttribute("mensagem", "Não foi possível efetuar a busca");
                    request.setAttribute("retorna", "ListaProdutos");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                }
}



protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String descricao = request.getParameter("campoBusca");
        
        Produtos produtos = new Produtos();
        Produtos_DAO produtos_dao = new Produtos_DAO();
        
        try {
                ArrayList<Produtos> meusProdutos = new ArrayList();
                meusProdutos = produtos_dao.ListarBusca(descricao);
                request.setAttribute("meusProdutosBusca", meusProdutos);
                RequestDispatcher rd = request.getRequestDispatcher("ListaBuscaProdutosView.jsp");
                rd.forward(request, response);

                } catch (Exception e) {
                    request.setAttribute("mensagem", "Não foi possível efetuar a busca");
                    request.setAttribute("retorna", "ListaProdutos");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                }

            }


}

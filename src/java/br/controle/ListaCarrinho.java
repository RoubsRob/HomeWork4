/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Carrinho;
import br.DAO.Carrinho_DAO;
import br.controle.ListaProdutos;
import br.DAO.Compras;
import br.DAO.Compras_DAO;
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
@WebServlet(name = "ListaCarrinho", urlPatterns = {"/ListaCarrinho"})
public class ListaCarrinho extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try{
        HttpSession session = request.getSession();
        int id = Integer.parseInt(session.getAttribute("id").toString());
                
        

        Carrinho_DAO carrinho_dao = new Carrinho_DAO();
        ArrayList<Carrinho> meusCompras = carrinho_dao.ListarCompras(id);
        request.setAttribute("meuCarrinho", meusCompras);
        request.setAttribute("retorna", "ListaProdutos");
        RequestDispatcher rd = request.getRequestDispatcher("ListaCarrinhoView.jsp");
        rd.forward(request, response);    
        } catch (Exception e){
                request.setAttribute("retorna", "ListaProdutos");
                RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                rd.forward(request, response);  
        }
    }
    
    
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        HttpSession session = request.getSession();
        int id = Integer.parseInt(session.getAttribute("id").toString());
                
        
        Carrinho_DAO carrinho_dao = new Carrinho_DAO();
        ArrayList<Carrinho> meusCompras = carrinho_dao.ListarCompras(id);
        request.setAttribute("meuCarrinho", meusCompras);
        request.setAttribute("retorna", "ListaProdutos");
        RequestDispatcher rd = request.getRequestDispatcher("ListaCarrinhoView.jsp");
        rd.forward(request, response);    
 
        } 
        catch (Exception e){
        request.setAttribute("retorna", "ListaProdutos");
        RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
        rd.forward(request, response);    
            
        }

}
}

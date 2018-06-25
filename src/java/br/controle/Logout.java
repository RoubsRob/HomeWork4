/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Administrador_DAO;
import br.DAO.ClienteLogin;
import br.DAO.ClienteLogin_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Roberta
 */
@WebServlet(name = "Logout", urlPatterns = {"/Logout"})
public class Logout extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        System.out.println("Entrou no VERIFICAR LOGIN!!!");
try{ 
                HttpSession session = request.getSession();
                session.removeAttribute("NomeUsuarioLogado");
                session.removeAttribute("logado");
                
                request.setAttribute("mensagem", "Deslogado!");

                RequestDispatcher resposta = request.getRequestDispatcher("/index.jsp");
                resposta.forward(request, response);
            
    }catch (Exception e){
    System.out.println("ERRO NO logout");
    request.setAttribute("mensagem", "Erro!");
    request.setAttribute("retorna", "ListaCadastros");
    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");

}
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    try{ 
                    HttpSession session = request.getSession();
                    session.removeAttribute("NomeUsuarioLogado");
                    session.removeAttribute("logado");

                    request.setAttribute("mensagem", "Deslogado!");

                    RequestDispatcher resposta = request.getRequestDispatcher("/index.jsp");
                    resposta.forward(request, response);

        }catch (Exception e){
        System.out.println("ERRO NO logout");
        request.setAttribute("mensagem", "Erro!");
        request.setAttribute("retorna", "ListaCadastros");
        RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
        }

}
}

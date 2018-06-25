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
@WebServlet(name = "VerificarLogin", urlPatterns = {"/VerificarLogin"})
public class VerificarLogin extends HttpServlet {
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

try{
       
        String nome_user = request.getParameter("nome");
        String senha_user = request.getParameter("senha");
        try {
            
            if(Administrador_DAO.SenhaCorreta(nome_user, senha_user)){  

                Administrador administrador = new Administrador (nome_user, senha_user);
                Administrador_DAO.getid(administrador); 
                int id = administrador.getId();
                
                
                HttpSession session = request.getSession();
                session.setAttribute("NomeUsuarioLogado", nome_user);
                session.setAttribute("logado", "ok");
                session.setAttribute("id", id);
                
                Cookie meuCookie = new Cookie("Nome", nome_user);
                meuCookie.setMaxAge(60*30);
                response.addCookie(meuCookie);

                RequestDispatcher resposta = request.getRequestDispatcher("/areaRestritaLogin.jsp");
                resposta.forward(request, response);
            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VerificarLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }catch (Exception e){
    System.out.println("ERRO NO LOGIN");
}
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.sendRedirect("index.jsp");
    }

}

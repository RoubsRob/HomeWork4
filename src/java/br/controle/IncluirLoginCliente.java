/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.ClienteLogin;
import br.DAO.ClienteLogin_DAO;
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
@WebServlet(name = "IncluirLoginCliente", urlPatterns = {"/IncluirLoginCliente"})
public class IncluirLoginCliente extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        ClienteLogin clientelogin = new ClienteLogin(login,senha);
        ClienteLogin_DAO clientelogin_dao = new ClienteLogin_DAO();
        
        try {
            clientelogin_dao.Inserir(clientelogin);

            System.out.println("Entrou login cliente!!!!"+ login+ senha);

            
            request.setAttribute("mensagem", "Inclusão Com Sucesso");
            request.setAttribute("retorna", "Logout");
        
            
            RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }

    }
}



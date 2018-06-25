/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Administrador_DAO;
import br.DAO.Administrador;
import br.DAO.Clientes_DAO;
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
@WebServlet(name = "VerificarLoginCliente", urlPatterns = {"/VerificarLoginCliente"})
public class VerificarLoginCliente extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        System.out.println("Entrou no VERIFICAR LOGIN!!!");
try{
        //Clientes cliente = new Clientes();
       // Clientes_DAO admin = Clientes_DAO.Listar();
       
        String nome_user = request.getParameter("login");
        String senha_user = request.getParameter("senha");
        System.out.println("Login e senha do parametro cliente: "+ nome_user + ""+ senha_user);
        ClienteLogin clientelogin = new ClienteLogin(nome_user, senha_user);
        ClienteLogin_DAO clienteLogin_dao = new ClienteLogin_DAO();
        
        Administrador_DAO administrador_dao = new Administrador_DAO();
        
        
        try {
            //if (Clientes_DAO.SenhaCorreta(nome_user, senha_user)){
            System.out.println("Login e senha do parametro cliente2: "+ nome_user + ""+ senha_user);
        
            if(administrador_dao.SenhaCorreta(nome_user,senha_user)){  
//    senha_user.equals(cliente.Consulta(cliente))

System.out.println("Login e senha do parametro cliente3: "+ nome_user + ""+ senha_user);

                Administrador administrador = new Administrador(nome_user, senha_user);
                Administrador_DAO.getid(administrador); 
                int id = administrador.getId();
                
                
                System.out.println("id user = "+id);

                HttpSession session = request.getSession();
                session.setAttribute("NomeUsuarioLogado", nome_user);
                session.setAttribute("logado", "ok");
                session.setAttribute("id", id);
                
                request.setAttribute ("id",id);
                
                //Cookie meuCookie = new Cookie("Nome", nome_user);
                //meuCookie.setMaxAge(60*30);
                //response.addCookie(meuCookie);
                
                System.out.println("ENTROU LOGIN cliente!!");

                request.setAttribute("mensagem", "Logado!");

                RequestDispatcher resposta = request.getRequestDispatcher("/menuCliente.jsp");
                resposta.forward(request, response);
            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(VerificarLoginCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }catch (Exception e){
    System.out.println("ERRO NO LOGIN");
    request.setAttribute("mensagem", "Usuário ou senha incorretos!");
    request.setAttribute("retorna", "ListaProdutos");
    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");

}
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.sendRedirect("index.jsp");
    }

}

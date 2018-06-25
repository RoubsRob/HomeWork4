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
@WebServlet(name = "EditarCompras", urlPatterns = {"/EditarCompras"})
public class EditarCompras extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Compras compras = new Compras(id);
        Compras_DAO compras_dao = new Compras_DAO();
        try {
            compras_dao.get(compras);
            request.setAttribute("compras", compras);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Compras_Editar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        int idcliente = Integer.parseInt(request.getParameter("idcliente"));
        int idproduto = Integer.parseInt(request.getParameter("idproduto"));
        
        Compras compras = new Compras(id, idcliente,idproduto);
        
        
        try {
            if (idcliente==0) // verifica os dados
            {  // retorna para o formulario de contato

                if (idcliente==0) {
                    request.setAttribute("erro_idcliente", "O id cliente não pode ser vazia");
                }

                request.setAttribute("compras", compras);
                RequestDispatcher rd = request.getRequestDispatcher("Form_Compras_Editar.jsp");
                rd.forward(request, response);
            } else {

                Compras_DAO compras_dao = new Compras_DAO();
                try {
                    compras_dao.Alterar(compras);

                    request.setAttribute("mensagem", "Alterado Com Sucesso");
                    request.setAttribute("retorna", "ListaCompras");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_id", "O id não pode ser vazia");
            RequestDispatcher rd = request.getRequestDispatcher("Form_compras.jsp");
            rd.forward(request, response);
        }

    }

}

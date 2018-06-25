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
@WebServlet(name = "IncluirCompras", urlPatterns = {"/IncluirCompras"})
public class IncluirCompras extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // pegando os parâmetros do request
        try {

            int idcliente = Integer.parseInt(request.getParameter("idcliente"));
            int idproduto = Integer.parseInt(request.getParameter("idproduto"));

            if (idcliente==0 || idproduto==0 ) // verifica os dados
            {  // retorna para o formulario de contato

                if (idcliente==0 || idproduto==0) {
                    request.setAttribute("erro_id", "O idcliente e idproduto não podem ser vazios");
                }

                RequestDispatcher rd = request.getRequestDispatcher("Form_Compras.jsp");
                rd.forward(request, response);
            } else {

                Compras compras = new Compras(idcliente, idproduto);
                Compras_DAO compras_dao = new Compras_DAO();
                try {
                    compras_dao.Inserir(compras);
                    request.setAttribute("mensagem", "Inclusão Com Sucesso");
                    request.setAttribute("retorna", "ListaCompras");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_id", "O id não pode ser vazio");
            RequestDispatcher rd = request.getRequestDispatcher("Form_Compras.jsp");
            rd.forward(request, response);
        }

    }

}

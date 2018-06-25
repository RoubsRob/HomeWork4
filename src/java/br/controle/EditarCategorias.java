/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Categorias;
import br.DAO.Categorias_DAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leo
 */
@WebServlet(name = "EditarCategorias", urlPatterns = {"/EditarCategorias"})
public class EditarCategorias extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Categorias categorias = new Categorias(id);
        Categorias_DAO categorias_dao = new Categorias_DAO();
        try {
            categorias_dao.get(categorias);
            request.setAttribute("categorias", categorias);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Categorias_Editar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String descricao = request.getParameter("descricao");

        Categorias categorias = new Categorias(id, descricao);
        try {
            if (descricao.isEmpty()) // verifica os dados
            {  // retorna para o formulario de contato

                if (descricao.isEmpty()) {
                    request.setAttribute("erro_nome", "A descricao não pode ser vazia");
                }

                request.setAttribute("categorias", categorias);
                RequestDispatcher rd = request.getRequestDispatcher("Form_Categorias_Editar.jsp");
                rd.forward(request, response);
            } else {

                Categorias_DAO categorias_dao = new Categorias_DAO();
                try {
                    categorias_dao.Alterar(categorias);
                    request.setAttribute("mensagem", "Alterado Com Sucesso");
                    request.setAttribute("retorna", "ListaCategorias");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_descricao", "A descricao não pode ser vazia");
            RequestDispatcher rd = request.getRequestDispatcher("categorias.jsp");
            rd.forward(request, response);
        }

    }

}

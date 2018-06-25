/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.DAO.Clientes;
import br.DAO.Clientes_DAO;
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
@WebServlet(name = "EditarClientes", urlPatterns = {"/EditarClientes"})
public class EditarClientes extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Clientes clientes = new Clientes(id);
        Clientes_DAO clientes_dao = new Clientes_DAO();
        try {
            clientes_dao.get(clientes);
            request.setAttribute("clientes", clientes);

            RequestDispatcher rd = request.getRequestDispatcher("Form_Clientes_Editar.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String endereco = request.getParameter("endereco");
        String bairro = request.getParameter("bairro");
        int cep = Integer.parseInt(request.getParameter("cep"));
        String estado = request.getParameter("estado");
        String referencia = request.getParameter("referencia");
        int cpf = Integer.parseInt(request.getParameter("cpf"));
        int identidade = Integer.parseInt(request.getParameter("identidade"));
        int tel = Integer.parseInt(request.getParameter("tel"));
        int cel = Integer.parseInt(request.getParameter("cel"));
        int numcartaocredito = Integer.parseInt(request.getParameter("numcartaocredito"));
        String bandeiracartao = request.getParameter("bandeiracartao");
        String nome = request.getParameter("nome");
        
        Clientes clientes = new Clientes(id, endereco,bairro,
        cep,estado,referencia,cpf,identidade,tel,cel,numcartaocredito,bandeiracartao,nome);
        
        System.out.println("criou cliente" + clientes.getBandeiracartao());
        
        try {
            if (nome.isEmpty()) // verifica os dados
            {  // retorna para o formulario de contato

                if (nome.isEmpty()) {
                    request.setAttribute("erro_nome", "O nome não pode ser vazia");
                }

                request.setAttribute("clientes", clientes);
                RequestDispatcher rd = request.getRequestDispatcher("Form_Clientes_Editar.jsp");
                rd.forward(request, response);
            } else {

                Clientes_DAO clientes_dao = new Clientes_DAO();
                try {
                    clientes_dao.Alterar(clientes);
                    request.setAttribute("mensagem", "Alterado Com Sucesso");
                    request.setAttribute("retorna", "ListaClientes");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);

                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            }

        } catch (Exception e) {
            request.setAttribute("erro_id", "O id não pode ser vazia");
            RequestDispatcher rd = request.getRequestDispatcher("clientes.jsp");
            rd.forward(request, response);
        }

    }

}

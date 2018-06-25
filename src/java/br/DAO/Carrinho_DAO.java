/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Roberta
 */
@WebServlet(name = "Carrinho_DAO", urlPatterns = {"/Carrinho_DAO"})
public class Carrinho_DAO extends HttpServlet {
    public void Inserir(Compras compras) throws Exception {
        Conexao conexao = new Conexao();
            
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO COMPRAS (idcliente, idproduto) VALUES (?,?)");
            sql.setInt(1, compras.getIdcliente());
            sql.setInt(2, compras.getIdproduto());
            sql.executeUpdate();
            
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Carrinho get(Carrinho carrinho) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("select * from compras as c join produto as p on c.idproduto = p.id WHERE C.ID = ?");
            
            sql.setInt(1, carrinho.getIdcompra());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    
                    System.out.println("Entrou no get carrinho 2");
                    
                    carrinho.setIdcompra(resultado.getInt("id"));
                    carrinho.setIdcliente(resultado.getInt("Idcliente"));
                    carrinho.setIdproduto(resultado.getInt("IDPRODUTO"));
                    carrinho.setIdcategoria(resultado.getInt("idcategoria"));
                    carrinho.setNome(resultado.getString("NOME"));
                    carrinho.setDescricao(resultado.getString("DESCRICAO"));
                    carrinho.setValor(resultado.getInt("VALOR"));
                    
                }
            }
            return carrinho;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Compras compras) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE COMPRAS SET idcliente = ? , idproduto = ? WHERE ID = ? ");
            sql.setInt(1, compras.getIdcliente());
            sql.setInt(2, compras.getIdproduto());
            sql.setInt(3, compras.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(int idproduto, int idcliente) {
        //ArrayList<Carrinho> meuCarrinho = new ArrayList();
        Conexao conexao = new Conexao();
        try {

            String selectSQL = "delete from compras WHERE IDCLIENTE = ? and IDPRODUTO = ? ";
            PreparedStatement preparedStatement;
            preparedStatement  = conexao.getConexao().prepareStatement(selectSQL);
            preparedStatement.setInt(1, idcliente);
            preparedStatement.setInt(2, idproduto);
            ResultSet resultado = preparedStatement.executeQuery();
            
            } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }

    }
/*
public ArrayList<Carrinho> Excluir(int idproduto, int idcliente) {
        ArrayList<Carrinho> meuCarrinho = new ArrayList();
        Conexao conexao = new Conexao();
        try {

            String selectSQL = "select * from compras as c join produto as p on c.idproduto = p.id WHERE IDCLIENTE = ?";
            PreparedStatement preparedStatement;
            preparedStatement  = conexao.getConexao().prepareStatement(selectSQL);
            preparedStatement.setInt(1, idcliente);
            ResultSet resultado = preparedStatement.executeQuery();
            
            if (resultado != null) {
                while (resultado.next()) {
                    Carrinho carrinho;
                    carrinho = new Carrinho(
                            Integer.parseInt(resultado.getString("id")),
                            Integer.parseInt(resultado.getString("IDCLIENTE")) , 
                            Integer.parseInt(resultado.getString("IDPRODUTO")) ,
                    Integer.parseInt(resultado.getString("idcategoria")) 
                    ,resultado.getString("nome") 
                    ,resultado.getString("descricao")
                    ,Integer.parseInt(resultado.getString("valor")));
                    
                    if (Integer.parseInt(resultado.getString("IDPRODUTO")) != idproduto){
                    
                    meuCarrinho.add(carrinho);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meuCarrinho;

    }
*/
    public ArrayList<Carrinho> ListarCompras(int id) {
        ArrayList<Carrinho> meuCarrinho = new ArrayList();
        Conexao conexao = new Conexao();
        try {

            String selectSQL = "select * from compras as c join produto as p on c.idproduto = p.id WHERE IDCLIENTE = ?";
            PreparedStatement preparedStatement;
            preparedStatement  = conexao.getConexao().prepareStatement(selectSQL);
            preparedStatement.setInt(1, id);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Carrinho carrinho;
                    carrinho = new Carrinho(
                            Integer.parseInt(resultado.getString("id")),
                            Integer.parseInt(resultado.getString("IDCLIENTE")) , 
                            Integer.parseInt(resultado.getString("IDPRODUTO")) ,
                    Integer.parseInt(resultado.getString("idcategoria")) 
                    ,resultado.getString("nome") 
                    ,resultado.getString("descricao")
                    ,Integer.parseInt(resultado.getString("valor")));
                    
                    meuCarrinho.add(carrinho);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meuCarrinho;

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Roberta
 */
public class Produtos_DAO {
    public void Inserir(Produtos produtos) throws Exception {
        Conexao conexao = new Conexao();
        try {
            String sqlQ="INSERT INTO PRODUTO VALUES(?,?,?,?)"; //sem aspas no ?
              PreparedStatement sql = conexao.getConexao().prepareStatement(sqlQ);
              sql.setInt(1, produtos.getIdcategoria());
              sql.setString(2, produtos.getNome());
              sql.setString(3, produtos.getDescricao());
              sql.setInt(4, produtos.getValor());
                sql.executeUpdate();
              
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Produtos get(Produtos produtos) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM PRODUTO WHERE ID = ? ");
            sql.setInt(1, produtos.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    produtos.setIdcategoria(resultado.getInt("IDCATEGORIA"));
                    produtos.setNome(resultado.getString("NOME"));
                    produtos.setDescricao(resultado.getString("DESCRICAO"));
                    produtos.setValor(resultado.getInt("VALOR"));
                }
            }
            return produtos;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Produtos produtos) throws Exception {
        Conexao conexao = new Conexao();
        try {
            String sqlQ="UPDATE PRODUTO SET IDCATEGORIA = ? , DESCRICAO= ?, VALOR = ?, NOME = ? "
                      + " WHERE ID = ? ";
              PreparedStatement sql = conexao.getConexao().prepareStatement(sqlQ);
              sql.setInt(1, produtos.getIdcategoria());
              sql.setString(2, produtos.getDescricao());
              sql.setInt(3, produtos.getValor());
              sql.setString(4, produtos.getNome());
              sql.setInt(5, produtos.getId());
              
                
              sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Produtos produtos) throws Exception {
        Conexao conexao = new Conexao();
        try {
            String sqlQ="DELETE FROM PRODUTO WHERE ID = ? ";
              PreparedStatement sql = conexao.getConexao().prepareStatement(sqlQ);
              sql.setInt(1, produtos.getId());
              sql.executeUpdate();
              
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Produtos> Listar() {
        ArrayList<Produtos> meusProdutos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM PRODUTO";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Produtos produtos;
 /*                   produtos = new Produtos(Integer.parseInt(resultado.getString("id")),
                            Integer.parseInt(resultado.getString("idcategoria")),resultado.getString("nome"),
                            resultado.getString("descricao"),Integer.parseInt(resultado.getString("valor")));
*/
                     produtos = new Produtos(resultado.getInt("id"),
                            resultado.getInt("idcategoria"),resultado.getString("nome"),
                            resultado.getString("descricao"),resultado.getInt("valor"));
 
 
                    meusProdutos.add(produtos);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusProdutos;

    }

    public ArrayList<Produtos> ListarEletrodomesticos() {
        ArrayList<Produtos> meusProdutos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM PRODUTO WHERE IDCATEGORIA = 1";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Produtos produtos;
 /*                   produtos = new Produtos(Integer.parseInt(resultado.getString("id")),
                            Integer.parseInt(resultado.getString("idcategoria")),resultado.getString("nome"),
                            resultado.getString("descricao"),Integer.parseInt(resultado.getString("valor")));
*/
                     produtos = new Produtos(resultado.getInt("id"),
                            resultado.getInt("idcategoria"),resultado.getString("nome"),
                            resultado.getString("descricao"),resultado.getInt("valor"));
 
 
                    meusProdutos.add(produtos);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusProdutos;

    }
    public ArrayList<Produtos> ListarInformatica() {
        ArrayList<Produtos> meusProdutos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM PRODUTO WHERE IDCATEGORIA = 2";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Produtos produtos;
 /*                   produtos = new Produtos(Integer.parseInt(resultado.getString("id")),
                            Integer.parseInt(resultado.getString("idcategoria")),resultado.getString("nome"),
                            resultado.getString("descricao"),Integer.parseInt(resultado.getString("valor")));
*/
                     produtos = new Produtos(resultado.getInt("id"),
                            resultado.getInt("idcategoria"),resultado.getString("nome"),
                            resultado.getString("descricao"),resultado.getInt("valor"));
 
 
                    meusProdutos.add(produtos);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusProdutos;

    }

        public ArrayList<Produtos> ListarEletroportateis() {
        ArrayList<Produtos> meusProdutos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM PRODUTO WHERE IDCATEGORIA = 3";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Produtos produtos;
 /*                   produtos = new Produtos(Integer.parseInt(resultado.getString("id")),
                            Integer.parseInt(resultado.getString("idcategoria")),resultado.getString("nome"),
                            resultado.getString("descricao"),Integer.parseInt(resultado.getString("valor")));
*/
                     produtos = new Produtos(resultado.getInt("id"),
                            resultado.getInt("idcategoria"),resultado.getString("nome"),
                            resultado.getString("descricao"),resultado.getInt("valor"));
 
 
                    meusProdutos.add(produtos);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusProdutos;

    }

        public ArrayList<Produtos> ListarSmartphones() {
        ArrayList<Produtos> meusProdutos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM PRODUTO WHERE IDCATEGORIA = 4";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Produtos produtos;
 /*                   produtos = new Produtos(Integer.parseInt(resultado.getString("id")),
                            Integer.parseInt(resultado.getString("idcategoria")),resultado.getString("nome"),
                            resultado.getString("descricao"),Integer.parseInt(resultado.getString("valor")));
*/
                     produtos = new Produtos(resultado.getInt("id"),
                            resultado.getInt("idcategoria"),resultado.getString("nome"),
                            resultado.getString("descricao"),resultado.getInt("valor"));
 
 
                    meusProdutos.add(produtos);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusProdutos;

    }

    public ArrayList<Produtos> ListarBusca(String busca) {
        ArrayList<Produtos> meusProdutos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM PRODUTO WHERE NOME LIKE ? ";
            PreparedStatement preparedStatement;
            
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            preparedStatement.setString(1,busca);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Produtos produtos;
 /*                   produtos = new Produtos(Integer.parseInt(resultado.getString("id")),
                            Integer.parseInt(resultado.getString("idcategoria")),resultado.getString("nome"),
                            resultado.getString("descricao"),Integer.parseInt(resultado.getString("valor")));
*/
                     produtos = new Produtos(resultado.getInt("id"),
                            resultado.getInt("idcategoria"),resultado.getString("nome"),
                            resultado.getString("descricao"),resultado.getInt("valor"));
 
 
                    meusProdutos.add(produtos);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusProdutos;

    }



}

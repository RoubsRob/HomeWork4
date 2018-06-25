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

public class Categorias_DAO {

    public void Inserir(Categorias categorias) throws Exception {
        Conexao conexao = new Conexao();
            System.out.print("Entrou no inserir1");
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO CATEGORIA (descricao) VALUES (?)");
            sql.setString(1, categorias.getDescricao());
            sql.executeUpdate();
            System.out.print("Entrou no inserir");

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Categorias get(Categorias categorias) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM CATEGORIA WHERE ID = ? ");
            sql.setInt(1, categorias.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    categorias.setDescricao(resultado.getString("DESCRICAO"));
                }
            }
            return categorias;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Categorias categorias) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE CATEGORIA SET descricao = ? WHERE ID = ? ");
            sql.setString(1, categorias.getDescricao());
            sql.setInt(2, categorias.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Categorias categorias) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM CATEGORIA WHERE ID = ? ");
            sql.setInt(1, categorias.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Categorias> Listar() {
        ArrayList<Categorias> meusCategorias = new ArrayList();
        Conexao conexao = new Conexao();
        try {

            String selectSQL = "SELECT * FROM CATEGORIA";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Categorias categoria;
                    categoria = new Categorias(Integer.parseInt(resultado.getString("ID")),
                            resultado.getString("DESCRICAO"));
                    meusCategorias.add(categoria);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusCategorias;

    }

}

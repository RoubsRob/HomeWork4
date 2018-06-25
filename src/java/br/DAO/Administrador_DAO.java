/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DAO;

import br.controle.ListaAdministrador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Roberta
 */
public class Administrador_DAO {
    public void Inserir(Administrador administrador) throws Exception {
        Conexao conexao = new Conexao();
        try {
            String sqlQ="INSERT INTO ADMINISTRADOR VALUES(?,?)"; //sem aspas no ?
              PreparedStatement sql = conexao.getConexao().prepareStatement(sqlQ);
              sql.setString(1, administrador.getLogin());
              sql.setString(2, administrador.getSenha());
              sql.executeUpdate();
              
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Administrador get(Administrador administrador) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM administrador WHERE ID = ? ");
            sql.setInt(1, administrador.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    administrador.setLogin(resultado.getString("LOGIN"));
                    administrador.setSenha(String.valueOf(resultado.getString("SENHA")));
                }
            }
            return administrador;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

        public static Administrador getid(Administrador administrador) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM administrador WHERE LOGIN = ? ");
            sql.setString(1, administrador.getLogin());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    administrador.setId(resultado.getInt("ID"));
                    administrador.setSenha(String.valueOf(resultado.getString("SENHA")));
                }
            }
            return administrador;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    
    public void Alterar(Administrador administrador) throws Exception {
        Conexao conexao = new Conexao();
        try {
            String sqlQ="UPDATE ADMINISTRADOR SET SENHA = ?, LOGIN = ? WHERE ID = ? ";
              PreparedStatement sql = conexao.getConexao().prepareStatement(sqlQ);
              sql.setString(1, administrador.getSenha());
              sql.setString(2, administrador.getLogin());
              sql.setInt(3, administrador.getId());
              
              sql.executeUpdate();
              
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Administrador administrador) throws Exception {
        Conexao conexao = new Conexao();
        try {
            String sqlQ="DELETE FROM ADMINISTRADOR WHERE ID = ? ";
              PreparedStatement sql = conexao.getConexao().prepareStatement(sqlQ);
              sql.setInt(1, administrador.getId());
              sql.executeUpdate();
            
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Administrador> Listar() {
        ArrayList<Administrador> meusAdministradores = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM ADMINISTRADOR ORDER BY ID";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Administrador administrador;
                    administrador = new Administrador(Integer.parseInt(resultado.getString("id")),
                    resultado.getString("login"),
                    resultado.getString("senha"));
                    meusAdministradores.add(administrador);
              
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusAdministradores;

    }
    public static boolean SenhaCorreta(String login, String senha) throws SQLException{
       Conexao conexao = new Conexao();
       Administrador_DAO admin = new Administrador_DAO();
       boolean logado = false;
       try{       
       ArrayList<Administrador> resultado = (ArrayList) admin.Listar();
            for (int i = 0; i < resultado.size(); i++) {
                Administrador adm = (Administrador)resultado.get(i);
                if (adm.getLogin().equalsIgnoreCase(login) && 
                        adm.getSenha().equalsIgnoreCase(senha)){
                    
                        logado = true;
                }
       

           }
       }catch (Exception e){
           e.printStackTrace();
       }finally{
        
        conexao.closeConexao();
    }
       return logado;
    }


}

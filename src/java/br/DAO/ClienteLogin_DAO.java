/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DAO;

//import br.controle.ListaClienteLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Roberta
 */
public class ClienteLogin_DAO {
    public void Inserir(ClienteLogin clientelogin) throws Exception {
        Conexao conexao = new Conexao();
        try {
            String sqlQ="INSERT INTO ADMINISTRADOR (login,senha) VALUES(?,?)"; //sem aspas no ?
              PreparedStatement sql = conexao.getConexao().prepareStatement(sqlQ);
              sql.setString(1, clientelogin.getLogin());
              sql.setString(2, clientelogin.getSenha());
              
              System.out.println("Entrou inserir cliente"+ clientelogin.getLogin()+clientelogin.getSenha());
              
              sql.executeUpdate();
              
              System.out.println("Entrou inserir cliente");
              
              
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ClienteLogin get(ClienteLogin clientelogin) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM clientelogin WHERE ID = ? ");
            sql.setInt(1, clientelogin.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    clientelogin.setLogin(resultado.getString("LOGIN"));
                    clientelogin.setSenha(String.valueOf(resultado.getString("SENHA")));
                }
            }
            return clientelogin;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(ClienteLogin clientelogin) throws Exception {
        Conexao conexao = new Conexao();
        try {
            String sqlQ="UPDATE CLIENTELOGIN SET SENHA = ?, LOGIN = ? WHERE ID = ? ";
              PreparedStatement sql = conexao.getConexao().prepareStatement(sqlQ);
              sql.setString(1, clientelogin.getSenha());
              sql.setString(2, clientelogin.getLogin());
              sql.setInt(3, clientelogin.getId());
              
              sql.executeUpdate();
              
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(ClienteLogin clientelogin) throws Exception {
        Conexao conexao = new Conexao();
        try {
            String sqlQ="DELETE FROM CLIENTELOGIN WHERE ID = ? ";
              PreparedStatement sql = conexao.getConexao().prepareStatement(sqlQ);
              sql.setInt(1, clientelogin.getId());
              sql.executeUpdate();
            
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<ClienteLogin> Listar() {
        ArrayList<ClienteLogin> meusClienteLogines = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM CLIENTELOGIN ORDER BY ID";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    ClienteLogin clientelogin;
                    clientelogin = new ClienteLogin(Integer.parseInt(resultado.getString("id")),
                    resultado.getString("login"),
                    resultado.getString("senha"));
                    meusClienteLogines.add(clientelogin);
              
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusClienteLogines;

    }
    public static boolean SenhaCorreta(String login, String senha) throws SQLException{
       Conexao conexao = new Conexao();
       ClienteLogin_DAO admin = new ClienteLogin_DAO();
       boolean logado = false;
       try{       
       ArrayList<ClienteLogin> resultado = (ArrayList) admin.Listar();
            for (int i = 0; i < resultado.size(); i++) {
                ClienteLogin aux = (ClienteLogin)resultado.get(i);
                if ((aux.getLogin().equalsIgnoreCase(login)) && 
                        aux.getSenha().equalsIgnoreCase(senha)){
                    
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
        public static ClienteLogin getid(ClienteLogin administrador) throws Exception {
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


}

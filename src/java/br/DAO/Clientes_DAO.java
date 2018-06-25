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

/**m *
 * @author Roberta
 */
public class Clientes_DAO {
    public void Inserir(Clientes clientes) throws Exception {
        Conexao conexao = new Conexao();
        try {
            String sqlQ="INSERT INTO CLIENTES(ENDERECO, BAIRRO, CEP, ESTADO, REFERENCIA, "
                      + "CPF, IDENTIDADE, TEL, CEL, NUMCARTAOCREDITO, BANDEIRACARTAO, NOME) "
                      + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?) "; //sem aspas no ?
              //nome,endereco,bairro,cep,estado,referencia,identidade,tel,cpf,cel,ncartao,bcartao
              PreparedStatement sql = conexao.getConexao().prepareStatement(sqlQ);
              sql.setString(1, clientes.getEndereco());
              sql.setString(2, clientes.getBairro());
              sql.setInt(3, clientes.getCep());
              sql.setString(4, clientes.getEstado());
              sql.setString(5, clientes.getReferencia());
              sql.setInt(6, clientes.getCpf());
              sql.setInt(7, clientes.getIdentidade());
              sql.setInt(8, clientes.getTel());
              sql.setInt(9, clientes.getCel());
              sql.setInt(10, clientes.getNumcartaocredito());
              sql.setString(11, clientes.getBandeiracartao());
              sql.setString(12, clientes.getNome());
              
              sql.executeUpdate();
              
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Clientes get(Clientes clientes) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM CLIENTES WHERE ID = ? ");
            sql.setInt(1, clientes.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    clientes.setEndereco(resultado.getString("ENDERECO"));
                    clientes.setBairro(resultado.getString("BAIRRO"));
                    clientes.setCep(Integer.parseInt(resultado.getString("CEP")));
                    clientes.setEstado(resultado.getString("ESTADO"));
                    clientes.setReferencia(resultado.getString("REFERENCIA"));
                    clientes.setCpf(Integer.parseInt(resultado.getString("CPF")));
                    clientes.setIdentidade(Integer.parseInt(resultado.getString("IDENTIDADE")));
                    clientes.setTel(Integer.parseInt(resultado.getString("TEL")));
                    clientes.setCel(Integer.parseInt(resultado.getString("CEL")));
                    clientes.setNumcartaocredito(Integer.parseInt(resultado.getString("Numcartaocredito")));
                    clientes.setBandeiracartao(resultado.getString("Bandeiracartao"));
                    clientes.setNome(resultado.getString("NOME"));
                }
            }
            return clientes;

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Clientes clientes) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE CLIENTES SET endereco = ? , bairro = ? , "
                      + "cep = ? , estado = ? , referencia = ?, cpf= ? , identidade = ? , "
                      + "tel = ? , cel = ? , numcartaocredito = ? , bandeiracartao = ? , nome = ? where id= ? ");
              sql.setString(1, clientes.getEndereco());
              sql.setString(2, clientes.getBairro());
              sql.setInt(3, clientes.getCep());
              sql.setString(4, clientes.getEstado());
              sql.setString(5, clientes.getReferencia());
              sql.setInt(6, clientes.getCpf());
              sql.setInt(7, clientes.getIdentidade());
              sql.setInt(8, clientes.getTel());
              sql.setInt(9, clientes.getCel());
              sql.setInt(10, clientes.getNumcartaocredito());
              sql.setString(11, clientes.getBandeiracartao());
              sql.setString(12, clientes.getNome());
              sql.setInt(13, clientes.getId());
              
              sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Excluir(Clientes clientes) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM CLIENTES WHERE ID = ? ");
            sql.setInt(1, clientes.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Clientes> Listar() {
        ArrayList<Clientes> meusClientes = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM CLIENTES";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Clientes clientes;
                    clientes = new Clientes(Integer.parseInt(resultado.getString("id")),resultado.getString("endereco"),
                            resultado.getString("bairro"),Integer.parseInt(resultado.getString("cep")),resultado.getString("estado"),
                            resultado.getString("referencia"),Integer.parseInt(resultado.getString("cpf")),Integer.parseInt(resultado.getString("identidade")),
                            Integer.parseInt(resultado.getString("tel")),Integer.parseInt(resultado.getString("cel")),Integer.parseInt(resultado.getString("Numcartaocredito")),
                            resultado.getString("Bandeiracartao"),resultado.getString("nome"));
                    meusClientes.add(clientes);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusClientes;

    }
    public static boolean SenhaCorreta(ClienteLogin cliente) throws SQLException{
       Conexao conexao = new Conexao();
       ClienteLogin_DAO admin = new ClienteLogin_DAO();
       boolean logado = false;
       try{       
       ArrayList<ClienteLogin> resultado = (ArrayList) admin.Listar();
            for (int i = 0; i < resultado.size(); i++) {
                ClienteLogin aux = (ClienteLogin)resultado.get(i);
                if ((aux.getLogin().equalsIgnoreCase(cliente.getLogin())) && 
                        aux.getSenha().equalsIgnoreCase(cliente.getSenha())){
                    
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



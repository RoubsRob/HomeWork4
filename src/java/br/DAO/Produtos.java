/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Roberta
 */
public class Produtos {
    
    private int id;
    private int idcategoria;
    private String nome;
    private String descricao;
    private int valor;    

    public Produtos(int id, int idcategoria, String nome, String descricao, int valor) {
        this.id = id;
        this.idcategoria = idcategoria;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;

    }
    public Produtos(int idcategoria, String nome, String descricao, int valor) {
        this.idcategoria = idcategoria;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;

    }
    public Produtos(){
        
    }
    
    
    public Produtos(int id) {
        this.id = id;
    }

    public Produtos(int id,int idcategoria) {
        this.id = id;
        this.idcategoria= idcategoria;
        
    }
    
    public Produtos(int id,int idcategoria, String nome) {
        this.id = id;
        this.idcategoria= idcategoria;
        this.nome = nome;
    }

    
    /**
     * @return the id
     */
    public int getIdcategoria() {
        return idcategoria;
    }

    /**
     * @param id the id to set
     */
    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idcategoria
     */
    public int getIdprodutos() {
        return idcategoria;
    }

    /**
     * @param idcategoria the idcategoria to set
     */
    public void setIdprodutos(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }
}

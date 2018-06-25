/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.DAO;

/**
 *
 * @author Roberta
 */
public class Carrinho {
    private int idcompra;
    private int idcliente;
    private int idproduto;
    private int idcategoria;
    private String nome;
    private String descricao;
    private int valor;    
    
    public Carrinho(int idcompra,int idcliente, int idproduto, int idcategoria, String nome, String descricao, int valor) {
        this.idcompra = idcompra;
        this.idcliente = idcliente;
        this.idproduto = idproduto;
        this.idcategoria = idcategoria;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;

    }
    public Carrinho (int idcompra){
        this.idcompra = idcompra;
    }

    
    /**
     * @return the idcompra
     */
    public int getIdcompra() {
        return idcompra;
    }

    /**
     * @param idcompra the idcompra to set
     */
    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    /**
     * @return the idcliente
     */
    public int getIdcliente() {
        return idcliente;
    }

    /**
     * @param idcliente the idcliente to set
     */
    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    /**
     * @return the idproduto
     */
    public int getIdproduto() {
        return idproduto;
    }

    /**
     * @param idproduto the idproduto to set
     */
    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    /**
     * @return the idProduto
     */
    /**
     * @return the idcategoria
     */
    public int getIdcategoria() {
        return idcategoria;
    }

    /**
     * @param idcategoria the idcategoria to set
     */
    public void setIdcategoria(int idcategoria) {
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

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
public class Clientes {
    
    private int id;
    private String endereco;
    private String bairro;
    private int cep;  
    private String estado;
    private String referencia;
    private int cpf;    
    private int identidade;    
    private int tel;
    private int cel;
    private int numcartaocredito;
    private String bandeiracartao;
    private String nome;

    public Clientes(int id) {
        this.id = id;
    }
    public Clientes() {
        
    }
   
    public Clientes(int id, String endereco, String bairro, int cep, 
            String estado, String referencia, int cpf, int identidade, int tel, 
            int cel, int numcartaocredito, String bandeiracartao, String nome) {
        this.id = id;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.estado = estado;
        this.referencia = referencia;
        this.cpf = cpf;
        this.identidade = identidade;
        this.tel = tel;
        this.cel = cel;
        this.numcartaocredito = numcartaocredito;
        this.bandeiracartao = bandeiracartao;
        this.nome = nome;
        
    }
    public Clientes(String endereco, String bairro, int cep, 
            String estado, String referencia, int cpf, int identidade, int tel, 
            int cel, int numcartaocredito, String bandeiracartao, String nome) {
        
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.estado = estado;
        this.referencia = referencia;
        this.cpf = cpf;
        this.identidade = identidade;
        this.tel = tel;
        this.cel = cel;
        this.numcartaocredito = numcartaocredito;
        this.bandeiracartao = bandeiracartao;
        this.nome = nome;
        
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
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cep
     */
    public int getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(int cep) {
        this.cep = cep;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the cpf
     */
    public int getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the identidade
     */
    public int getIdentidade() {
        return identidade;
    }

    /**
     * @param identidade the identidade to set
     */
    public void setIdentidade(int identidade) {
        this.identidade = identidade;
    }

    /**
     * @return the tel
     */
    public int getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(int tel) {
        this.tel = tel;
    }

    /**
     * @return the cel
     */
    public int getCel() {
        return cel;
    }

    /**
     * @param cel the cel to set
     */
    public void setCel(int cel) {
        this.cel = cel;
    }

    /**
     * @return the numcartaocredito
     */
    public int getNumcartaocredito() {
        return numcartaocredito;
    }

    /**
     * @param numcartaocredito the numcartaocredito to set
     */
    public void setNumcartaocredito(int numcartaocredito) {
        this.numcartaocredito = numcartaocredito;
    }

    /**
     * @return the bandeiracartao
     */
    public String getBandeiracartao() {
        return bandeiracartao;
    }

    /**
     * @param bandeiracartao the bandeiracartao to set
     */
    public void setBandeiracartao(String bandeiracartao) {
        this.bandeiracartao = bandeiracartao;
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
    

}

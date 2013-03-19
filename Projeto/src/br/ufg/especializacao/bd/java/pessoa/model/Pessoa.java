/**
 *
 * Descrição:Classe Pessoa
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 19-Mar-2013
 *
 * @version 1.0.0
 *
 */

package br.ufg.especializacao.bd.java.pessoa.model;

import java.sql.Date;


public class Pessoa {

    private String codigoPessoa;
    private String nome;
    private String logradouro;
    private String telefone;
    private String email;
    private Date dataNascimento;

    public Pessoa(String codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
        this.nome = "Não Informado";
        this.logradouro = "Não Informado";
        this.telefone = "0000000000";
        this.email = "Não Informado";
    }

    public String getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(String codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

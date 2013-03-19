/**
 *
 * Descrição: Classe UsuarioController
 *
 * @author Fabricio Nogueira
 *
 * @since 19-Mar-2013
 *
 * @version 1.0.0
 *
 */

package br.ufg.especializacao.bd.java.pessoa.controller;

import br.ufg.especializacao.bd.java.pessoa.model.Pessoa;
import java.util.List;


public class UsuarioController extends PessoaController{

    private PessoaController codigoPessoa;
    private String login;
    private String senha;

    public UsuarioController(PessoaController codigoPessoa, String login, String senha) {
        this.codigoPessoa = codigoPessoa;
        this.login = login;
        this.senha = senha;
    }

    public PessoaController getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(PessoaController codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public boolean cadastrar(Pessoa pessoa) {
        return super.cadastrar(pessoa); 
    }
    
}

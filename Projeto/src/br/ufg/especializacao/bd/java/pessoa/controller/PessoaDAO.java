/**
 *
 * Descrição: Interface Pessoa
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


public interface PessoaDAO {

    public boolean cadastrar(Pessoa pessoa);
    public boolean editar(Pessoa pessoa);
    public boolean excluir(Pessoa pessoa);
    public List<Pessoa> listar();
    public Pessoa getByCodigo(String codigoPessoa);

}

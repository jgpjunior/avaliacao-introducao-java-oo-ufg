/**
 *
 * Descrição:Classe PessoaDAO
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 19-Mar-2013
 *
 * @version 1.0.0
 *
 */
package br.ufg.especializacao.bd.java.pessoa.controller;

import br.ufg.especializacao.bd.java.data.Conexao;
import br.ufg.especializacao.bd.java.pessoa.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PessoaController implements PessoaDAO{

    private Connection connection = null;
    public List<Pessoa> pessoas;
    
    public PessoaController() {
        
    }
    /**
     * Metodo para inserir clientes no banco de dados
     *
     * @param cliente1
     * @return true se inseriu e false se falhou
     */
   @Override
    public boolean cadastrar(Pessoa pessoa) {
        connection = Conexao.getInstance().getConnection();
        System.out.println("conectado e preparando para inserir");
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(" insert into"
                    + " pessoa (codigo,nome, logradouro, telefone, email, data_nascimento) values (?,?,?,?,?,?)");
            pstmt.setString(1, pessoa.getCodigoPessoa());
            pstmt.setString(2, pessoa.getNome());
            pstmt.setString(3, pessoa.getLogradouro());
            pstmt.setString(4, pessoa.getTelefone());
            pstmt.setString(5, pessoa.getEmail());
            pstmt.setDate(6, pessoa.getDataNascimento());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                pstmt.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao desconectar");
            }
        }
    }
    /**
     *
     * 
     */
    @Override
    public boolean editar(Pessoa pessoa){
        return true;
    }
    /**
     *
     * 
     */
    @Override
    public boolean excluir(Pessoa pessoa){
        return true;
    }
    /**
     *
     * 
     */
    @Override
    public List<Pessoa> listar() {
        return pessoas;
    }
    /**
     *
     * 
     */
    @Override
    public Pessoa getByCodigo(String codigoPessoa){
        for(Pessoa pessoa : pessoas){
            if(pessoa.getCodigoPessoa() == null ? codigoPessoa == null : pessoa.getCodigoPessoa().equals(codigoPessoa)){
                return pessoa;
            }
        }
        return null;
    }
    
//    /**
//     * MÃ©todo que se conecta no banco e retorna uma List de clientes
//     *
//     * @return List de clientes
//     */
//    public List<Pessoa> ListaClientes() {
//        List<Pessoa> listaDeClientes = new ArrayList<Pessoa>();
//        // iniciando a conexao
//        connection = Conexao.getInstance().getConnection();
//        System.out.println("conectado e preparando listagem");
//        Statement stmt = null;
//        try {
//            stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM CLIENTES");
//            // Incluindo clientes na lista que vai ser retornada
//            while (rs.next()) {
//                Pessoa cliente1 = new Pessoa(rs.getString("Codigo"), rs
//                        .getString("nome"));
//                listaDeClientes.add(cliente1);
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            return null;
//        } finally {
//            try {
//                stmt.close();
//                connection.close();
//            } catch (SQLException e) {
//                System.out.println("Erro ao desconectar");
//            }
//        }
//        return listaDeClientes;
//    } // fim do mÃ©todo para inserir
}

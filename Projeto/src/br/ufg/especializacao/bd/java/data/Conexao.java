/**
 *
 * Descrição:Classe Conexao
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 19-Mar-2013
 *
 * @version 1.0.0
 *
 */
package br.ufg.especializacao.bd.java.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {

    // trocar os dados do banco de acordo com sua necessidade
    final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    Connection conn = null;
    private static Conexao instance = null;

    /**
     * Construtor da classe Inicializa a conexao
     */
    public Conexao() {
        inicializar();
    }

    /**
     * Metodo que carrega o driver a efetua a conexao com o banco de dados
     */
    private void inicializar() {
        try {
            // dados do usuÃ¡rio, mudar de acordo com seus dados
            Properties connectProperties = new Properties();
            connectProperties.put("user", "system");
            connectProperties.put("password", "mandioca");
            // 1. Loading a database driver
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            // 2. Creating a jdbc Connection
            conn = DriverManager.getConnection(url, connectProperties);
            System.out.println("Conectado com Sucesso!!!");
        } catch (SQLException sqle) {
            System.out.println("SQLException em Conecta.java "
                    + sqle.getMessage());
        }
    }
    /**
     * Metodo invocado por outras classes para solicitar a conexao com banco de
     * dados
     *
     * @return
     */
    public Connection getConnection() {
        return conn;
    }

    /**
     * Metodo chamado por outras classes para instanciar um objeto do tipo
     * conecta e poder utilizado Este metodo verifica se uma instancia ja foi
     * feita ou nao
     *
     * @return
     */
    public static Conexao getInstance() {
        if (instance == null) {
            instance = new Conexao();
        }
        return instance;
    }

    /**
     * Metodo utilizado para fechar a conexao com o banco de dados
     */
    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexao [" + e.getMessage()
                    + "]");
        }
    }
}

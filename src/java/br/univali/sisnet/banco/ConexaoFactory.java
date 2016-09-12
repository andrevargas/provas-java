
package br.univali.sisnet.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoFactory {

    public static Connection criarConexao()
    {
        String url = "jdbc:mysql://localhost/sistema_provas";

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return DriverManager.getConnection(url, properties);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
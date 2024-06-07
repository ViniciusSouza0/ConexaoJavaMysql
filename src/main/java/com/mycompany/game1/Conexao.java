package com.mycompany.game1;

import java.sql.Connection; //serve para fazer a conexao
import java.sql.DriverManager; //biblioteca
import java.sql.SQLException; //serve para informar erros

public class Conexao {

    private static final String url = "jdbc:mysql://localhost:3306/rpg";

    private static final String user = "rpg";
    private static final String password = "senacrs";

    private static Connection conn;

    public static Connection getConexao() throws SQLException {
        try {
            System.out.println("URL: " + url);
            System.out.println("USER: " + user);
            System.out.println("PASS: " + password);
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;

            } else {
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package com.mycompany.game1;
import java.sql.Connection; //serve para fazer a conexao
import java.sql.DriverManager; //biblioteca
import java.sql.SQLException; //serve para informar erros


public class Conexao{
    private static final String url = "jdbc:mysql://localhost:3306/jogo";
    
    private static final String user = "root";
    private static final String password = "";
    
    private static Connection conn;
    
    public static Connection getConexao() throws SQLException{
        try {
            if(conn == null){
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }else{
                return conn;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}

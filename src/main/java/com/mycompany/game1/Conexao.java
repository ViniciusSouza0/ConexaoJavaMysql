package com.mycompany.game1;

import java.sql.Connection;//Esta linha importa a Connectionclasse do java.sqlpacote, que é usada para representar uma conexão com um banco de dados.
import java.sql.DriverManager;//Esta linha importa a DriverManagerclasse do java.sqlpacote, que é usado para gerenciar drivers de banco de dados.
import java.sql.SQLException;//Esta linha importa a SQLExceptionclasse do java.sqlpacote, que é usado para tratar exceções relacionadas ao banco de dados.

public class Conexao { //Esta linha declara uma nova classe pública chamada Conexao.

private static final String url = "jdbc:mysql://localhost:3306/rpg";/*Esta linha declara uma variável final estática privada urldo tipo String, 
                                                                    que representa a URL da conexão com o banco de dados. 
                                                                    O valor é uma URL JDBC que se conecta a um banco de dados MySQL no host local, porta 3306, 
                                                                    com o nome de banco de dados "rpg". */
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\
private static final String user = "rpg";                           /*Esta linha declara uma variável final estática privada userdo tipo String, 
                                                                    que representa o nome de usuário a ser usado para a conexão com o banco de dados.
                                                                    O valor é "rpg". */
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\
private static final String password = "senacrs";                   /*Esta linha declara uma variável final estática privada passworddo tipo String, 
                                                                    que representa a senha a ser usada para a conexão com o banco de dados. 
                                                                    O valor é "senacrs".*/
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\
private static Connection conn; //Esta linha declara uma variável estática privada conndo tipo Connection, que conterá o objeto de conexão com o banco de dados.

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\
public static Connection getConexao() throws SQLException {//Esta linha declara um método estático público chamado getConexaoque retorna um Connectionobjeto e lança um SQLExceptionse ocorrer um erro.
try {                                                      //Esta linha inicia um bloco try-catch, que é usado para tratar exceções.
System.out.println("URL: " + url);                         //Esta linha imprime o valor da urlvariável no console, prefixado com "URL:".
System.out.println("USER: " + user);                       //Esta linha imprime o valor da uservariável no console, prefixado com "USER:".
System.out.println("PASS: " + password);                   //Esta linha imprime o valor da passwordvariável no console, prefixado com "PASS:".
if (conn == null) {                                        //Esta linha verifica se a connvariável é nula. Se for, o código dentro da instrução if será executado.
    
conn = DriverManager.getConnection(url, user, password);   /*Esta linha usa a DriverManagerclasse para estabelecer 
                                                           uma conexão com o banco de dados usando as variáveis url​​, usere. 
                                                           password O objeto de conexão resultante é atribuído à connvariável. */

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\
return conn;              //Esta linha retorna o connobjeto, que representa a conexão estabelecida com o banco de dados.
} else {                  //Esta linha faz parte da instrução if-else. Se a connvariável não for nula, o código dentro do bloco else será executado.
return conn;              //Esta linha retorna o connobjeto existente, que representa a conexão de banco de dados estabelecida.
}
} catch (SQLException e) {//Esta linha captura quaisquer SQLExceptionexceções que possam ocorrer durante a execução do bloco try.
e.printStackTrace();      //Esta linha imprime o rastreamento de pilha da exceção capturada no console, o que pode ajudar na depuração.
return null;              //Esta linha retorna nulo se ocorrer uma exceção, indicando que a conexão não pôde ser estabelecida.

}                         //Esta linha fecha o getConexaométodo.
}
}
                          /*Em resumo, esta classe fornece uma maneira de estabelecer uma conexão com um banco de dados MySQL usando um método estático getConexao. 
                          O método retorna um Connectionobjeto, que pode ser usado para interagir com o banco de dados. 
                          Se ocorrer uma exceção durante o processo de conexão, o método retornará nulo.*/
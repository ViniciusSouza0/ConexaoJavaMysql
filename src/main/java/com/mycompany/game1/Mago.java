//Pacote e Importações 
//com.mycompany.game1: especifica o nome do pacote onde a Magoclasse reside.
//Importa as classes necessárias para interação com o banco de dados ( java.sql.*), ArrayListe Listde java.util.
package com.mycompany.game1;

import java.sql.Connection;
 import java.sql.DriverManager;
  import java.sql.PreparedStatement;
   import java.sql.ResultSet;
    import java.sql.SQLException;
     import java.util.ArrayList;
      import java.util.List;

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\
   //Declaração de classe 
   //Magoextends Personagem, indicando que herda de outra classe.
   //Define dois campos privados: inventario(inventário do tipo List<Item>) e poderes(poderes do tipo List<Poder>).
    public class Mago extends Personagem {
    private List<Item> inventario;
    private List<Poder> poderes;
    
    public Mago(String nome, int vida) {
    super(nome, vida);
    this.inventario = new ArrayList<>();
    this.poderes = new ArrayList<>();
    salvar();
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\  
    //Método:adicionarItem(Item item) :
    //Adiciona um Itemobjeto à inventariolista.
    //Estabelece uma conexão com o banco de dados e insere os detalhes do item ( nome, efeito, mago_nome) na itenstabela.
    //Manipula SQLExceptionimprimindo o rastreamento de pilha se ocorrer uma exceção.
    public void adicionarItem(Item item) {
    inventario.add(item);
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpg", "rpg", "senacrs")) {
    String sql = "INSERT INTO itens (nome, efeito, mago_nome) VALUES (?, ?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
    statement.setString(1, item.getNome());
    statement.setInt(2, item.getEfeito());
    statement.setString(3, this.nome);
    statement.executeUpdate();
    }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\
    //Método:adicionarPoder(Poder poder) :
    //Adiciona um Poderobjeto à podereslista.
    //Insere os detalhes da potência ( nome, mago_nome) na poderestabela do banco de dados.
    //Manipula SQLExceptionimprimindo o rastreamento de pilha se ocorrer uma exceção.
    public void adicionarPoder(Poder poder) {
    poderes.add(poder);
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpg", "rpg", "senacrs")) {
    String sql = "INSERT INTO poderes (nome, mago_nome) VALUES (?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
    statement.setString(1, poder.getNome());
    statement.setString(2, this.nome);
    statement.executeUpdate();
    }
    } catch (SQLException e) {
    e.printStackTrace();
    }
    }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\    
    //Método:usarItem(int indice) :
    //Usa um item da inventario lista com base no índice fornecido (indice).
    //Aumenta a (vida) do mago vidapelo efeito do item ( efeito).
    //Imprime uma mensagem indicando o item utilizado e a vida atual do assistente.
    //Imprime uma mensagem de erro se o índice estiver fora dos limites ( índice inválido).
    public void usarItem(int indice) {
    if (indice >= 0 && indice < inventario.size()) {
    Item item = inventario.get(indice);
    vida += item.getEfeito();
    System.out.println(nome + " usou " + item.getNome() + ". Vida atual: " + vida);
    } else {
    System.out.println("Índice inválido!");
    }
    }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\
    //Método:usarPoder(int indice) :
    //Usa uma potência da podereslista com base no índice fornecido ( indice).
    //Chama o usar()método no Poderobjeto selecionado, que provavelmente executa alguma ação ou efeito.
    //Imprime uma mensagem de erro se o índice estiver fora dos limites ( índice inválido).
    public void usarPoder(int indice) {
    if (indice >= 0 && indice < poderes.size()) {
    Poder poder = poderes.get(indice);
    poder.usar();
    } else {
    System.out.println("Índice inválido!");
    }
    }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\
    public void mostrarInventario() {
    System.out.println("Inventário de " + nome + ":");//Imprime uma mensagem indicando que está mostrando o inventário do mago cujo nome é armazenado na variável nome.
    for (int i = 0; i < inventario.size(); i++) {//Inicia um loop que itera através dos elementos do inventário (inventario), utilizando o índice i como contador.
    System.out.println(i + ". " + inventario.get(i).getNome());//Inicia um loop que itera através dos elementos do inventário (inventario), utilizando o índice i como contador.
    }
    }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\    
    public void mostrarPoderes() {
    System.out.println("Poderes de " + nome + ":");//Imprime uma mensagem indicando que está mostrando os poderes do mago cujo nome é armazenado na variável nome.
    for (int i = 0; i < poderes.size(); i++) {//Inicia um loop que itera através dos elementos da lista de poderes (poderes), utilizando o índice i como contador.
    System.out.println(i + ". " + poderes.get(i).getNome());//Para cada poder na lista, imprime o índice i seguido de um ponto e do nome do poder obtido através do método getNome().
    }
    }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\   
    public void salvar() {
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpg", "rpg", "senacrs")) { //Tenta estabelecer uma conexão com o banco de dados MySQL utilizando as credenciais fornecidas.
    String sql = "INSERT INTO magos (nome, vida) VALUES (?, ?)";//Define uma string contendo a consulta SQL para inserir dados na tabela magos, especificamente os campos nome e vida.
    try (PreparedStatement statement = connection.prepareStatement(sql)) {//Prepara a declaração SQL para ser executada no banco de dados.
    statement.setString(1, this.nome);//Atribui o valor do atributo nome do objeto atual (this) ao primeiro parâmetro da consulta preparada (?).
    statement.setInt(2, this.vida);//Atribui o valor do atributo vida do objeto atual (this) ao segundo parâmetro da consulta preparada (?).
    statement.executeUpdate();//Executa a operação de atualização no banco de dados, neste caso, inserindo os dados na tabela magos.
    }
    } catch (SQLException e) {//Captura e trata qualquer exceção do tipo SQLException que possa ocorrer durante a execução da consulta SQL.
    e.printStackTrace();//Imprime o rastreamento da pilha da exceção, se ocorrer alguma exceção SQL.
    }
    }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\    
    public static Mago carregar(String nome) {
    Mago mago = null; //Inicializa uma variável mago que será utilizada para armazenar o objeto Mago carregado do banco de dados.
    
    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpg", "rpg", "senacrs")) { 
    //Tenta estabelecer uma conexão com o banco de dados MySQL utilizando as credenciais fornecidas.
    
    String sql = "SELECT * FROM magos WHERE nome = ?";
    //Define uma string contendo a consulta SQL para selecionar todos os campos da tabela magos onde o nome corresponde ao parâmetro fornecido.
    
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
    //Prepara a declaração SQL para ser executada no banco de dados.
    
    statement.setString(1, nome); //Atribui o valor do parâmetro nome fornecido ao primeiro parâmetro da consulta preparada (?).
    
    ResultSet resultSet = statement.executeQuery();//Executa a consulta SQL e armazena o resultado em um objeto ResultSet.
    if (resultSet.next()) { //Verifica se há pelo menos uma linha no resultado do ResultSet.
    int vida = resultSet.getInt("vida");//Obtém o valor do campo vida da linha atual do resultado do ResultSet.
    mago = new Mago(nome, vida);//Cria um novo objeto Mago com os valores recuperados do banco de dados.
    }
    }
    } catch (SQLException e) {//Captura e trata qualquer exceção do tipo SQLException que possa ocorrer durante a execução da consulta SQL.
      e.printStackTrace();//Imprime o rastreamento da pilha da exceção, se ocorrer alguma exceção SQL.
    }
    return mago;//Retorna o objeto Mago carregado do banco de dados. Se nenhum mago for encontrado, retorna null.
    //Esses métodos em conjunto permitem mostrar informações do inventário e dos poderes de um mago, 
    //além de salvar e carregar dados do banco de dados MySQL relacionados aos magos.
    }
    }

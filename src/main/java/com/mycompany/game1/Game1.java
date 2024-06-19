       package com.mycompany.game1; //Esta linha declara o pacote onde a classe Game1 está localizada.
       import java.util.Scanner; // Importa a classe Scanner do pacote java.util, que será usada para ler entrada do usuário a partir do console. 
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\

        public class Game1 { // Aqui, estamos definindo uma classe Java chamada Game1. Esta classe provavelmente será o ponto de entrada (classe principal) do programa. 
        public static void main(String[] args) { // Este é o método main, que é o ponto de entrada de qualquer programa Java. Ele indica onde a execução do programa começará.
        Scanner scanner = new Scanner(System.in); // Aqui, estamos criando um objeto Scanner chamado scanner, que será usado para ler a entrada do usuário a partir do console. 

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\

        // Criando um Mago 
        // Estamos solicitando ao usuário que digite o nome do Mago e armazenando essa entrada na variável nomeMago. scanner.nextLine() lê toda a linha de entrada até que o usuário pressione Enter. 
        System.out.print("Digite o nome do Mago: "); 
        String nomeMago = scanner.nextLine();
        
        
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\

        //Similarmente, estamos solicitando ao usuário que digite a vida do Mago e armazenando essa entrada na variável vidaMago. scanner.nextInt()
        //lê o próximo número inteiro digitado pelo usuário. Após isso, scanner.nextLine() é usado para consumir a quebra de linha deixada pelo nextInt(),
        //evitando problemas futuros de leitura de entrada. 
                
        System.out.print("Digite a vida do Mago: ");
        int vidaMago = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após o próximo inteiro
        
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\ 

        Mago mago = new Mago(nomeMago, vidaMago); // Aqui estamos criando um objeto da classe Mago, passando como parâmetros o nome e a vida do Mago, conforme digitados pelo usuário.
        
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\

        // Estamos adicionando itens e poderes ao objeto mago que acabamos de criar. 
        // Cada item (Item) tem um nome e um valor associado (potencialmente pontos de cura ou mana), enquanto cada poder (Poder) possui apenas um nome.
        mago.adicionarItem (new Item("Poção de Cura", 20));
        mago.adicionarItem (new Item("Poção de Mana", 10));
        mago.adicionarPoder(new Poder("Bola de Fogo"));
        mago.adicionarPoder(new Poder("Raio"));
        mago.adicionarPoder(new Poder("Escudo Mágico"));
        mago.adicionarPoder(new Poder("Teleporte"));
        
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\
        // Estamos exibindo o status inicial do Mago, mostrando seu nome, vida, itens e poderes atuais.
        System.out.println("\nStatus inicial:");
        mago.mostrarStatus();
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\

        // Estamos solicitando ao usuário que escolha um item para usar. 
        // Mostramos o inventário atual do Mago e depois lemos o número inteiro que representa a escolha do item. 
        // O método usarItem(escolhaItem) provavelmente irá usar o item selecionado pelo Mago.
        System.out.println("\nEscolha um item para usar:");
        mago.mostrarInventario();
        int escolhaItem = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após o próximo inteiro
        mago.usarItem(escolhaItem);
        
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\
        // Da mesma forma, estamos solicitando ao usuário que escolha um poder para usar. 
        // Mostramos os poderes disponíveis do Mago e então lemos o número inteiro que representa a escolha do poder. 
        // O método usarPoder(escolhaPoder) provavelmente irá usar o poder selecionado pelo Mago.
        System.out.println("\nEscolha um poder para usar:");
        mago.mostrarPoderes();
        int escolhaPoder = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após o próximo inteiro
        mago.usarPoder(escolhaPoder);
        
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\
        scanner.close(); //Finalmente, fechamos o objeto Scanner para liberar recursos. É uma boa prática fechar o Scanner quando não precisamos mais dele para evitar vazamentos de recursos.
                         //Este código Java é um exemplo simples de interação com o usuário através do console, 
                         // onde um objeto Mago é criado com nome e vida fornecidos pelo usuário, e o usuário pode adicionar itens e poderes, bem como usá-los conforme desejar.
  
}
}

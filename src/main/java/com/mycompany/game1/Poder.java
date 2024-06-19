package com.mycompany.game1;

// Classe para os poderes

public class Poder { /*Esta linha declara uma nova classe pública chamada Poder. 
                     O publicmodificador de acesso significa que a classe pode ser acessada de qualquer lugar do programa.*/
    
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\
    
private String nome; /*Esta linha declara uma variável de instância privada nomedo tipo String. 
                     O privatemodificador de acesso significa que esta variável só pode ser acessada dentro da mesma classe, 
                     e não de fora da classe.*/

public Poder(String nome) { /* Esta linha declara um construtor para a Poderclasse. 
                     Um construtor é um método especial chamado quando um objeto é criado. 
                     Este construtor recebe um parâmetro: nomedo tipo String. */
    
this.nome = nome;   /*Esta linha atribui o valor do nomeparâmetro à variável de instância nome. 
                    A thispalavra-chave é usada para se referir ao objeto atual que está sendo construído. */
}                   //Esta linha fecha o método construtor.
                    

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\

public void usar() {                      //Esta linha declara um método público chamado usarque não retorna nenhum valor (ou seja, void).
System.out.println(nome + " foi usado!"); /*Esta linha imprime uma mensagem no console usando System.out.println. 
                                          A mensagem é construída concatenando o valor da nomevariável de instância com a string "foi usada!". 
                                          Por exemplo, se a nomevariável tiver o valor “Fogo”, a mensagem seria “Fogo foi usado!”. */
}//Esta linha fecha o usarmétodo.

public String getNome() { //Esta linha declara um método público chamado getNomeque retorna um Stringvalor.
return nome;              //Esta linha retorna o valor da variável de instância nome.
}                         //Esta linha fecha o getNomemétodo.
}                         
                          /*Em resumo, esta classe possui uma variável de instância privada nome, 
                          um construtor que inicializa esta variável, 
                          um método usarque imprime uma mensagem no console e um método getter getNomeque permite acesso externo à nomevariável. */
package com.mycompany.game1;


// Classe base para o personagem
public class Personagem { //Comentário que descreve a classe Personagem como a classe base para personagens no jogo.
    
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\  
    
//Declaração de dois atributos protegidos (protected):
//nome: Armazena o nome do personagem (uma string).
//vida: Armazena o valor da vida do personagem (um número inteiro).

protected String nome;
protected int vida;

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\

//Construtor da classe Personagem, responsável por inicializar um objeto Personagem com um nome e um valor de vida especificados.
//this.nome = nome;: Atribui o valor do parâmetro nome ao atributo nome do objeto atual (this).
//this.vida = vida;: Atribui o valor do parâmetro vida ao atributo vida do objeto atual (this).
public Personagem(String nome, int vida) {
this.nome = nome;
this.vida = vida;
 }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\

//Método mostrarStatus(), que imprime na tela o nome e a vida do personagem.
//System.out.println("Nome: " + nome);: Imprime o nome do personagem seguido pelo valor do atributo nome.
//System.out.println("Vida: " + vida);: Imprime a vida do personagem seguida pelo valor do atributo vida.
public void mostrarStatus() {
System.out.println("Nome: " + nome);
System.out.println("Vida: " + vida);

 }
 }




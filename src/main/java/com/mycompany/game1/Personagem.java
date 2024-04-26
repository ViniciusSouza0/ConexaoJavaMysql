package com.mycompany.game1;


// Classe base para o personagem
public class Personagem {
protected String nome;
protected int vida;

public Personagem(String nome, int vida) {
this.nome = nome;
this.vida = vida;
    }

public void mostrarStatus() {
System.out.println("Nome: " + nome);
System.out.println("Vida: " + vida);


}
}



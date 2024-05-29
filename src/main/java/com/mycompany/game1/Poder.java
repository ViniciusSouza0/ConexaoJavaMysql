package com.mycompany.game1;

// Classe para os poderes

public class Poder {
    
        
    private String nome;
    public Poder(String nome) {
        this.nome = nome;
    }

    public void usar() {
        System.out.println(nome + " foi usado!");
    }

    public String getNome() {
        return nome;
    }
}
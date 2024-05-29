package com.mycompany.game1;


// Classe para os itens
public class Item {
    private String nome;
    private int efeito;

    public Item(String nome, int efeito) {
        this.nome = nome;
        this.efeito = efeito;
    }

    public String getNome() {
        return nome;
    }

    public int getEfeito() {
        return efeito;
    }
}

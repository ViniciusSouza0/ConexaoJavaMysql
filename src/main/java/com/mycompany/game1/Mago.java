package com.mycompany.game1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


        // Subclasse Mago que herda de Personagem
        class Mago extends Personagem {
        private List<Item> inventario;
        private List<Poder> poderes;

        public Mago(String nome, int vida) {
        super(nome, vida);
        this.inventario = new ArrayList<>();
        this.poderes = new ArrayList<>();
}

    public void adicionarItem(Item item) {
        inventario.add(item); //Dentro do inventário adicionamos item e poderes
    }

    public void adicionarPoder(Poder poder) {
        poderes.add(poder);
    }

    public void usarItem(int indice) {
        if (indice >= 0 && indice < inventario.size()) {
            Item item = inventario.get(indice);
            vida += item.getEfeito();
            System.out.println(nome + " usou " + item.getNome() + ". Vida atual: " + vida);
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public void usarPoder(int indice) {
        if (indice >= 0 && indice < poderes.size()) {
            Poder poder = poderes.get(indice);
            poder.usar();
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public void mostrarInventario() {
        System.out.println("Inventário de " + nome + ":");
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println(i + ". " + inventario.get(i).getNome());
        }
    }

    public void mostrarPoderes() {
        System.out.println("Poderes de " + nome + ":");
        for (int i = 0; i < poderes.size(); i++) {
            System.out.println(i + ". " + poderes.get(i).getNome());
        }
    }
}
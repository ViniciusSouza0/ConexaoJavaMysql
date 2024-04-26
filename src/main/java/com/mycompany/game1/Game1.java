package com.mycompany.game1;

import java.util.Scanner;


public class Game1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando um Mago
        System.out.print("Digite o nome do Mago: ");
        String nomeMago = scanner.nextLine();
        System.out.print("Digite a vida do Mago: ");
        int vidaMago = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após o próximo inteiro
        Mago mago = new Mago(nomeMago, vidaMago);

        // Adicionando itens e poderes ao Mago
        mago.adicionarItem(new Item("Poção de Cura", 20));
        mago.adicionarItem(new Item("Poção de Mana", 10));
        mago.adicionarPoder(new Poder("Bola de Fogo"));
        mago.adicionarPoder(new Poder("Raio"));
        mago.adicionarPoder(new Poder("Escudo Mágico"));
        mago.adicionarPoder(new Poder("Teleporte"));

        // Mostrando status inicial do Mago
        System.out.println("\nStatus inicial:");
        mago.mostrarStatus();

        // Usando um item
        System.out.println("\nEscolha um item para usar:");
        mago.mostrarInventario();
        int escolhaItem = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após o próximo inteiro
        mago.usarItem(escolhaItem);

        // Usando um poder
        System.out.println("\nEscolha um poder para usar:");
        mago.mostrarPoderes();
        int escolhaPoder = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após o próximo inteiro
        mago.usarPoder(escolhaPoder);

        scanner.close();
    }
}

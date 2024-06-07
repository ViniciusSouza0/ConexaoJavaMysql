package com.mycompany.game1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Mago extends Personagem {
    private List<Item> inventario;
    private List<Poder> poderes;

    public Mago(String nome, int vida) {
        super(nome, vida);
        this.inventario = new ArrayList<>();
        this.poderes = new ArrayList<>();
        salvar();
    }

    public void adicionarItem(Item item) {
        inventario.add(item);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpg", "rpg","senacrs")) {
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

    public void adicionarPoder(Poder poder) {
        poderes.add(poder);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpg", "rpg","senacrs")) {
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

    public void salvar() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpg", "rpg","senacrs")) {
            String sql = "INSERT INTO magos (nome, vida) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, this.nome);
                statement.setInt(2, this.vida);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Mago carregar(String nome) {
        Mago mago = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rpg", "rpg","senacrs")) {
            String sql = "SELECT * FROM magos WHERE nome = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, nome);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    int vida = resultSet.getInt("vida");
                    mago = new Mago(nome, vida);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mago;
    }
}
create database rpg;
use rpg;

INSERT INTO itens (nome, efeito, mago_nome) VALUES ("anel",1, "vini");
insert into magos (nome,vida) values ("vini",5);
desc poderes;

drop database rpg;

CREATE TABLE magos (
    nome VARCHAR(100) PRIMARY KEY,
    vida INT
);

CREATE TABLE itens (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    efeito INT,
    mago_nome VARCHAR(100),
    FOREIGN KEY (mago_nome) REFERENCES magos(nome)
);

CREATE TABLE poderes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    mago_nome VARCHAR(100),
    FOREIGN KEY (mago_nome) REFERENCES magos(nome)
);

select * from poderes;
select * from itens;
select * from magos;


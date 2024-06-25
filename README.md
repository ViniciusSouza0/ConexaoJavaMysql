# Jogo Do Mago
Este é um projeto de um jogo simples em Java, que utiliza programação orientada a objetos. O objetivo do jogo é ajustar os atributos do personagens: Mago, de acordo com os requisitos especificados.

## Descrição Do Jogo 
O jogo consiste em equipar o personagem mago, colocando um nome, um valor de vida, escolhendo um item para ele usar e um poder.  
- O nome é de escolha livre.  
- A vida é de escolha Livre.  
- Quantidade de itens, 2: Mana e Cura.  
- Quantidade de poderes, 4: Bola de fogo, raio, Teleporte, Escudo Mágico. 


## Iniciando O Jogo
Ao iniciar o jogo, você verá as seguintes opções:
>Digite o nome do Mago:  
>Digite a vida do Mago:

Após preencher as informações, o jogo te mostrará um status inicial, EXEMPLO:

>Status inicial:  
>Nome: wizard  
>Vida: 100

Dando sequência, a próxima etapa do jogo te mostrará um inventário, lá estarão dois itens que o mago deverá escolher para utilizar, EXEMPLO:
> Escolha um item para usar:  
> Inventário de wizard:
> 
>0.Poção de Cura  
>1.Poção de Mana

Dependendo do número que você escolher, irá aparecer o seguinte status.
>1  
>wizard usou Poção de Mana.  
>Vida atual: 110

>0  
>wizard usou Poção de Cura.  
>Vida atual: 120

_( A **Mana** aumenta 10 de vida. )_  
_( A **Cura** aumenta 20 de vida. )_

Após isso, o código entrará na seleção de escolher poderes e mostrará os poderes disponíveis para uso, EXEMPLO:
>Escolha um poder para usar:  
>Poderes de wizard:
> 
>0. Bola de Fogo
>1. Raio
>2. Escudo Mágico
>3. Teleporte

Dependendo do poder que você escolher, mostrará na tela, que o poder escolhido foi usado. EXEMPLO:  
>Teleporte foi usado!

Assim, encerrando nosso código.

# Pré-requisitos  
Java 8 ou superior  
MySQL  
Conector JDBC para MySQL  

# Configuração do Banco de Dados
```sql
create database rpg;  
use rpg;   

INSERT INTO itens (nome, efeito, mago_nome) VALUES ("item",1, "nome");  
insert into magos (nome,vida) values ("nome",5);  
desc poderes;  

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
```
# Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.  

# Licença  
Este projeto está licenciado sob a MIT License.  

# Contato

Autor: Vinícius Souza da Silva  
E-mail: vinicius.s.silveira.2015@gmail.com

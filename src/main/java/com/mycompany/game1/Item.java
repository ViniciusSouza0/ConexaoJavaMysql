package com.mycompany.game1;


// Classe para os itens
public class Item { //Esta linha declara uma nova classe pública chamada Item. O publicmodificador de acesso significa que a classe pode ser acessada de qualquer lugar do programa.
private String nome;/*Esta linha declara uma variável de instância privada nomedo tipo String. 
                      O privatemodificador de acesso significa que esta variável só pode ser acessada dentro da mesma classe, e não de fora da classe.*/
private int efeito; //Esta linha declara outra variável de instância privada efeitodo tipo int.

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\

public Item(String nome, int efeito) { /*Esta linha declara um construtor para a Itemclasse. 
                                       Um construtor é um método especial chamado quando um objeto é criado. 
                                       Este construtor recebe dois parâmetros: nomede tipo Stringe efeitode tipo int.*/
    
this.nome = nome;     //Esta linha atribui o valor do nomeparâmetro à variável de instância nome. A thispalavra-chave é usada para se referir ao objeto atual que está sendo construído.
this.efeito = efeito; //Esta linha atribui o valor do efeitoparâmetro à variável de instância efeito.
}
//Esta linha fecha o método construtor.

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\

public String getNome() { //Esta linha declara um método público chamado getNomeque retorna um Stringvalor.
return nome;              //Esta linha retorna o valor da variável de instância nome.
}
//Esta linha fecha o getNomemétodo.

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\\

public int getEfeito() { //Esta linha declara um método público chamado getEfeitoque retorna um intvalor.
return efeito;           //Esta linha retorna o valor da variável de instância efeito.
}                     
} //Esta linha fecha o getEfeitométodo.

  /*Em resumo, esta classe possui duas variáveis ​​de instância privadas nomee efeito,
  um construtor que inicializa essas variáveis, e dois métodos getter getNomee getEfeitoque permitem acesso externo a essas variáveis.*/
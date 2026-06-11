# Xadrez POO

Projeto desenvolvido em **Java** para a disciplina de **Programação Orientada a Objetos**, com o objetivo de simular uma partida de xadrez utilizando conceitos de POO, como classes, objetos, herança, encapsulamento, abstração e sobrescrita de métodos.

## Sobre o projeto

O sistema representa um jogo de xadrez executado pelo terminal, permitindo que dois jogadores realizem movimentos alternados entre peças brancas e pretas.

O projeto possui validação de movimentos das principais peças do xadrez, controle de turno, captura de peças, verificação de xeque, xeque-mate, empate por afogamento e promoção de peão.

## Funcionalidades

* Exibição do tabuleiro no terminal;
* Controle de turno entre peças brancas e pretas;
* Movimentação das peças por coordenadas, como `a2`, `e4`, `h8`;
* Validação de movimentos para:

  * Rei;
  * Dama;
  * Torre;
  * Bispo;
  * Cavalo;
  * Peão;
* Captura de peças adversárias;
* Bloqueio de movimentos inválidos;
* Verificação de caminho livre para peças que não saltam;
* Detecção de xeque;
* Detecção de xeque-mate;
* Detecção de empate por afogamento;
* Promoção de peão ao chegar ao final do tabuleiro.

## Conceitos de Programação Orientada a Objetos utilizados

O projeto aplica os seguintes conceitos de POO:

### Classes e objetos

Cada elemento importante do jogo foi representado por classes, como `Peca`, `Tabuleiro`, `Casa`, `Jogo` e as classes específicas das peças.

### Herança

As peças do xadrez herdam da classe abstrata `Peca`, reaproveitando atributos e comportamentos comuns.

Exemplos de classes que herdam de `Peca`:

* `Rei`
* `Dama`
* `Torre`
* `Bispo`
* `Cavalo`
* `Peao`

### Abstração

A classe `Peca` define a estrutura base para todas as peças e possui o método abstrato `movimentoValido()`, que é implementado de forma específica em cada peça.

### Encapsulamento

Os atributos das classes são protegidos por modificadores de acesso e manipulados por métodos getters e setters.

### Polimorfismo

Cada peça possui sua própria implementação do método `movimentoValido()`, permitindo que o jogo trate diferentes peças de forma genérica por meio da classe `Peca`.

## Estrutura do projeto

```text
Xadrez_POO/
├── README.md
├── .gitignore
└── src/
    ├── Main.java
    ├── Jogo.java
    ├── Tabuleiro.java
    ├── Casa.java
    ├── Peca.java
    ├── Rei.java
    ├── Dama.java
    ├── Torre.java
    ├── Bispo.java
    ├── Cavalo.java
    └── Peao.java
```

## Como executar

Para executar o projeto, é necessário ter o **Java JDK** instalado na máquina.

### 1. Clone o repositório

```bash
git clone URL_DO_REPOSITORIO
```

### 2. Acesse a pasta do projeto

```bash
cd Xadrez_POO
```

### 3. Compile os arquivos Java

```bash
javac src/*.java
```

### 4. Execute o programa

```bash
java -cp src Main
```

## Como jogar

O jogo é executado pelo terminal. Em cada turno, o jogador deve informar:

1. A coordenada da peça que deseja mover;
2. A coordenada de destino.

Exemplo:

```text
Qual peça mover? e2
Para onde mover? e4
```

As coordenadas seguem o padrão tradicional do xadrez:

* Colunas: `a` até `h`;
* Linhas: `1` até `8`.

## Representação das peças

No tabuleiro, as peças são exibidas com a inicial da cor e o símbolo da peça.

Exemplos:

```text
BR = Rei branco
BD = Dama branca
BT = Torre branca
BP = Peão branco

PR = Rei preto
PD = Dama preta
PT = Torre preta
PP = Peão preto
```

## Tecnologias utilizadas

* Java
* Programação Orientada a Objetos
* Git e GitHub

## Autores

Trabalho desenvolvido em dupla por:

* Luís Gustavo Ribeiro de Freitas — RA: 143379
* Matheus Pinheiro Faria — RA: 145127

## Observações

Este projeto foi desenvolvido com fins acadêmicos, com foco na aplicação prática dos conceitos de Programação Orientada a Objetos em Java.

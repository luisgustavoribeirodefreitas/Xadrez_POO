# Xadrez POO - MVC

## Autores

Trabalho desenvolvido por:

- Luís Gustavo Ribeiro de Freitas — RA: 143379
- Matheus Pinheiro Faria — RA: 145127

## Descrição breve

Este projeto é um jogo de xadrez desenvolvido em **Java** para a disciplina de **Programação Orientada a Objetos**. O sistema foi organizado utilizando o padrão **MVC** e possui uma interface gráfica feita com **Java Swing**, permitindo que dois jogadores movimentem as peças por cliques no tabuleiro.

O projeto aplica conceitos como classes, objetos, herança, encapsulamento, abstração, polimorfismo e sobrescrita de métodos. A versão antiga em terminal foi preservada no pacote `xadrez.legado`, mas a execução principal do projeto é feita pela interface gráfica.

## Sobre o projeto

O jogo representa uma partida de xadrez entre peças brancas e pretas. O jogador seleciona uma peça clicando sobre ela e, em seguida, escolhe a casa de destino.

A interface exibe o tabuleiro em uma janela, mostra as peças com símbolos Unicode e apresenta mensagens ao jogador durante a partida.

## Arquitetura MVC

O projeto foi organizado em três camadas principais:

### Model

O pacote `xadrez.model` contém as classes responsáveis pelos dados e pelas regras do jogo.

Principais classes:

- `Tabuleiro`
- `Casa`
- `Peca`
- `Rei`
- `Dama`
- `Torre`
- `Bispo`
- `Cavalo`
- `Peao`

O Model é responsável por validar movimentos, movimentar peças, capturar peças adversárias, verificar xeque, xeque-mate, afogamento e promoção de peão.

### View

O pacote `xadrez.view` contém as classes responsáveis pela interface gráfica.

Principais classes:

- `JanelaPrincipal`
- `PainelTabuleiro`
- `BotaoCasa`

A View exibe a janela do jogo, o tabuleiro, as peças e as mensagens para o usuário.

### Controller

O pacote `xadrez.controller` contém a classe responsável por ligar a interface gráfica às regras do jogo.

Classe principal:

- `XadrezController`

O Controller recebe os cliques do usuário, identifica a casa de origem e a casa de destino, chama o `Tabuleiro` para validar o movimento e atualiza a interface após cada jogada.

## Funcionalidades

- Interface gráfica com Java Swing;
- Exibição do tabuleiro com 64 casas;
- Peças representadas por símbolos Unicode;
- Seleção de peça por clique;
- Seleção de destino por clique;
- Controle de turno entre brancas e pretas;
- Validação de movimentos das peças;
- Captura de peças adversárias;
- Bloqueio de movimentos inválidos;
- Verificação de caminho livre para peças que não saltam;
- Detecção de xeque;
- Detecção de xeque-mate;
- Detecção de empate por afogamento;
- Promoção de peão com escolha pela interface gráfica.

## Peças implementadas

O projeto implementa as seguintes peças:

- Rei
- Dama
- Torre
- Bispo
- Cavalo
- Peão

Todas as peças herdam da classe abstrata `Peca` e implementam o método `movimentoValido()` de acordo com suas próprias regras de movimentação.

## Representação visual das peças

Na interface gráfica, as peças são representadas com símbolos Unicode:

```text
♔ Rei branco
♕ Dama branca
♖ Torre branca
♗ Bispo branco
♘ Cavalo branco
♙ Peão branco

♚ Rei preto
♛ Dama preta
♜ Torre preta
♝ Bispo preto
♞ Cavalo preto
♟ Peão preto
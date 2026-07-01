package xadrez.view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;

import xadrez.model.Tabuleiro;
import xadrez.model.Peca;
import xadrez.model.Rei;
import xadrez.model.Dama;
import xadrez.model.Torre;
import xadrez.model.Bispo;
import xadrez.model.Cavalo;
import xadrez.model.Peao;

public class PainelTabuleiro extends JPanel {
    private BotaoCasa[][] botoes;

    public PainelTabuleiro() {
        botoes = new BotaoCasa[8][8];

        setLayout(new GridLayout(8, 8));

        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                BotaoCasa botao = new BotaoCasa(linha, coluna);
                botoes[linha][coluna] = botao;
                add(botao);
            }
        }
    }

    public void atualizar(Tabuleiro tabuleiro) {
        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                BotaoCasa botao = botoes[linha][coluna];

                configurarCorCasa(botao, linha, coluna);

                Peca peca = tabuleiro.getPeca(linha, coluna);

                botao.setText(obterSimboloPeca(peca));
                botao.setForeground(Color.BLACK);
            }
        }
    }

    private void configurarCorCasa(BotaoCasa botao, int linha, int coluna) {
        if ((linha + coluna) % 2 == 0) {
            botao.setBackground(new Color(240, 217, 181));
        } else {
            botao.setBackground(new Color(181, 136, 99));
        }
    }

    private String obterSimboloPeca(Peca peca) {
        if (peca == null) {
            return "";
        }

        String cor = peca.getCor().toLowerCase();
        boolean branca = cor.startsWith("b");

        if (peca instanceof Rei) {
            return branca ? "♔" : "♚";
        } else if (peca instanceof Dama) {
            return branca ? "♕" : "♛";
        } else if (peca instanceof Torre) {
            return branca ? "♖" : "♜";
        } else if (peca instanceof Bispo) {
            return branca ? "♗" : "♝";
        } else if (peca instanceof Cavalo) {
            return branca ? "♘" : "♞";
        } else if (peca instanceof Peao) {
            return branca ? "♙" : "♟";
        }

        return "";
    }

    public BotaoCasa getBotao(int linha, int coluna) {
        return botoes[linha][coluna];
    }

    public void destacarCasa(int linha, int coluna) {
        botoes[linha][coluna].setBackground(new Color(255, 255, 120));
    }

}

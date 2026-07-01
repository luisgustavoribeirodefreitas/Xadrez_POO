package xadrez.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import xadrez.model.Peca;
import xadrez.model.Peao;
import xadrez.model.Tabuleiro;
import xadrez.view.BotaoCasa;
import xadrez.view.JanelaPrincipal;
import xadrez.view.PainelTabuleiro;

public class XadrezController {
    private Tabuleiro tabuleiro;
    private PainelTabuleiro painelTabuleiro;
    private JanelaPrincipal janela;

    private int linhaOrigem;
    private int colunaOrigem;
    private boolean selecionouOrigem;

    private String corAtual;

    public XadrezController(Tabuleiro tabuleiro, PainelTabuleiro painelTabuleiro, JanelaPrincipal janela) {
        this.tabuleiro = tabuleiro;
        this.painelTabuleiro = painelTabuleiro;
        this.janela = janela;

        linhaOrigem = -1;
        colunaOrigem = -1;
        selecionouOrigem = false;

        corAtual = "branco";

        adicionarEventos();
    }

    private void adicionarEventos() {
        for (int linha = 0; linha < 8; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                BotaoCasa botao = painelTabuleiro.getBotao(linha, coluna);

                botao.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        BotaoCasa botaoClicado = (BotaoCasa) e.getSource();
                        tratarClique(botaoClicado);
                    }
                });
            }
        }
    }

    private void tratarClique(BotaoCasa botao) {
        int linha = botao.getLinha();
        int coluna = botao.getColuna();

        if (!selecionouOrigem) {
            selecionarOrigem(linha, coluna);
        } else {
            selecionarDestino(linha, coluna);
        }
    }

    private void selecionarOrigem(int linha, int coluna) {
        Peca peca = tabuleiro.getPeca(linha, coluna);

        if (peca == null) {
            janela.setMensagem("Selecione uma peça para mover.");
            return;
        }

        if (!mesmaCor(peca.getCor(), corAtual)) {
            janela.setMensagem("Não é a vez dessa cor.");
            return;
        }

        linhaOrigem = linha;
        colunaOrigem = coluna;
        selecionouOrigem = true;

        painelTabuleiro.destacarCasa(linha, coluna);
        janela.setMensagem("Peça selecionada. Agora escolha o destino.");
    }

    private void selecionarDestino(int linhaDestino, int colunaDestino) {
        Peca pecaOrigem = tabuleiro.getPeca(linhaOrigem, colunaOrigem);

        if (pecaOrigem == null) {
            limparSelecao();
            painelTabuleiro.atualizar(tabuleiro);
            janela.setMensagem("Selecione uma peça para mover.");
            return;
        }

        if (ehPromocaoDePeao(pecaOrigem, linhaDestino)) {
            String escolha = janela.escolherPromocao();

            if (escolha == null) {
                limparSelecao();
                painelTabuleiro.atualizar(tabuleiro);
                janela.setMensagem("Promoção cancelada. Selecione uma peça.");
                return;
            }

            tabuleiro.setTipoPromocao(escolha);
        }

        String corDaPeca = pecaOrigem.getCor();

        boolean movimentoValido = tabuleiro.mover(
                linhaOrigem,
                colunaOrigem,
                linhaDestino,
                colunaDestino,
                corDaPeca
        );

        tabuleiro.setTipoPromocao("Dama");

        painelTabuleiro.atualizar(tabuleiro);
        limparSelecao();

        if (movimentoValido) {
            trocarCorAtual();
            janela.setMensagem("Vez das peças " + nomeCorAtual() + ".");
        } else {
            janela.setMensagem("Movimento inválido. Selecione outra peça.");
        }
    }

    private boolean ehPromocaoDePeao(Peca peca, int linhaDestino) {
        if (!(peca instanceof Peao)) {
            return false;
        }

        if (peca.getCor().toLowerCase().startsWith("b")) {
            return linhaDestino == 0;
        } else {
            return linhaDestino == 7;
        }
    }

    private void limparSelecao() {
        linhaOrigem = -1;
        colunaOrigem = -1;
        selecionouOrigem = false;
    }

    private boolean mesmaCor(String cor1, String cor2) {
        if (cor1 == null || cor2 == null) {
            return false;
        }

        cor1 = cor1.toLowerCase();
        cor2 = cor2.toLowerCase();

        return cor1.charAt(0) == cor2.charAt(0);
    }

    private void trocarCorAtual() {
        if (corAtual.toLowerCase().startsWith("b")) {
            corAtual = "preto";
        } else {
            corAtual = "branco";
        }
    }

    private String nomeCorAtual() {
        if (corAtual.toLowerCase().startsWith("b")) {
            return "brancas";
        } else {
            return "pretas";
        }
    }
}
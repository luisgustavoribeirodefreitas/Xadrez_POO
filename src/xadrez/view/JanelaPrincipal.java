package xadrez.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;

import xadrez.model.Tabuleiro;
import xadrez.controller.XadrezController;

public class JanelaPrincipal extends JFrame {
    private Tabuleiro tabuleiro;
    private PainelTabuleiro painelTabuleiro;
    private JLabel mensagem;

    public JanelaPrincipal() {
        tabuleiro = new Tabuleiro();
        painelTabuleiro = new PainelTabuleiro();

        mensagem = new JLabel("Jogo de Xadrez", SwingConstants.CENTER);
        mensagem.setFont(new Font("Arial", Font.BOLD, 18));

        setTitle("Xadrez");
        setLayout(new BorderLayout());

        add(mensagem, BorderLayout.NORTH);
        add(painelTabuleiro, BorderLayout.CENTER);

        painelTabuleiro.atualizar(tabuleiro);

        new XadrezController(tabuleiro, painelTabuleiro, this);

        setSize(640, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setMensagem(String texto) {
        mensagem.setText(texto);
    }
}
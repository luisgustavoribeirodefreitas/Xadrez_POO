package xadrez.view;

import javax.swing.JButton;
import java.awt.Font;

public class BotaoCasa extends JButton {
    private int linha;
    private int coluna;

    public BotaoCasa(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;

        setFont(new Font("Segoe UI Symbol", Font.PLAIN, 42));
        setFocusPainted(false);
        setBorderPainted(false);
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }
}

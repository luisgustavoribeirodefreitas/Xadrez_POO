package xadrez.appjogo;

import javax.swing.SwingUtilities;
import xadrez.view.JanelaPrincipal;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal();
            }
        });
    }
}
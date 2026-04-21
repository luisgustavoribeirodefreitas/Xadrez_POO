public class Jogo {
    private Casa[][] tabuleiro;
    private String jogadorAtual;

    public Jogo() {
        tabuleiro = new Casa[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabuleiro[i][j] = new Casa(i, j);
            }
        }
        jogadorAtual = "Branco";
    }

    public Casa getCasa(int linha, int coluna) {
        return tabuleiro[linha][coluna];
    }

    public String getJogadorAtual() {
        return jogadorAtual;
    }

    public void mudarJogador() {
        jogadorAtual = jogadorAtual.equals("Branco") ? "Preto" : "Branco";
    }
}

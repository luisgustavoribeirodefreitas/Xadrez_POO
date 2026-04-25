public class Bispo extends Peca{

    public Bispo(String cor, int linha, int coluna, int jogadas) {
        super("Bispo", cor, linha, coluna, jogadas);
    }

    @Override
    public boolean movimentoValido(int novaLinha, int novaColuna) {
        if (novaLinha == getLinha() &&  novaColuna == getColuna()) {
            return false;
        }
        else {
        return Math.abs(novaLinha - getLinha()) == Math.abs(novaColuna - getColuna());
        }
    }
}
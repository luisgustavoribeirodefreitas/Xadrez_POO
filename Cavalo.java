public class Cavalo extends Peca{

    public Cavalo(String cor, int linha, int coluna, int jogadas){
        super("Cavalo", cor, linha, coluna, jogadas);
    }

    @Override
    public boolean movimentoValido(int novaLinha, int novaColuna){
        if (novaLinha == getLinha() &&  novaColuna == getColuna()) {
            return false;
        }
        else {
        return (Math.abs(novaLinha - getLinha()) == 2 && Math.abs(novaColuna - getColuna()) == 1) || (Math.abs(novaLinha - getLinha()) == 1 && Math.abs(novaColuna - getColuna()) == 2);
        }
    }  
}

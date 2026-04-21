public class Cavalo extends Peca{

    public Cavalo(String cor, int linha, int coluna, int jogadas){
        super("Cavalo", cor, linha, coluna, jogadas);
    }

    @Override
    public boolean movimentoValido(int novalinha, int novacoluna){
        return (Math.abs(novalinha - getLinha()) == 2 && Math.abs(novacoluna - getColuna()) == 1) || (Math.abs(novalinha - getLinha()) == 1 && Math.abs(novacoluna - getColuna()) == 2);
    }
}

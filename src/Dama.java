public class Dama extends Peca{

    public Dama(String cor, int linha, int coluna, int jogadas){
        super("Dama", cor, linha, coluna, jogadas, "D");
    }
    
    @Override
    public boolean movimentoValido(int novaLinha, int novaColuna){
        if (novaLinha == getLinha() &&  novaColuna == getColuna()) {
            return false;
        }
        else {
        return (novaLinha == getLinha()) || (novaColuna == getColuna()) || (Math.abs(novaLinha - getLinha()) == Math.abs(novaColuna - getColuna()));
        }
    }
}
public class Dama extends Peca{

    public Dama(String cor, int linha, int coluna, int jogadas){
        super("Dama", cor, linha, coluna, jogadas);
    }
    
    @Override
    public boolean movimentoValido(int novalinha, int novacoluna){
        return (novalinha == getLinha()) || (novacoluna == getColuna()) || (Math.abs(novalinha - getLinha()) == Math.abs(novacoluna - getColuna()));
    }
}
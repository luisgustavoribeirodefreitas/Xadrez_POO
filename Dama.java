public class Dama extends Peca{

    public Dama(Sting cor, int linha, int coluna, int jogadas){
        super("Dama", cor, linha, coluna, jogadas);
    }
    
    @Override
    public boolean movimentoValido(int novalinha, int novacoluna){
        return (novalinha == getlinha()) || (novacoluna == getcoluna()) || (Math.abs(novalinha - getlinha()) == Math.abs(novacoluna - getcoluna()));
    }



}
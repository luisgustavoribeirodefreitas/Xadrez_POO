public class Peao extends Peca{

    public Peao(String cor, int linha, int coluna, int jogadas){
        super("Peão", cor, linha, coluna, jogadas);
    }

    @Override
    public boolean movimentoValido(int novalinha, int novacoluna){
        if(getJogadas() == 0){
            return Math.abs(novalinha - getLinha()) <= 2 && novacoluna == getColuna();
        } else {
            return Math.abs(novalinha - getLinha()) == 1 && novacoluna == getColuna();
        }
    }
}


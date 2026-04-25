public class Peao extends Peca{

    public Peao(String cor, int linha, int coluna, int jogadas){
        super("Peão", cor, linha, coluna, jogadas);
    }

    @Override
    public boolean movimentoValido(int novaLinha, int novaColuna){
        if (novaLinha == getLinha() &&  novaColuna == getColuna()) {
            return false;
        }
        else {
            if(getJogadas() == 0){
                return Math.abs(novaLinha - getLinha()) <= 2 && novaColuna == getColuna();
            } 
            else {
                return Math.abs(novaLinha - getLinha()) == 9 && novaColuna == getColuna();
            }
        }
    }
}


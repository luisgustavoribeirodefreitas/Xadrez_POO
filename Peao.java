public class Peao extends Peca{

    public Peao(String cor, int linha, int coluna, int jogadas){
        super("Peão", cor, linha, coluna, jogadas);
    }

    @Override
    public boolean movimentoValido(int novaLinha, int novaColuna){

        if (novaLinha == getLinha() && novaColuna == getColuna()) {
            return false;
        } 
        

        int direcao = getCor().equals("Branco") ? -1 : 1;

        if(novaColuna == getColuna()){
            if(getJogadas() == 0){
                return novaLinha == getLinha() + direcao || 
                    novaLinha == getLinha() + 2 * direcao;
            } else {
                return novaLinha == getLinha() + direcao;
            }
        }

        if(Math.abs(novaColuna - getColuna()) == 1 && 
        novaLinha == getLinha() + direcao){
            return true;
        }

    return false;
    }
}


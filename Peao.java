public class Peao extends Peca{

    public Peao(String cor, int linha, int coluna, int jogadas){
        super("Peão", cor, linha, coluna, jogadas);
    }

    @Override
    public boolean movimentoValido(int novaLinha, int novaColuna){
        int direcao;
        if (getCor().equals("Branco")) {
            direcao = -1;
        } else {
            direcao = 1;
        }
        int diferencaLinha = novaLinha - getLinha();
        int diferencaColuna = Math.abs(novaColuna - getColuna());
        if (getJogadas() == 0 && diferencaLinha == direcao * 2 && diferencaColuna ==0) {
            return true;
    }   if (diferencaLinha == direcao && diferencaColuna ==0) {
            return  true;
    }   if (diferencaLinha == direcao && diferencaColuna == 1) {
            return true;
        }
        return false;
    }
}


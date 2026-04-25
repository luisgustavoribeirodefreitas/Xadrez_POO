public class Torre extends Peca{

    public Torre(String cor, int linha, int coluna, int jogadas){
        super("Torre", cor, linha, coluna, jogadas);
    }

    @Override
    public boolean movimentoValido(int novaLinha, int novaColuna){
        if (novaLinha == getLinha() &&  novaColuna == getColuna()) {
            return false;
        }
        else {
        return (novaLinha == getLinha() || novaColuna == getColuna());
        }
    }
}
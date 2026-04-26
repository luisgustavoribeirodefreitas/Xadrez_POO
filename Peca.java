public abstract class Peca{
    private String nome;
    private String cor;
    private int linha;
    private int coluna; 
    private int jogadas;
    private String simbolo;



    public Peca(String nome, String cor, int linha, int coluna, int jogadas, String simbolo){
        this.nome = nome;
        this.cor = cor;
        this.linha = linha;
        this.coluna = coluna;
        this.jogadas = jogadas;
        this.simbolo = simbolo;
    }



    public String getNome(){
        return nome;
    }
    public String getCor(){
        return cor;
    }
    public int getLinha(){
        return linha;
    }
    public int getColuna(){
        return coluna;
    }
    public int getJogadas(){
        return jogadas;
    }
    public String getSimbolo(){
        return simbolo;
    }



    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCor(String cor){
        this.cor = cor;
    }
    public void setLinha(int linha){
        this.linha = linha;
    }
    public void  setColuna(int coluna){
        this.coluna = coluna;   
    }  
    public void setJogadas(int jogadas){
        this.jogadas = jogadas;
    }
    public void setSimbolo(String simbolo){
        this.simbolo = simbolo;
    }



    public abstract boolean movimentoValido(int novaLinha, int novaColuna);

}

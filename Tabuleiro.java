public class Tabuleiro {
    
    private Casa[][] tabuleiro = new Casa[8][8];


    public Tabuleiro(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tabuleiro[i][j] = new Casa(i, j);
            }
        }
        iniciar();  
    }


    public void iniciar(){
        for(int j = 0; j < 8; j++){
                tabuleiro[1][j].setPeca(new Peao("Preto", 1, j, 0));
                tabuleiro[6][j].setPeca(new Peao("Branco", 6, j, 0));
            }




            tabuleiro[0][0].setPeca(new Torre("Preto", 0, 0, 0));
            tabuleiro[0][1].setPeca(new Cavalo("Preto", 0, 1, 0));
            tabuleiro[0][2].setPeca(new Bispo("Preto", 0, 2, 0));
            tabuleiro[0][3].setPeca(new Dama("Preto", 0, 3, 0));
            tabuleiro[0][4].setPeca(new Rei("Preto", 0, 4, 0));
            tabuleiro[0][5].setPeca(new Bispo("Preto", 0, 5, 0));
            tabuleiro[0][6].setPeca(new Cavalo("Preto", 0, 6, 0));
            tabuleiro[0][7].setPeca(new Torre("Preto", 0, 7, 0));




            tabuleiro[7][0].setPeca(new Torre("Branco", 7, 0, 0));
            tabuleiro[7][1].setPeca(new Cavalo("Branco", 7, 1, 0));
            tabuleiro[7][2].setPeca(new Bispo("Branco", 7, 2, 0));
            tabuleiro[7][3].setPeca(new Dama("Branco", 7, 3, 0));
            tabuleiro[7][4].setPeca(new Rei("Branco", 7, 4, 0));
            tabuleiro[7][5].setPeca(new Bispo("Branco", 7, 5, 0));
            tabuleiro[7][6].setPeca(new Cavalo("Branco", 7, 6, 0));
            tabuleiro[7][7].setPeca(new Torre("Branco", 7, 7, 0));
    }
}


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


    public boolean mover(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino, String turno) {
        Peca peca = tabuleiro[linhaOrigem][colunaOrigem].getPeca();

        if (peca == null){
            return false;
        }
        if (!peca.getCor().equals(turno)){ 
            return false;
        }
        if (!peca.movimentoValido(linhaDestino, colunaDestino)){ 
            return false;
        }

        Peca destino = tabuleiro[linhaDestino][colunaDestino].getPeca();

        if (destino != null && destino.getCor().equals(turno)){ 
            return false;
        }

        if (peca.getNome().equals("Peão")) {
                boolean ehDiagonal = colunaDestino != colunaOrigem;
            if (ehDiagonal && destino == null) {
                return false;
            }
            if (!ehDiagonal && destino != null) {
                return false;
            }
        }

        if (!peca.getNome().equals("Cavalo")) {
                int direcaoLinha  = (linhaDestino  > linhaOrigem)  ? 1 : (linhaDestino  < linhaOrigem)  ? -1 : 0;
                int direcaoColuna = (colunaDestino > colunaOrigem) ? 1 : (colunaDestino < colunaOrigem) ? -1 : 0;

                int linhaAtual  = linhaOrigem  + direcaoLinha;
                int colunaAtual = colunaOrigem + direcaoColuna;

                while (linhaAtual != linhaDestino || colunaAtual != colunaDestino) {
                    if (tabuleiro[linhaAtual][colunaAtual].getPeca() != null){
                        return false;
                    } 
                    linhaAtual  += direcaoLinha;
                    colunaAtual += direcaoColuna;
                }
        }

        tabuleiro[linhaDestino][colunaDestino].setPeca(peca);
        tabuleiro[linhaOrigem][colunaOrigem].removePeca();
        peca.setLinha(linhaDestino);
        peca.setColuna(colunaDestino);
        peca.setJogadas(peca.getJogadas() + 1);

        return true;
 }
    


    public void exibir() {
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + "  ");

            for (int j = 0; j < 8; j++) {
                Peca peca = tabuleiro[i][j].getPeca();
                if (peca == null) {
                    System.out.print("[   ]");
                } else if (peca.getCor().equals("Branco")) {
                    System.out.print("[ " + peca.getSimbolo() + " ]");
                } else {
                    System.out.print("[ " + peca.getSimbolo() + " ]");
                }
            }
            System.out.println();
        }
        System.out.println("     a    b    c    d    e    f    g    h");
    }
}


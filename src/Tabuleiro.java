import java.util.Scanner;




public class Tabuleiro {
    
    private Casa[][] tabuleiro = new Casa[8][8];
    private Scanner scanner = new Scanner(System.in);

    public Tabuleiro(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tabuleiro[i][j] = new Casa(i, j);
            }
        }
        iniciar();  
    }


    private void iniciar(){
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

    private Peca escolherPromocao(String cor, int linha, int coluna) {
        System.out.println("Peão promovido! Escolha a peça (Dama, Torre, Bispo, Cavalo): ");
        String escolha = scanner.next();
        switch (escolha.toLowerCase()) {
            case "dama":   return new Dama(cor,   linha, coluna, 0);
            case "torre":  return new Torre(cor,  linha, coluna, 0);
            case "bispo":  return new Bispo(cor,  linha, coluna, 0);
            case "cavalo": return new Cavalo(cor, linha, coluna, 0);
            default:
                System.out.println("Escolha inválida! Promovido para Dama por padrão.");
                return new Dama(cor, linha, coluna, 0);
        }
    }

    public boolean reiEmXeque(String cor) {
        int linhaRei  = -1;
        int colunaRei = -1;
 
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Peca p = tabuleiro[i][j].getPeca();
                if (p != null && p.getCor().equals(cor) && p.getNome().equals("Rei")) {
                    linhaRei  = i;
                    colunaRei = j;
                }
            }
        }
 
        boolean xeque = false;
 
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Peca p = tabuleiro[i][j].getPeca();
 
                if (p != null && !p.getCor().equals(cor) && p.movimentoValido(linhaRei, colunaRei)) {
 
                    boolean peaoAtacando = !p.getNome().equals("Peão") || j != colunaRei;
 
                    if (peaoAtacando) {
                        if (p.getNome().equals("Cavalo")) {
                            xeque = true;
                        } else {
                            int direcaoLinha  = (linhaRei > i) ? 1 : (linhaRei < i) ? -1 : 0;
                            int direcaoColuna = (colunaRei > j) ? 1 : (colunaRei < j) ? -1 : 0;
 
                            int linhaAtual  = i + direcaoLinha;
                            int colunaAtual = j + direcaoColuna;
 
                            boolean caminhoLivre = true;
                            while ((linhaAtual != linhaRei || colunaAtual != colunaRei) && caminhoLivre) {
                                if (tabuleiro[linhaAtual][colunaAtual].getPeca() != null) {
                                    caminhoLivre = false;
                                }
                                linhaAtual  += direcaoLinha;
                                colunaAtual += direcaoColuna;
                            }
 
                            if (caminhoLivre) {
                                xeque = true;
                            }
                        }
                    }
                }
            }
        }
 
        return xeque;
    }
 
 
    private boolean movimentoDeixaReiEmXeque(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino, String cor) {
        Peca pecaMovida    = tabuleiro[linhaOrigem][colunaOrigem].getPeca();
        Peca pecaCapturada = tabuleiro[linhaDestino][colunaDestino].getPeca();
 
        tabuleiro[linhaDestino][colunaDestino].setPeca(pecaMovida);
        tabuleiro[linhaOrigem][colunaOrigem].removePeca();
        pecaMovida.setLinha(linhaDestino);
        pecaMovida.setColuna(colunaDestino);
 
        boolean emXeque = reiEmXeque(cor);
 
        tabuleiro[linhaOrigem][colunaOrigem].setPeca(pecaMovida);
        tabuleiro[linhaDestino][colunaDestino].setPeca(pecaCapturada);
        pecaMovida.setLinha(linhaOrigem);
        pecaMovida.setColuna(colunaOrigem);
 
        return emXeque;
    }
 
 
    public boolean xequeMate(String cor) {
        boolean temMovimentoLegal = false;
 
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Peca peca = tabuleiro[i][j].getPeca();
 
                if (peca != null && peca.getCor().equals(cor)) {
                    for (int di = 0; di < 8; di++) {
                        for (int dj = 0; dj < 8; dj++) {
                            Peca pecaDestino = tabuleiro[di][dj].getPeca();
 
                            boolean movimentoGeralValido = peca.movimentoValido(di, dj)
                                && (pecaDestino == null || !pecaDestino.getCor().equals(cor));
 
                            boolean peaoValido = true;
                            if (peca.getNome().equals("Peão")) {
                                boolean diagonal = dj != j;
                                if (diagonal && pecaDestino == null) {
                                    peaoValido = false;
                                }
                                if (!diagonal && pecaDestino != null) {
                                    peaoValido = false;
                                }
                            }
 
                            if (movimentoGeralValido && peaoValido) {

                                boolean caminhoLivre = true;
                                if (!peca.getNome().equals("Cavalo")) {
                                    int direcaoLinha  = (di > i) ? 1 : (di < i) ? -1 : 0;
                                    int direcaoColuna = (dj > j) ? 1 : (dj < j) ? -1 : 0;

                                    int linhaAtual  = i + direcaoLinha;
                                    int colunaAtual = j + direcaoColuna;

                                    while ((linhaAtual != di || colunaAtual != dj) && caminhoLivre) {
                                        if (tabuleiro[linhaAtual][colunaAtual].getPeca() != null) {
                                            caminhoLivre = false;
                                        }
                                        linhaAtual  += direcaoLinha;
                                        colunaAtual += direcaoColuna;
                                    }
                                }

                                if (caminhoLivre && !movimentoDeixaReiEmXeque(i, j, di, dj, cor)) {
                                    temMovimentoLegal = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return !temMovimentoLegal;
    }

    public boolean mover(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino, String turno) {
        Peca peca = tabuleiro[linhaOrigem][colunaOrigem].getPeca();
        Peca destino = tabuleiro[linhaDestino][colunaDestino].getPeca();

        

        if (peca == null){
            return false;
        }
        if (!peca.getCor().equals(turno)){ 
            return false;
        }
        if (!peca.movimentoValido(linhaDestino, colunaDestino)){ 
            return false; 
        }
        if (destino != null && destino.getCor().equals(turno)){ 
            return false;
        }


        if (peca.getNome().equals("Peão")) {
            boolean diagonal = colunaDestino != colunaOrigem;

            if (diagonal && destino == null) {
                return false;
            }
            if (!diagonal && destino != null) {
                return false;
            }
        }


        if (!peca.getNome().equals("Cavalo")) {
            int direcaoLinha  = (linhaDestino  > linhaOrigem)  ? 1 : (linhaDestino  < linhaOrigem)  ? -1 : 0;
            int direcaoColuna = (colunaDestino > colunaOrigem) ? 1 : (colunaDestino < colunaOrigem) ? -1 : 0;

            int linhaAtual  = linhaOrigem  + direcaoLinha;
            int colunaAtual = colunaOrigem + direcaoColuna;

            while (linhaAtual != linhaDestino || colunaAtual != colunaDestino){

                if (tabuleiro[linhaAtual][colunaAtual].getPeca() != null){
                    return false;
                } 
                
                linhaAtual  += direcaoLinha;
                colunaAtual += direcaoColuna;
            }
        }

        if (movimentoDeixaReiEmXeque(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino, turno)){
            return false;
        }


        tabuleiro[linhaDestino][colunaDestino].setPeca(peca);
        tabuleiro[linhaOrigem][colunaOrigem].removePeca();
        peca.setLinha(linhaDestino);
        peca.setColuna(colunaDestino);
        peca.setJogadas(peca.getJogadas() + 1);



        boolean promocaoBranco = peca.getNome().equals("Peão") && peca.getCor().equals("Branco") && linhaDestino == 0;
        boolean promocaoPreto  = peca.getNome().equals("Peão") && peca.getCor().equals("Preto")  && linhaDestino == 7;
        if (promocaoBranco || promocaoPreto) {
            tabuleiro[linhaDestino][colunaDestino].setPeca(
                escolherPromocao(peca.getCor(), linhaDestino, colunaDestino)
            );
        }


        return true;
 }
    


    public void exibir() {
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + "  ");

            for (int j = 0; j < 8; j++) {
                Peca peca = tabuleiro[i][j].getPeca();
                if (peca == null) {
                    System.out.print("[    ]");
                } else {
                    System.out.print("[ " + peca.getCor().charAt(0)  + peca.getSimbolo() + " ]");
                }
            }
            System.out.println();
        }
        System.out.println("     a     b     c     d     e     f     g     h");
    }
}


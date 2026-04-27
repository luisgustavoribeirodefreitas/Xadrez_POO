import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;
    private String turno;
    private Scanner scanner;

    public Jogo() {
        this.tabuleiro = new Tabuleiro();
        this.turno = "Branco";
        this.scanner = new Scanner(System.in);
    }

     public void iniciar() {
        boolean jogando = true;
 
        while (jogando) {
            tabuleiro.exibir();
            System.out.println("\nVez do " + turno);
 
            int[] origem  = lerCoordenada("Qual peça mover? ");
            int[] destino = lerCoordenada("Para onde mover? ");
 
            if (tabuleiro.mover(origem[0], origem[1], destino[0], destino[1], turno)) {
                turno = turno.equals("Branco") ? "Preto" : "Branco";
 
                if (tabuleiro.xequeMate(turno)) {
                    tabuleiro.exibir();
                    if (!tabuleiro.reiEmXeque(turno)) {
                        System.out.println("Afogamento! Empate!");
                    } else {
                        String vencedor = turno.equals("Branco") ? "Preto" : "Branco";
                        System.out.println("Xeque-mate! " + vencedor + " venceu!");
                    }
                    jogando = false;
                }
 
                if (jogando && tabuleiro.reiEmXeque(turno)) {
                    System.out.println("Xeque!");
                }
            } else {
                System.out.println("Movimento inválido! Tente novamente.");
            }
        }
    }
 
    private int[] lerCoordenada(String mensagem) {
        int[] resultado = null;
 
        while (resultado == null) {
            System.out.print(mensagem);
            String entrada = scanner.next();
 
            if (entrada.length() != 2) {
                System.out.println("Entrada inválida! Digite uma letra e um número. Ex: a2");
            } else {
                int coluna = entrada.charAt(0) - 'a';
                int linha  = 8 - Character.getNumericValue(entrada.charAt(1));
 
                if (linha < 0 || linha > 7 || coluna < 0 || coluna > 7) {
                    System.out.println("Coordenada fora do tabuleiro! Use a-h e 1-8. Ex: a2");
                } else {
                    resultado = new int[]{linha, coluna};
                }
            }
        }
 
        return resultado;
    }
}

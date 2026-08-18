import java.lang.*;
import java.util.Scanner;

public class jogovelha {

public static boolean recebimento(Jogo[][] velha, int l, int c, Jogo patual ){
    if ( velha [l][c] == Jogo.VAZIO ){
        velha [l][c] = patual;
        return true;
    }else{
        System.out.println("\nPosição já ocupada!");
        return false;
    }
}
public static boolean regras (Jogo[][] velha, Jogo patual, int i, int j, int qregra, final int t){
    for (i = 0; i < t; i++){
        if ( velha [0][i] == patual && velha [1][i] == patual && velha [2][i] == patual){
            System.out.println(patual + " ganhou");
            return true;
        }
    }
    for (j = 0; j < t; j++){
        if ( velha [j][0] == patual && velha [j][1] == patual && velha [j][2] == patual){
            System.out.println(patual + " ganhou");
            return true;
        }
    }
    if ( velha [0][0] == patual && velha [1][1] == patual && velha [2][2] == patual || velha [0][2] == patual && velha [1][1] == patual && velha [2][0] == patual){
            System.out.println(patual + " ganhou");
            return true;
    }
    return  false;
}

       public enum Jogo {
            VAZIO,
            X,
            O
        }
       
    public static final int t = 3;

    public static void main(String[] args) {
       
        Jogo[][] velha = new Jogo[t][t];
        int i, j = 0, l, c, qregra = 0, fim = 0;
        Jogo jogador1 = Jogo.VAZIO, jogador2 = Jogo.VAZIO, patual;
        boolean valida = false, cabou = false;

        Scanner scanner = new Scanner(System.in);
        
        
        
       boolean opcaoinvalida = false;
       System.out.println ("\nJogo da Velha\n");
        System.out.println("         0         1         2");
        for (i = 0; i < t; i++){
            System.out.print(i + "   |  ");
            for (j = 0; j < t; j++){
                if (velha [i][j] == Jogo.VAZIO){
                    System.out.print("   |  ");
                }else{
                    System.out.print( velha [i][j] + "   |  ");
                }
            }
            System.out.println();
        }

       
     do{
       System.out.print ("\nJogador 1 escolha sua peça 'X' ou 'O': ");
       String peca = scanner.next().toUpperCase();
       
       switch (peca){

        case "X":
        
            jogador1 = Jogo.X;
            jogador2 = Jogo.O;
            break;
        case "O":

            jogador1 = Jogo.O;
            jogador2 = Jogo.X;
            break;
        default:
            System.out.println("\nOpção Invalida");
            break;
       }
     } while(opcaoinvalida);

     for (i = 0; i < t; i++) {
         for (j = 0; j < t; j++){
            velha [i][j] = Jogo.VAZIO;
         }
     }
     
         patual = jogador1;
         

   while (cabou == false){
        System.out.print ("\nEm qual linha deseja colocar sua peça " + "'" + patual + "': " );
        l = scanner.nextInt();
        System.out.print ("\nEm qual coluna deseja colocar sua peça: ");
        c = scanner.nextInt();

        valida = recebimento (velha, l, c, patual);

        if (valida == true){
            fim++;

        System.out.println ("\nJogo da Velha\n");
        System.out.println("       0     1     2");
        for (i = 0; i < t; i++){
            System.out.print(i + "   |  ");
            for (j = 0; j < t; j++){
                if (velha [i][j] == Jogo.VAZIO){
                    System.out.print("   |  ");
                }else{
                    System.out.print( velha [i][j] + "   |  ");
                }
            }
            System.out.println();
        }

        if (regras(velha, patual, i, j, qregra, t) == true){
            cabou = true;
        }
        else if (fim == 9){
            System.out.println("Deu velha!!");
        }else {if (patual == jogador1){
                    patual = jogador2;
                }else{
                    patual = jogador1;
                }
        }
        
        }
    }
    }
}


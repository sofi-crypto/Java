package exercicio9;

import java.util.Scanner;

public class arranjo {
    public static final int N = 3;
    public static final int M = 3;
    public static final int E = 4;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        char[][][] MAPA = new char[N][M][E];
        int i, j, k;


        String[] Perg = {
            "\nÉ propriedade (P) ou arrendamento (A)?\n",
            "\nExiste energia elétrica nesta propriedade? (S - Sim) (N - Não) \n",
            "\nÉ propriedade de cultura (C) ou pecuária (P)? \n",
            "\nUtiliza mecanização? (S - Sim) (N - Não) \n",
            
        };
        
        for(i = 0; i < N; i++){
            for(j = 0; j < M; j++){
                System.out.println( "Bairro " + i + " | " + "Propriedade " + j);
                for(k = 0; k < E; k++){
                    System.out.print(Perg[k]);
                    MAPA[i][j][k] = scanner.next().charAt(0);
                }
            }
        }
        System.out.println("\n\nResultado");

        for (i = 0; i < N; i++){
         System.out.println("Bairro" + i + ":");
         for(j =0; j < M; j++){
            if (MAPA[i][j][0]  != 'A'){
                System.out.println(j + " é do tipo Propriedade (não arrendamento).");
            }else{
                System.out.println(j + " é do tipo arrendamento (não Propriedade).");
            }
            if (MAPA[i][j][1] == 'S') {
                    System.out.println(" A Propriedade " + j + " possui energia elétrica.");
                }else{
                    System.out.println(" A Propriedade " + j + " não possui energia elétrica.");
                }
            if (MAPA[i][j][2] == 'P') {
                    System.out.println( j + " é propriedade Pecuária (Não propriedade de cultura).");
                }else{
                    System.out.println( j + " é propriedade propriedade de cultura (Não propriedade Pecuária).");
                }
            if (MAPA[i][j][3] == 'S') {
                    System.out.println( j + " utiliza de mecanização");
                }else{
                    System.out.println( j + " não utiliza de mecanização");
                }
         }

        }
    }
}

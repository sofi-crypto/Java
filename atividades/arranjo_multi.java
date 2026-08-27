package atividades;

import java.util.Scanner;

public class arranjo_multi {
    //Exercício Salário

    public static final int A = 2;
    public static final int F = 2;
    public static final int M = 2;

    public static float b (float S, int I, int J, int P, float[][][] CBSFunc, final int A, final int M){
        S = 0;
        for(I = 0; I < A; I++){
            for(J = 0; J < M; J++){
                S += CBSFunc [I][P][J];
            }
            
        }
        return S;
    }

    public static c c(float S, int I, int J, int P, float[][][] CBSFunc, final int F, final int M, float[] STot, float Md){ 
        for(I = 0; I < F; I++){
            S =0;
            for(J = 0; J < M; J++){
               S += CBSFunc [P][I][J];
               STot[I] = S;
            }
        }
        Md = S / F;
        return new c(STot, F, Md);
    }

    public static d d(int I, int J, float[][][] CBSFunc, final int F, final int M, int K, final int A, int QTD, int[] QTDA, float Mont, int Menor, float Montg){
        for(I = 0; I < A; I++){
            QTD = 0;
            Mont = 0;
            for(J = 0; J < F; J++){
                for(K = 0; K < M; K++){
                    if(CBSFunc [I][J][K]> 0){
                       QTD ++;
                        Mont += CBSFunc[I][J][K];
                    }
                }
                
            }
            QTDA[I] = QTD;
            if(Mont < Montg){
                Montg = Mont;
                Menor = I;
            }
    }

    return new d(A, Menor, QTDA);
}

   
    

    

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        float[][][] CBSFunc = new float[A][F][M];

        int I = 0, J = 0, K = 0, P = 0, QTD = 0, Menor = 0;

        float S = 0, Mont = 0, Montg = Float.MAX_VALUE;

        float[] STot =  new float[F];

        int[] QTDA = new int[A];

        float Md = 0;

        char Resp;

            for(I = 0; I < A; I++){
                for(J = 0; J < F; J++){
                    for(K = 0; K < M; K++){
                        System.out.print("\nDigite o salário do funcionário " + (J+1) + ", no mês " + (K+1) + ", no ano " + (I+2018) + ": ");
                        CBSFunc[I][J][K] = scanner.nextFloat();
                    }
                }
        }
        c resultado = c(S, I, J, P, CBSFunc, F, M, STot, Md);
        d resultado2 = d(I, J, CBSFunc, F, M, K, A, QTD, QTDA, Mont, Menor, Montg);

        S = 0;
        System.out.print("\nDeseja consultar o salário de algum funcionário (S - Sim) (N - Não): \n");
        Resp = scanner.next().charAt(0);
        
        switch(Resp){
            case 'S':
            case 's':
                System.out.print("\nDeseja consultar o salário de qual funcionário: \n");
                P = scanner.nextInt() - 1;

                System.out.println("\nO salário total dos 5 anos do funcionário " + (P+1) + " foi " + b(S, I, J, P, CBSFunc, A, M));
                
                System.out.print("\nDeseja consultar o salário dos funcionários em determinado ano (S - Sim) (N - Não): \n");
                Resp = scanner.next().charAt(0);

                break;
            case 'N':
            case 'n':
                System.out.print("\nDeseja consultar o salário dos funcionários em determinado ano (S - Sim) (N - Não): \n");
                Resp = scanner.next().charAt(0);
                break;
            default:
                System.out.print("\nOpção Invalida\n");
                break;
        }

        switch(Resp){
            case 'S':
            case 's':
                System.out.print("\nDigite o ano desejado (ex: 2018 a 2022): \n");
                I = scanner.nextInt() - 2018;

                System.out.println("\nA quantidade de salário dos funcionários no ano " + (I+2018) + " foiram " + resultado2.QTDA[I]);
                System.out.println("\nO ano com menor montante de salário dos funcionários foi " + (resultado2.Menor + 2018) );
                break;
            case 'N':
            case 'n':
                System.out.print("\nObrigada por utilizar!");
                break;
            default:
                System.out.print("\nOpção Invalida\n");
                break;
        }
    }
    }

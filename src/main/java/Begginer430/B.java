package Begginer430;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] Ngrid = new int[N][N];
            int[][] Mgrid = new int [M][M];
            int[] tempGrid = new int[M];

            int count = 0;

            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    Ngrid[i][j] = sc.nextInt();
                }
            }

            for (int i=0; i<M; i++) {
                for (int j=0; j<M; j++) {
                    
                }
            }


        }
    }
}

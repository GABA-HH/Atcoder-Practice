package Begginer433;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
          int N = sc.nextInt();
          int[][] A = new int[N][2];
          int nearNum = -1;

            for (int i=0; i<N; i++) {
                A[i][0] = sc.nextInt();
            }

            for (int i=0; i<N; i++) {
                if (i==0) {
                    A[i][1] = -1;
                    continue;
                }

                for (int k=i-1; 0<=k; k--) {
                    if (A[i][0]<A[k][0]) {
                        A[i][1] = k+1;
                        break;
                    } else {
                        A[i][1] = -1;
                    }
                }
            }

            for (int i=0; i<N; i++) {
                System.out.println(A[i][1]);
            }

        } 
    }
}

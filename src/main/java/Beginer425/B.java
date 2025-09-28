package Beginer425;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            
            int n = sc.nextInt();
            int[] A = new int[n];

            // 存在するPiの確認用
            int[] P = new int[n];

            for (int i=0; i<n; i++) {
                A[i] = sc.nextInt();
            }

            for (int i=0; i<n ; i++) {
                if (-1!=A[i]) {
                    P[i]++;
                }
            }

            for (int i=0; i<n; i++) {
                
            }

            System.out.println();

        }
    }
}

package Begginer432;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int X = sc.nextInt();
            int Y = sc.nextInt();
            // [飴の総数、配られた大きい飴の数、配られた飴の総重量]を格納するための配列
            int[][] A = new int[N][3];
            

            for (int i =0;i<N;i++) {
                A[i][0] = sc.nextInt();
                A[i][1] = A[i][0];
                A[i][2] = Y*A[i][1];
            }

            for (int i=0; i<N; i++) {
                    System.out.println("["+Arrays.toString(A[i])+"]");
            }
        } 
    }
}

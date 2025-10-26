package Begginer429;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] A = new int[N];
            int sumA = 0;
            int diff = 0;

            boolean canEqual = false;

            for (int i=0;i<N;i++) {
                A[i] = sc.nextInt();
                sumA += A[i];
            }

            diff = sumA - M;

            for (int i=0;i<N;i++) {
                if (diff==A[i]) {
                    canEqual = true;
                    break;
                }
                
            }

            if (canEqual) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } 
    }
}

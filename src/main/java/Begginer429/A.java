package Begginer429;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            for (int i=0;i<N;i++) {
                if (i<M) {
                    System.out.println("OK");
                } else {
                    System.out.println("Too Many Requests");
                }
            }

        } 
    }
}

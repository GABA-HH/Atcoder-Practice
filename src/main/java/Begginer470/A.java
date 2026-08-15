package Begginer470;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int N = sc.nextInt();

            for (int i = 1; i <= N; i++) {
                if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else {
                    System.out.println(i);
                }
            }
        }
    }
}

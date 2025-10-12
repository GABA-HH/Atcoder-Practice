package Begginer425;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            
            int n = sc.nextInt();
            int sum = 0;

            for (int i=1; i<=n; i++) {
                sum = sum + (int)Math.pow(-1, i)*(int)Math.pow(i, 3);
            }

            System.out.println(sum);

        }
    }
}

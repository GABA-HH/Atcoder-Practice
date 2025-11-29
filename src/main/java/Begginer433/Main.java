package Begginer433;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int S = sc.nextInt();
            int[] digits = String.valueOf(Math.abs(S))
                     .chars()
                     .map(c -> c - '0')
                     .toArray();

            int count = 0;
            int firstNum = 0;
            int nextNum = 0;

            for (int i=0; i<digits.length; i++) {
                for (int k=i+1; k<digits.length; k++) {

                }
            }

            // System.out.println(Arrays.toString(digits));
        } 
    }
}

package Begginer427;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int sum = 1;

            int thousands = 0;
            int hundreds = 0;
            int tens = 0;
            int ones = 0; 


            for (int i=1; i<n; i++) {
                ones= sum%10;
                tens= (sum/10)%10;
                hundreds= (sum/100)%10;
                thousands= sum/1000;
                sum += (ones+tens+hundreds+thousands);
            }

            System.out.println(sum);
        } 
    }
}

package Begginer427;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String S = sc.next();

            String Sright;
            String Sleft;

            Sright = S.substring(0,(S.length()+1)/2-1);
            // System.out.println("S："+S);
            // System.out.println("Sright："+Sright);
            Sleft = S.substring((S.length()+1)/2);
            // System.out.println("S："+S);
            // System.out.println("Sright："+Sright);
            // System.out.println("Sleft："+Sleft);

            System.out.println(Sright+Sleft);
        } 
    }
}

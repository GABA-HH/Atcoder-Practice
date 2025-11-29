package Begginer433;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
          int X = sc.nextInt();
          int Y = sc.nextInt();
          int Z = sc.nextInt();
          
          boolean isDoubled = false;


        //   for (int i=0; i<; i=i+Y) {
            if (X==Y*Z) {
                isDoubled = true;
                // break;
            } else if (X<Y || X<Y*Z) {
                isDoubled = false;
                // break;
            } else {
                isDoubled = true;
            }
        //   }

          if (isDoubled) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
          }

        } 
    }
}

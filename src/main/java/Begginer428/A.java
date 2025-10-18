package Begginer428;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            
            int S = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            int X = sc.nextInt();

            int num = 0;
            int lastTime = 0;
            int lastTimeA = 0;

            num = X/(A+B);
            lastTime = X - num*(A+B);
            

            if (lastTime<=A) {
                lastTimeA = lastTime;
            } else if (A<lastTime && lastTime<A+B) {
                num++;
            }
            

            System.out.println(num*A*S+lastTimeA*S);
        } 
    }
}

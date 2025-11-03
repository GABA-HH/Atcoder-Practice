package Begginer430;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            
            int N = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            String S = sc.next();

            int l = 0;
            int r = 0;
            int countA = 0;
            int countB = 0;
            int count = 0;
            String tempString = "";

            a:for (l=0; l<=N; l++) {
                b:for (r=l+A; r<=N; r++) {
                    if (!S.contains("a")) {
                        count = 0;
                        break a;
                    }

                    tempString = S.substring(l,r);
                    countA = tempString.length() - tempString.replace("a", "").length();
                    countB = tempString.length() - tempString.replace("b", "").length();

                    if (countA>=A && countB < B) {
                        count++;
                    }
                }
            }
            
            System.out.println(count);

        }
    }
}
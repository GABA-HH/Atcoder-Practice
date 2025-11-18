package Begginer432;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[] ABC = new int[3];
            int hundred = 0;
            int ten = 0;
            int one = 0;
            int currentnum = 0;

            for (int i=0;i<3;i++) {
                ABC[i] = sc.nextInt();
            }

            if (ABC[0]>=ABC[1]) {
                if (ABC[0]>=ABC[2]) {
                    hundred = ABC[0];
                    if (ABC[1]>=ABC[2]) {
                        ten=ABC[1];
                        one=ABC[2];
                    } else {
                        ten=ABC[2];
                        one=ABC[1];
                    }
                } else {
                    hundred = ABC[2];
                    ten = ABC[0];
                    one = ABC[1];
                }
                
            } else if (ABC[0]<ABC[1]) {
                if (ABC[1]>=ABC[2]) {
                    hundred = ABC[1];
                    if (ABC[0]>=ABC[2]) {
                        ten=ABC[0];
                        one=ABC[2];
                    } else {
                        ten=ABC[2];
                        one=ABC[0];
                    }
                } else {
                    hundred = ABC[2];
                    ten = ABC[1];
                    one = ABC[0];
                }
                
            } {
                
            }


            System.out.println(hundred*100 + ten*10 + one);
        } 
    }
}

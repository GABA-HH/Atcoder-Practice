package Begginer432;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String X = sc.next();
            String[] arraysX = new String[X.length()];

            arraysX = X.split("");
            Arrays.sort(arraysX);

            int firstNumIndex = 0;
            int zeroCount = 0;
            String minNum = "";
            for (int i=0;minNum.length()==0;i++) {
                if (!"0".equals(arraysX[i])) {
                    minNum=arraysX[i] + "0".repeat(zeroCount);
                    firstNumIndex = i;
                } else {
                    zeroCount++;
                }
            }

            for (int i=firstNumIndex+1;i<X.length();i++) {
                minNum += arraysX[i];
            }

            System.out.println(minNum);
        } 
    }
}

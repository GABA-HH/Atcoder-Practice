package Begginer428;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class C {

    private static final String deleteString = "()";
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            
            int Q = sc.nextInt();
            int queryNum = 0;
            String queryString = "";
            StringBuilder S = new StringBuilder();

            for (int i=0;i<Q;i++) {
                queryNum=sc.nextInt();

                if (1==queryNum) {
                    S.append(sc.next());
                    // System.out.println(i+"番目のqueryの結果："+S);
                } else if (2==queryNum) {
                    S.delete(S.length()-1, S.length());
                    // System.out.println(i+"番目のqueryの結果："+S);
                }

                checkGoodString(S);
            }

        } 
    }

    private static void checkGoodString(StringBuilder S) {

        StringBuilder sb = new StringBuilder(S);

        while (1<sb.length()) {
            if (-1 != sb.indexOf(deleteString)) {
                sb.delete(sb.indexOf(deleteString), sb.indexOf(deleteString)+2);
                // System.out.println(sb);
            } else {
                break;
            }
        }

        if (0==sb.length()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

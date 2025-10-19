package Begginer428;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            
            int N = sc.nextInt();
            int K = sc.nextInt();
            String S = sc.next();
            String t = "";
            int startIndex = 0;
            int count = 0;
            int maxNum = 0;

            List<String> maxStringList = new ArrayList<>();
            Map KStringMap = new HashMap<>();

            for (int i=0; i<N-K+1;i++) {
                t = S.substring(i,i+K);
                if (!KStringMap.containsKey(t)) {
                    count = 1;
                    startIndex = i+1;

                    while ((startIndex = S.indexOf(t, startIndex)) != -1 && startIndex+t.length() <= S.length()) {
                        count++;
                         startIndex ++;
                    }

                    KStringMap.put(t, count);
                    if (maxNum < count) {
                        maxStringList.clear();
                        maxStringList.add(t);
                        maxNum = count;
                    } else if (maxNum == count) {
                        maxStringList.add(t);
                        maxNum = count;
                    }
                }
            }

            maxStringList.sort(null);

            System.out.println(maxNum);
            System.out.println(String.join(" ", maxStringList));
        } 
    }
}

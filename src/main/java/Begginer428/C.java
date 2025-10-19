package Begginer428;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class C {
    private static int balance = 0;
    private static int minPrefix = 0;
    private static int prevBalance = 0;
    private static int prevMinPrefix = 0;

    private static final Deque<Integer> balanceStack = new ArrayDeque<>();
    private static final Deque<Integer> minPrefixStack = new ArrayDeque<>();
    
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            
            int Q = sc.nextInt();
            StringBuilder S = new StringBuilder();

            for (int i = 0; i < Q; i++) {
                int queryNum = sc.nextInt();

                if (1 == queryNum) {
                    String addChar = sc.next();
                    S.append(addChar);
                    checkGoodString(S, addChar);
                } else if (2 == queryNum) {
                    if (S.length() > 0) {
                        S.delete(S.length() - 1, S.length());
                    }
                    checkGoodString(S, "");
                }
            }
        }
    }

    private static void checkGoodString(StringBuilder S, String adString) {

        if ("(".equals(adString) || ")".equals(adString)) {
            prevBalance = balance;
            prevMinPrefix = minPrefix;
            balanceStack.push(prevBalance);
            minPrefixStack.push(prevMinPrefix);

            if ("(".equals(adString)) {
                balance = prevBalance + 1;
            } else {
                balance = prevBalance - 1;
            }
            minPrefix = Math.min(prevMinPrefix, balance);
        } else {
            if (!balanceStack.isEmpty() && !minPrefixStack.isEmpty()) {
                balance = balanceStack.pop();
                minPrefix = minPrefixStack.pop();
            } else {
                balance = 0;
                minPrefix = 0;
            }
        }

        if (balance == 0 && minPrefix >= 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

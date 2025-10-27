package Begginer429;

import java.util.HashMap;
import java.util.Scanner;

// TLEになる問題点
// A.keyset（）を二重ループで実行してしまうと、組み合わせ数が多い場合にTLEになってしまうので、１ループだけ実行する方向に修正


public class C {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();

            HashMap<Integer, Integer> A = new HashMap<>();

            long sum = 0;


            for (int i=0;i<N;i++) {

                int Ai = sc.nextInt();

                if (A.containsKey(Ai)) {
                    A.put(Ai, A.get(Ai)+1);
                } else {
                    A.put(Ai, 1);
                }

            }


            for (long freq: A.values()) {

                if (freq < 2) {
                    continue;
                }
                // ２個の数字用の組み合わせ数
                long chooseTwo = freq * (freq-1) / 2;
                // この２個の数字の組み合わせの全体の組み合わせの数
                sum += chooseTwo * (N - freq);

            }


            System.out.println(sum);

        } 
    }
}

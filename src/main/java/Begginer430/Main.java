package Begginer430;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            String S = sc.next();

            int[] prefixA = new int[N + 1]; // prefixA[i] = 先頭から i 文字までの 'a' の個数
            int[] prefixB = new int[N + 1]; // prefixB[i] = 先頭から i 文字までの 'b' の個数
            ArrayList<Integer> aPos = new ArrayList<>(); // k 番目の 'a' の位置 (1-index) を保持
            ArrayList<Integer> bPos = new ArrayList<>(); // k 番目の 'b' の位置 (1-index) を保持
            aPos.add(0); // aPos.get(k) で k 番目の 'a' の位置 (1-index) をそのまま取得するための番兵
            bPos.add(0); // 'b' についても同様に番兵を入れておく

            for (int i = 0; i < N; i++) {
                char c = S.charAt(i);
                prefixA[i + 1] = prefixA[i] + (c == 'a' ? 1 : 0); // index i までの 'a' の累積個数
                prefixB[i + 1] = prefixB[i] + (c == 'b' ? 1 : 0);
                if (c == 'a') {
                    aPos.add(i + 1);
                } else {
                    bPos.add(i + 1);
                }
            }

            int totalA = prefixA[N];
            int totalB = prefixB[N];
            long answer = 0; // 区間数は int を超える可能性があるので long

            for (int l = 1; l <= N; l++) {
                int targetAIndex = prefixA[l - 1] + A; // 左端 l から見て A 個目の 'a' の通算順位
                if (targetAIndex > totalA) {
                    continue; // この l では A 個の 'a' を満たせないので飛ばす
                }
                int posA = aPos.get(targetAIndex); // A 個目の 'a' が出現するインデックス

                int upper;
                int targetBIndex = prefixB[l - 1] + B; // 左端 l から B 個目の 'b' の通算順位
                if (targetBIndex > totalB) {
                    upper = N; // 末尾まで取っても 'b' が B 個未満なら末尾まで OK
                } else {
                    int posB = bPos.get(targetBIndex); // B 個目の 'b' が出現するインデックス
                    upper = posB - 1; // B 個目の 'b' は含められないのでその直前まで
                }

                if (posA > upper) {
                    continue;
                }
                answer += (long) (upper - posA + 1);
            }

            System.out.println(answer);
        }
    }
}

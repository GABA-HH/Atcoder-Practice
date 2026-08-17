package Begginer470;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int Q = sc.nextInt();

            int[] A = new int[N];

            int queryType = 0;
            int query1 = 1;
            int query2 = 2;

            for (int i = 0; i < Q; i++) {
                queryType = sc.nextInt();

                if (query1 == queryType) {
                    query1(A, sc.nextInt() - 1);
                } else if (query2 == queryType) {
                    query2(A, i - 1);
                }
            }

            System.out.println(Arrays.toString(A));
        }
    }

    private static int[] query1(int[] array, int x) {

        array[x]++;
        return array;
    }

    private static int[] query2(int[] array, int i) {

        if (1 <= array[i]) {
            array[i]--;
        }

        return array;
    }
}
package Begginer470;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int maxCount = 0;
            int[] colorCountArray = new int[N];

            for (int i = 0; i < N; i++) {
                int colorValue = sc.nextInt() - 1;

                colorCountArray[colorValue]++;
            }

            for (int i = 0; i < colorCountArray.length; i++) {
                if (maxCount <= colorCountArray[i]) {
                    maxCount = colorCountArray[i];
                }
            }

            System.out.println(colorCountArray.length - maxCount);
        }
    }
}

package Begginer430;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[] arrays = new int[4];

            for (int i = 0; i < 4; i++) {
                arrays[i] = sc.nextInt();
            }

            if (arrays[0] <= arrays[2] && arrays[1] > arrays[3]) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }
}

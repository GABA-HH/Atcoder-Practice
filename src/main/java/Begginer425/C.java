package Begginer425;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            
            int n = sc.nextInt();
            int Q = sc.nextInt();

            long[] A = new long[n];
            long[] B = new long[2*n];
            long[] P = new long[2*n+1];

            int query = 0;
            int c=0;
            int l=0;
            int r=0;
            long sum = 0;
            int startIndex = 0;
            int sumStartIndex =0;
            int sumEndIndex =0;

            for (int i=0; i<n; i++) {
                A[i] = sc.nextLong();
            }

            B = A.clone();
            System.arraycopy(A, 0, B, n-1, n);
            
            System.out.println(Arrays.toString(A));
            System.out.println(Arrays.toString(B));

            long[] cumulativeB = new long[B.length];
            long runningSum = 0;
            for (int i = 0; i < B.length; i++) {
                runningSum += B[i];
                cumulativeB[i] = runningSum;
            }

            System.out.println(Arrays.toString(cumulativeB));
            
            // for (int i=0; i<Q; i++) {
            //     query = sc.nextInt();
            //     if (1==query) {
            //         c=sc.nextInt();
            //         startIndex = (startIndex+c)%n;
                    
            //     } else if (2==query) {
            //         sum=0;
            //         l=sc.nextInt();
            //         r=sc.nextInt();

            //          sumStartIndex=(startIndex+l-1)%n;
            //          sumEndIndex=(startIndex+r-1)%n;
                    
            //         if (sumEndIndex>=sumStartIndex) {
            //             for (int k=sumStartIndex; k<=sumEndIndex; k++) {
            //                 sum += A[k];
            //             }
                        
            //         } else {
            //             for (int k=sumStartIndex; k<n; k++) {
            //                 sum += A[k];
            //             }

            //             for (int k=0; k<=sumEndIndex; k++) {
            //                 sum += A[k];
            //             }
            //         }

            //         System.out.println(sum);
            //      }
            // }
            

        }
    }
}

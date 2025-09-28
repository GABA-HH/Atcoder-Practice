package Beginer425;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            
            int n = sc.nextInt();
            int Q = sc.nextInt();

            int[] A = new int[n];
            int query = 0;
            int c=0;
            int l=0;
            int r=0;
            int aStart=0;
            int sum = 0;

            for (int i=0; i<n; i++) {
                A[i] = sc.nextInt();
            }

            for (int i=0; i<Q; i++) {
                query = sc.nextInt();
                if (1==query) {
                    c=sc.nextInt();
                    for (int k=0; k<c; k++) {
                        aStart=A[0];
                        
                        for (int j=0; j<n-1; j++) {
                            if (j==n-1) {
                                break;
                            }
                            A[j]=A[j+1];
                        }
                        A[n-1]=aStart;
                    }

                    
                } else if (2==query) {
                    sum=0;
                    l=sc.nextInt();
                    r=sc.nextInt();

                    for (int k=l-1; k<r; k++) {
                        sum += A[k];
                    }

                    System.out.println(sum);
                 }
            }

            // System.out.println();

        }
    }
}

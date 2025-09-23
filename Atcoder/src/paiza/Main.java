package paiza;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int R = sc.nextInt()-1;
		String[] L = new String[N+1];
		
		for (int i=0;i<N;i++) {
			if (0==i) {
				L[i]="1";
				continue;
			}

			L[i] = sc.next();
		}


		// int count = 0;
		// int leftLeastOpendDistance = 0;
		// int rightLeastOpendDistance = 0;
		int leftLeastOpendPosition = 0;
		int rightLeastOpendPosition = 0;


		// 高橋の左側にある開いた扉のうち、最も遠い扉の位置の特定
		for(int i=0;i<=R;i++) {
			leftLeastOpendPosition=i;
			if ("0".equals(L[i])) {
				// leftLeastOpendDistance=R-(i+1);
				break;
			} 
		}
		
		// 高橋の右側にある開いた扉のうち、最も遠い扉の位置の特定
		for(int i=N-1;i>R;i--) {
			rightLeastOpendPosition=i;
			if ("0".equals(L[i])) {
				// rightLeastOpendDistance=(i+1)-R;
				break;
			} 
		}

		int countOne = 0;
		int countZero = 0;


		for(int i=leftLeastOpendPosition;i<=R;i++) {
			
			if ("1".equals(L[i])) {
				countOne++;
			} else {
				countZero++;
			}
		}

		for(int i=rightLeastOpendPosition;i>R;i--) {
			
			if ("1".equals(L[i])) {
				countOne++;
			} else {
				countZero++;
			}
		}

		System.out.println(countOne*2 + countZero*1);
		// System.out.println(leftLeastOpendPosition);
		// System.out.println(rightLeastOpendPosition);
		// System.out.println("高橋の左側にある開いた扉のうち、最も遠い扉の位置"+leftLeastOpendDistance);
		// System.out.println("高橋の右側にある開いた扉のうち、最も遠い扉の位置"+rightLeastOpendDistance);

	}


}

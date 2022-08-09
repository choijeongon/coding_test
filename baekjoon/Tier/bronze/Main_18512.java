package bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Main_18512 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//뛰는 거리
		int X = sc.nextInt();
		int Y = sc.nextInt();
		
		//시작 위치
		int P_1 = sc.nextInt();
		int P_2 = sc.nextInt();
		
		int[] A_list = new int[100];
		int[] B_list = new int[100];
		
		int answer = -1;
		
		for (int i = 0; i < A_list.length; i++) {
			A_list[i] = P_1 + X * i;
		}
		
		for (int i = 0; i < B_list.length; i++) {
			B_list[i] = P_2 + Y * i;
		}
		
		for (int i = 0; i < A_list.length; i++) {
			for (int j = 0; j < B_list.length; j++) {
				if(A_list[i] == B_list[j]) {
					if(answer == -1) {
						answer = B_list[j];
					} else {
						answer = Math.min(answer, B_list[j]);						
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}

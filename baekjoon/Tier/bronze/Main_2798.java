package bronze;

import java.util.Scanner;

public class Main_2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] list = new int[N];
		
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		
		int sum = 0;
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					int a = list[i];
					int b = list[j];
					int c = list[k];
					
					if(a != b && b != c && a != c) {
						sum = a+b+c;
						if(sum <= M) {
							answer = Math.max(answer, sum);
						}
					}
					
				}
			}
		}
		System.out.println(answer);
	}
}

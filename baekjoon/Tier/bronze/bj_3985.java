package bronze;

import java.util.Arrays;
import java.util.Scanner;

public class bj_3985 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 롤케이크 길이
		int L = sc.nextInt();
		// 방청객의 수
		int N = sc.nextInt();
		
		int[] rollcake = new int[L];
		int[] counter = new int[L];
		
		int expected_person_number = 0;
		int max_person_number = 0;
		
		int max = 0;
		int max_count = 0;
		
		for (int i = 1; i <= N; i++) {
			int P = sc.nextInt();
			int K = sc.nextInt();
			
			// 예상되는 가장 많은 조각을 받을 갯수
			int expected_max_value = K-P;
			
			if(expected_max_value > max) {
				max = expected_max_value;
				expected_person_number = i;
			} 
			
			for(int j = P-1; j < K; j++) {
				if(rollcake[j] == 0) {
					rollcake[j] = i;
				}
			}
		}
		
		for (int i = 0; i < rollcake.length; i++) {
			counter[rollcake[i]]++;
		}
		
		for (int i = 1; i < rollcake.length; i++) {
			if(counter[i] > max_count) {
				max_count = counter[i];
				max_person_number = i;
			}
			
		}
		
		System.out.println(expected_person_number);
		System.out.println(max_person_number);
	}
}

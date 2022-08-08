package d3;

import java.util.Scanner;

public class Solution_9229 {
	static int[] results;
	static int[] snack_list;
	static int max;
	static int M;
	
	static void comb(int count, int start) {
		//기저 조건
		if(count == 2) {
			int sum = 0;
			
			for(int value : results) {
				sum += value;
			}
			
			if(sum <= M) {
				max = Math.max(max, sum);
			}
			
			return;
		}
		
		for (int i = start; i < snack_list.length; i++) {
			results[count] = snack_list[i];
			comb(count+1, i+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			M = sc.nextInt();
			
			snack_list = new int[N];
			
			for (int i = 0; i < snack_list.length; i++) {
				snack_list[i] = sc.nextInt();
			}
			
			//NC2
			results = new int[2];
			
			max = -1;
			
			comb(0,0);
			
			System.out.println("#" + tc +" " + max);
		}
	}
}

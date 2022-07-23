package bronze;

import java.util.Scanner;

public class bj_1592 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] friend_list = new int[N];

		int total = 0;
		int check = 1;
		
		int index = 0;
		
		friend_list[index]	= 1;
		
		while (check < M) {
			
			//공을 넘겨주는 로직 
			//현재 공을 받은 값 짝수이면 
			if(friend_list[index] % 2 != 0) {
				if((index+L) >= N) {
					index = (index+L) - N;
				} else {
					index += L;
				}
			} else {
				if((index-L) < 0) {
					index = N - Math.abs((index-L));
				} else {
					index -= L;
				}
			}
			
			friend_list[index]++;
			total++;
			
			for(int value : friend_list) {
				check = Math.max(check, value);
			}
		}
		
		System.out.println(total);
	}
}

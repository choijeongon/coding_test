package silver;

import java.util.Scanner;

public class Main_2839 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		int cnt = -1;
		
		int MAX = N/5;
		for(int i =MAX; i>=0; i--) {
			int b = N - (i*5);
			if(b %3 == 0) {
				cnt = i + (b/3);
				break;
			}
		}
		
		System.out.println(cnt);
	}
}

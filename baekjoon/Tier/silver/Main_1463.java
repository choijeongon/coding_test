package silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1463 {
	static int X, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		X = sc.nextInt();
		ans = Integer.MAX_VALUE;
		
		dp();
		
		System.out.println(ans);
	}
	
	static void dp() {
		int[] memo = new int[X+1];
		
		for (int i = 2; i <= X; i++) {
			memo[i] = memo[i-1]+1; // 현재 i보다 하나 작은 숫자부터 +1연산 한번 수행하면 지금 숫자 만들어짐
			if(i%3==0) {
				memo[i] = Math.min(memo[i], memo[i/3]+1);
			}
			if(i%2==0) {
				memo[i] = Math.min(memo[i], memo[i/2]+1);
			}
//			System.out.println(i + ":" + Arrays.toString(memo));
		}
		
		ans = memo[X];
	}
}

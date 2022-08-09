package bronze;

import java.util.Scanner;

public class Main_2851 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] number_list = new int[10];
		
		for (int i = 0; i < 10; i++) {
			number_list[i] = sc.nextInt();
		}
		
		int sum = 0;
		
		for (int i = 0; i < 10; i++) {
			int next_sum = 0;
			
			sum += number_list[i];
			if(i != 9) {
				next_sum = sum + number_list[i+1];				
			}

			if(Math.abs((100-sum)) == Math.abs((100-next_sum))){
				sum = next_sum;
				break;
			} else if(Math.abs((100-sum)) < Math.abs((100-next_sum))) {
				break;
			}
		}
		
		System.out.println(sum);
	}
}

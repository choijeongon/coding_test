package silver;

import java.util.Arrays;
import java.util.Scanner;

public class bj_11659 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] number_list = new int[N];
		int[] accumulate_list = new int[N];
		
		for (int i = 0; i < number_list.length; i++) {
			number_list[i] = sc.nextInt();
		}
		int sum = 0;
		
		for (int i = 0; i < number_list.length; i++) {
			sum += number_list[i];
			accumulate_list[i]= sum;
		}
		
//		System.out.println(Arrays.toString(number_list));
//		System.out.println(Arrays.toString(accumulate_list));
		
		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int result=0;
			if(start == 1) {
				result = accumulate_list[end-1];
			} else {
				//index 0부터 시작
				start -= 1;
				end -= 1;
				
				result = accumulate_list[end] - accumulate_list[start-1];
			}
			System.out.println(result);
		}
	}
}

package silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] people_list = new int[N];
		
		int addAllMin = 0;
		
		for (int i = 0; i < people_list.length; i++) {
			people_list[i] = sc.nextInt();
		}
		
		Arrays.sort(people_list);
		
		for (int i = 1; i <= people_list.length; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
				sum += people_list[j];
			}
			
			addAllMin += sum;
		}
		
		System.out.println(addAllMin);
	}
}

package bronze;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class bj_3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] number_list = new int[10];
		int[] namuzi_list = new int[10];
		int[] count_list = new int[42];
		
		int count = 0;
		
//		Arrays.fill(count_list, -1);
		
		for (int i = 0; i < number_list.length; i++) {
			number_list[i] = sc.nextInt();
		}
		
		for (int i = 0; i < namuzi_list.length; i++) {
			namuzi_list[i] = number_list[i] % 42;
		}
		
//		System.out.println(Arrays.toString(namuzi_list));
		
		for(int value : namuzi_list) {
			count_list[value]++;
		}
		
		for(int value : count_list) {
			if(value != 0) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}

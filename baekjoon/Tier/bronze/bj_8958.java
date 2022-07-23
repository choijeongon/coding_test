package bronze;

import java.io.IOException;
import java.util.Scanner;

public class bj_8958 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int[] score_list = new int[T];
		
		for (int i = 0; i < T; i++) {
			String value = sc.next();
			
			int score = 0;
			int count = 0;
			char[] charArr = value.toCharArray();
			
			for (int j = 0; j < charArr.length; j++) {
				if(charArr[j] == 'O') {
					count++;
					score += count;
				} else if(charArr[j] == 'X') {
					count = 0;
				}
			}
			
			score_list[i] = score;
		}
		
		for(int value : score_list) {
			System.out.println(value);
		}
	}
}

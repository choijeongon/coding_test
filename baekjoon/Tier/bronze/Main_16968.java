package bronze;

import java.util.Scanner;

public class Main_16968 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();
		
		int totalCount = 1;
		
		char startLetter = input.charAt(0);
		
		if(startLetter == 'c') {
			totalCount *= 26;
		} else {
			totalCount *= 10;
		}
		
		for (int i = 1; i < input.length(); i++) {
			char currentChar = input.charAt(i);
			char beforeChar = input.charAt(i-1);
			
			if(currentChar == 'c' && beforeChar == 'c') {
				totalCount *= 25;
			} else if(currentChar == 'c' && beforeChar == 'd') {
				totalCount *= 26;
			} else if(currentChar == 'd' && beforeChar == 'd') {
				totalCount *= 9;
			} else if(currentChar == 'd' && beforeChar == 'c') {
				totalCount *= 10;
			}
		}
		
		System.out.println(totalCount);
	}
}
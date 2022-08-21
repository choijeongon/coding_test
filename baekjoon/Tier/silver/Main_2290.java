package silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2290 {
	static char[][] board;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int s = sc.nextInt();
		int n = sc.nextInt();
		
		String numberString = Integer.toString(n);
		
		int height = 2*s+3;
		//가로 길 * 숫자 갯수 + 공백 갯
		int width = (s+2) * numberString.length() + numberString.length();
		
		board = new char[height][width];
		
		board[1][0] = '|';
		board[2][0] = '|';
		board[4][0] = '|';
		board[5][0] = '|';
		
		printBoard();
		
		
	}
	
	static void printBoard() {
		for(char[] list: board) {
			System.out.println(Arrays.toString(list));
		}
	}
}

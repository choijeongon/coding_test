package silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2567 {
	public static void main(String[] args) {
		final int[] dx = {-1, 0, 1, 0};
		final int[] dy = {0, 1, 0, -1};
		
		Scanner sc = new Scanner(System.in);
		
		int[][] board = new int[100][100];
		
		int N = sc.nextInt();
		
		int[][] black_board = new int[N][2];
		
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int[] temp_list = new int[2];
			temp_list[0] = a;
			temp_list[1] = b;
			
			black_board[i] = temp_list;
		}
		
		for(int[] list : black_board) {
			for (int i = 100-list[1]; i > 90-list[1]; i--) {
				for (int j = list[0]-1; j < list[0]+10-1; j++) {
					board[i][j] = 1;
				}
			}
		}
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				//1인 경우에만 검사
				if(board[i][j] == 1) {
					
					for (int k = 0; k < 4; k++) {
						int a = i + dx[k];
						int b = j + dy[k];
						
						if(a >= 0 && b >= 0 && a < 100 && b < 100) {
							if(board[a][b] == 0) {
								count++;
							}
						}
						
						if(a < 0 || a >= 100 || b < 0 || b >= 100) {
							count++;
						}
					}
				}
				
			}
		}
		
		System.out.println(count);
		
//		for(int[] list : board) {
//			System.out.println(Arrays.toString(list));
//		}
	}
}

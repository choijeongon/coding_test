package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_11315 {
	final static String Y = "YES";
	final static String NO = "NO";
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			char[][] board = new char[N][N]; 
			
			for (int i = 0; i < board.length; i++) {
				board[i] = br.readLine().toCharArray();
			}
			
			String result = NO;
			
			loop:
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
//					System.out.println("x: " + i +", y: " + j );
					int lastX = i+4;
					int lastY = j+4;
					
					//가로검사
					//범위를 벗어나지 않을때만 실행
					if(lastY < board.length) {
						int count = 0;
						
						for (int y = j; y <= lastY; y++) {
							if(board[i][y] == 'o') {
								count++;
							}
						}
						
						if(count == 5) {
							result = Y;
							break loop;
						}
					}
					
					//세로 검사
					//범위를 벗어나지 않을때만 실행
					if(lastX < board.length) {
						int count = 0;
						
						for (int x = i; x <= lastX; x++) {
							if(board[x][j] == 'o') {
								count++;
							}
						}
						
						if(count == 5) {
							result = Y;
							break loop;
						}
					}
					
					//오른쪽 아래 대각선 검사
					//범위를 벗어나지 않을때만 실행
					if(lastX < board.length && lastY < board.length) {
//						System.out.println("오른쪽 아래 대각선 검사 실행");
						int count = 0;
						
						for (int index = 0; index < 5; index++) {
							//오른쪽 아래 대각선 검사
							if(board[i+index][j+index] == 'o') {
								count++;
							}
						}
						
						if(count == 5) {
							result = Y;
							break loop;
						}
					}
					
					//왼쪽 아래 대각선 검사
					//범위를 벗어나지 않을때만 실행
					if(lastX < board.length && (j-4) >= 0) {
//						System.out.println("왼쪽 아래 대각선 검사 실행");
						int count = 0;
						
						for (int index = 0; index < 5; index++) {
							//오른쪽 아래 대각선 검사
							if(board[i+index][j-index] == 'o') {
								count++;
							}
						}
						
						if(count == 5) {
							result = Y;
							break loop;
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " +result);
		}
	}
}

package gold;

import java.util.Scanner;

public class Main_17069 {
	static int N;
	
	static int board[][];
	static long[][][] boardCheck;
	
	//가로, 세로, 대각선
	static int[] dx = {0, +1, +1};
	static int[] dy = {+1, 0, +1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		board = new int[N][N];
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
//		printBoard();
		
		boardCheck = new long[N][N][3];
		
		// 0: 가로, 1: 세로, 2: 대각선
		boardCheck[0][1][0] = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 2; j < N; j++) {
				if(board[i][j] == 1) {
					continue;
				}
				
				if(j-1 >= 0) {
					//가로(내가 가로로 들어올 수 있는 이전의 값의 경우의 수를 모두 더해준다.)
					boardCheck[i][j][0] = boardCheck[i][j-1][0] + boardCheck[i][j-1][2];
				}
				
				if(i-1 >= 0) {
					//세로
					boardCheck[i][j][1] = boardCheck[i-1][j][1] + boardCheck[i-1][j][2];
				}
				
				
				if(i-1 >= 0 && j-1 >= 0) {
					if(board[i-1][j] == 1 || board[i][j-1] == 1) {
						continue;
					}
					//대각선
					boardCheck[i][j][2] = boardCheck[i-1][j-1][0] + boardCheck[i-1][j-1][1] + boardCheck[i-1][j-1][2];
				}
			}
		}
		
		System.out.println(boardCheck[N-1][N-1][0]+boardCheck[N-1][N-1][1]+boardCheck[N-1][N-1][2]);
	}
	

	
	static void printBoard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------------------------");
	}
}

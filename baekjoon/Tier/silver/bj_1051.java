package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1051 {
	public static boolean searchBox(int[][] box) {
//		if(box[0][0] == box[0][box.length-1] == box[box.length-1][0] == box[box.length-1][box.length-1]) {
//			return true;
//		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][M];
		
		String temp = "";
		
		int size = 1;
		
		int maxValue = Math.min(N, M);
		
		for (int i = 0; i < N; i++) {
			temp = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = temp.charAt(j) - '0'; 
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				for (int l = maxValue; l > 0; l--) {
					
				}
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		
	}
}

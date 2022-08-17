package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main_1992 {
	static int N;
	static int[][] board;
	static String answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		board = new int[N][N];
		answer = "";

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = temp.charAt(j) - '0';
			}
		}

//		for (int[] list : board) {
//			System.out.println(Arrays.toString(list));
//		}
		
		task(0,0,N,N);
		System.out.println(answer);
	}

	static void task(int startX, int startY, int endX, int endY) {
		if (endX - startX == 0) {
			return;
		}
		
		Set<Integer> set = new HashSet<Integer>();

		for (int i = startX; i < endX; i++) {
			for (int j = startY; j < endY; j++) {
//				System.out.print(board[i][j] + " ");
				set.add(board[i][j]);
			}
//			System.out.println();
		}
		
		if(set.size() == 1) {
			for(Integer value : set) {
				answer += Integer.toString(value);
			}
			
			return;
		} else {
			answer += "(";
		}


		int middleX = (startX + endX) / 2;
		int middleY = (startY + endY) / 2;

		task(startX, startY, middleX, middleY); // 1번영역
		task(startX, middleY, middleX, endY); // 2번영역
		task(middleX, startY, endX, middleY); // 3번영역
		task(middleX, middleY, endX, endY); // 4번영역
		
		answer+=")";
	}

}

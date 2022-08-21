package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main_2667 {
	static int[] dx = { -1, 0, +1, 0 }; // up, right, down, left
	static int[] dy = { 0, +1, 0, -1 };

	static int board[][];

	static int N;

	static int count;

	static int max;

	static List<Integer> houseCountList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		board = new int[N][N];

		count = 0;

		max = 0;

		houseCountList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String list = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = list.charAt(j) - '0';
			}
		}
		// Input End

		// 완탐
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
					if (dfs(i, j)) {
						count++;
						houseCountList.add(max);
						max = 0;
					}

			}
		}

		System.out.println(count);
		Collections.sort(houseCountList);
		for (int value : houseCountList) {
			System.out.println(value);
		}

//        print();
	}

	static boolean dfs(int x, int y) {
		// 기저조건
		if (x < 0 || x >= N || y < 0 || y >= N || board[x][y] == 0) {
//			max = Math.max(max, count);
			return false;
		}

		// 집을 발견했으면
		if (board[x][y] == 1) {
			max++;
			// 방문 처리
			board[x][y] = 0;
//            print();

			// up
			dfs(x - 1, y);
			// right
			dfs(x, y + 1);
			// down
			dfs(x + 1, y);
			// left
			dfs(x, y - 1);
			return true;
		}

		return false;
	}

	static void print() {
		for (int[] list : board) {
			System.out.println(Arrays.toString(list));
		}
		System.out.println("--------------------");
	}
}
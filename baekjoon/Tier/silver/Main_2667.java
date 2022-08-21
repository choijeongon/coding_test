package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
				if (board[i][j] == 1) {
					bfs(i, j);
					count++;
					houseCountList.add(max);
					max = 0;
				}
				
//					if (dfs(i, j)) {
//						count++;
//						houseCountList.add(max);
//						max = 0;
//					}

			}
		}

		System.out.println(count);
		Collections.sort(houseCountList);
		for (int value : houseCountList) {
			System.out.println(value);
		}

//        print();
	}
	
	static void bfs(int x, int y) {
		Queue<Position> queue = new LinkedList<>();
		
		//첫 번째 값 넣기
		queue.offer(new Position(x, y));
		//방문 처리
		board[x][y]=0;
		max++;
		
		while(!queue.isEmpty()) {
			Position currentPosition = queue.poll();
			
			for (int direct = 0; direct < 4; direct++) {
				int nextX = currentPosition.x + dx[direct];
				int nextY = currentPosition.y + dy[direct];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || board[nextX][nextY] ==0) {
					continue;
				}
				
				if(board[nextX][nextY] == 1) {
					max++;
					queue.offer(new Position(nextX, nextY));
					//방문 처리
					board[nextX][nextY]=0;
					
				}
			}
			
		}
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
	
	static class Position{
		int x;
		int y;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + "]";
		}
	}

	static void print() {
		for (int[] list : board) {
			System.out.println(Arrays.toString(list));
		}
		System.out.println("--------------------");
	}
}
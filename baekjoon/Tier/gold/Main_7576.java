package gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7576 {
	static int N;
	static int M;
	static int[][] board;

	static int[] dx = { -1, 0, +1, 0 }; // up, right, down, left
	static int[] dy = { 0, +1, 0, -1 };
	static Queue<Position> queue = new LinkedList<>();
	static int level;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		board = new int[N][M];

		level = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		// Input End
//		printBoard();

		// 처음부터 모든 토마토가 익어있었다면
		if (!checkBoardZero()) {
			System.out.println("0");
		} else {
			// 완탐
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] == 1) {
						queue.offer(new Position(i, j));
					}
				}
			}
			bfs();

			// bfs가 끝났는데도 0이 남아있다면 -1출력
			if (checkBoardZero()) {
				System.out.println("-1");
			} else {
				System.out.println(level-1);
			}

		}

	}

	static void bfs() {
		// 처음 값 넣기
//		queue.offer(new Position(x,y));

		while (!queue.isEmpty()) {
//			printBoard();
//			System.out.println("level: " + level);
			int level_size = queue.size();


			while (level_size-- != 0) {
				Position currentPosition = queue.poll();
				for (int direct = 0; direct < 4; direct++) {
					int nextX = currentPosition.x + dx[direct];
					int nextY = currentPosition.y + dy[direct];

					// 조건 처리
					if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && board[nextX][nextY] == 0) {
						queue.offer(new Position(nextX, nextY));
						board[nextX][nextY] = 1;
					}
				}
			}
			
			level++;
		}
	}

	static class Position {
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

	static void printBoard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------------");
	}

	// 0이 하나라도 있다면 true, 한개도 없으면 false
	static boolean checkBoardZero() {
		boolean zeroCheck = false;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) {
					zeroCheck = true;
				}
			}
		}

		return zeroCheck;
	}
}

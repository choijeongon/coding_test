package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055 {
	static int R;
	static int C;
	static char[][] board;
	static boolean[][] visited;

	static Position startPosition;
	static Position endPosition;

	static int minTime;

	static int dept;

	static final int[] dx = { -1, 0, +1, 0 };
	static final int[] dy = { 0, +1, 0, -1 };
	
	static boolean success;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];
		visited = new boolean[R][C];

		minTime = 0;

		dept = 0;
		
		success = false;

		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		// InputEnd

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 'S') {
					startPosition = new Position(i, j);
				}
				if (board[i][j] == 'D') {
					endPosition = new Position(i, j);
				}
			}
		}
		// 고슴도치, 굴 위치 받기

		bfs();
		if(success) {
			System.out.println(dept);
		} else {
			System.out.println("KAKTUS");
		}
	}

	static void bfs() {
		Queue<Position> queue = new LinkedList<>();

		queue.offer(startPosition);
		// 방문 체크
		visited[startPosition.x][startPosition.y] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			
			//물이 찰곳 예약해놓기(O으로 변경)
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (board[i][j] == '*') {
						for (int d = 0; d < 4; d++) {
							//다음 물이 들어찰곳
							int nextX = i + dx[d];
							int nextY = j + dy[d];
							
							//안되는 곳 거르기
							if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C || board[nextX][nextY] == 'X'
									|| board[nextX][nextY] == '*' || board[nextX][nextY] == 'D') {
								continue;
							}
							
							//물이 들어 찰 곳에 O로 바꿔놓기
							board[nextX][nextY] = 'O';
						}
					}
				}
			}
			
//			System.out.println("dept: " + dept);
			for (int s = 0; s < size; s++) {
				Position currentPosition = queue.poll();
				
				if(board[currentPosition.x][currentPosition.y] == 'D') {
					success = true;
					return;
				}

//				printBoard();

				for (int d = 0; d < 4; d++) {
					int nextX = currentPosition.x + dx[d];
					int nextY = currentPosition.y + dy[d];

					if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C || board[nextX][nextY] == 'X'
							|| board[nextX][nextY] == '*' || board[nextX][nextY] == 'O' || visited[nextX][nextY] == true ) {
						continue;
					}
					
					queue.offer(new Position(nextX, nextY));
					visited[nextX][nextY] = true;
				}

//				printBoard();
			}
			
			//물이 들어찬다~ 가자!
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (board[i][j] == 'O') {
						board[i][j] = '*';
					}
				}
			}
			
			dept++;
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
		for (char[] list : board) {
			System.out.println(Arrays.toString(list));
		}
		System.out.println("--------------------------------");
	}
}

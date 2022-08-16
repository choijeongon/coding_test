package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2178 {
	
	static int N;
	static int M;
	
	static int[][] board;
	static int[][] copyBoard;
	
	static int count;
	
	static final int[] dx = {-1, 0, +1, 0}; //up, right, down, left
	static final int[] dy = {0, +1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		copyBoard = new int[N][M];
		
		count = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j) - '0';
				copyBoard[i][j] = board[i][j];
			}
		}
		//Input End
		
//		for(int[] line : board) {
//			System.out.println(Arrays.toString(line));
//		}
		
		dfs(0,0,1);
		
		//output
		System.out.println(count);
	}
	
	static void print() {
		for(int[] list :  copyBoard) {
			System.out.println(Arrays.toString(list));
		}
		System.out.println("-------------------------------");
	}
	
	static void dfs(int x, int y, int cnt) {
		//방문 표시
		copyBoard[x][y] = 0;
		
		//기저 조건
		if(x == (N-1) && y == (M-1)) {
			count = Math.min(count, cnt);
			return;
		}
		
		//델타 탐색
		for (int direct = 0; direct < 4; direct++) {
			int nextX = x + dx[direct];
			int nextY = y + dy[direct];
			
			//범위 벗어나는지 체크
			if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
				continue;
			}
			
			//이미 방문한 곳으로 돌아갈 수 없음
			if(copyBoard[nextX][nextY] == 0) {
				continue;
			}
			
			//0인곳에는 못감
			if(board[x][y] == 0) {
				continue;
			}
			System.out.println("cnt= " + cnt);
			print();
			
			dfs(nextX, nextY, cnt+1);
			//여기를 방문 안했을때도 돌려보기
			copyBoard[x][y] = 1;
//			dfs(nextX, nextY, cnt);
		}
	}
}

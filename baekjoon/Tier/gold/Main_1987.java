package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1987 {
	static int R;
	static int C;
	static char[][] board;
	static boolean[] isUsed;
	static int max;
	
	static final int[] dx = {-1,0,+1,0}; //up,right,down,left
	static final int[] dy = {0,+1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		//0부터 A
		isUsed = new boolean[26];
		//말이 지나는 칸은 좌측 상단의 칸도 포함된다.
		max = 0;
		
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		//Input End
		
//		printBoard();
		
//		bfs();
		dfs(0,0,0);
		
		System.out.println(max);
	}
	
	static void dfs(int x, int y, int count) {
		//방문 체크
		int value = board[x][y] - 'A';
		if(isUsed[value]) {
			max = Math.max(max, count);
			return;
		}
		
		isUsed[value] = true;
		
		//델타탐색
		for (int direct = 0; direct < 4; direct++) {
			int nextX = x + dx[direct];
			int nextY = y + dy[direct];
			
			//범위 벗어나면 유망하지 않음
			if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) {
				continue;
			}
			
			//이미 사용중인 알파벳이라면 갈 수 없음
//			int alpabetIndex = board[nextX][nextY]-'A';
//			if(isUsed[alpabetIndex]) {
//				continue;
//			}
			dfs(nextX, nextY, count+1);
		}
		isUsed[value] = false;
	}
	
	static void bfs() {
		Queue<Position> queue = new LinkedList<>();
		
		//좌측 상단에서 시작
		queue.offer(new Position(0,0));
		//방문 체크
		int firstValue = board[0][0] - 'A';
		isUsed[firstValue] = true;
		
		while(!queue.isEmpty()) {
			//제일 첫 번째 꺼내기
			Position currentPosition = queue.poll();
			System.out.println(currentPosition);
			printUsedList();
			System.out.println();
			
			int nextX;
			int nextY;
			
			//델타탐색
			for (int direct = 0; direct < 4; direct++) {
				nextX = currentPosition.x + dx[direct];
				nextY = currentPosition.y + dy[direct];
				
				//범위 벗어나면 유망하지 않음
				if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) {
					continue;
				}
				
				//이미 사용중인 알파벳이라면 갈 수 없음
				int alpabetIndex = board[nextX][nextY]-'A';
				if(isUsed[alpabetIndex]) {
					continue;
				}
				
				queue.offer(new Position(nextX, nextY));
				isUsed[alpabetIndex] = true;
				max++;
			}
		}
		
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
	
	static void printBoard() {
		for(char[] list: board) {
			System.out.println(Arrays.toString(list));
		}
	}
	
	static void printUsedList() {
		for (int i = 0; i < isUsed.length; i++) {
			if(isUsed[i]) {
				System.out.print((char)(i+'A') + " ");
			}
		}
	}
}

package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3109 {
	static int R, C;
	static char[][] board;
	static char[][] copyBoard;
	
	static final int[] dx = {-1,0,+1}; //오른쪽 위, 오른쪽, 오른쪽 아래
	static final int[] dy = {+1, +1, +1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		copyBoard = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		//Input End
		
		//copyBoard 초기화
		rollBackCopyBoard();
		
//		for(char[] list: board) {
//			System.out.println(Arrays.toString(list));
//		}
		
		
	}
	
	static void searchPipePath(int startX, int startY) {
		//끝에 도착하면 성공
		if(startY == C-1) {
			return;
		}
		
		//3방향 접근 가능
		for (int direct = 0; direct < 3; direct++) {
			int nextX = startX + dx[direct];
			int nextY = startY + dy[direct];
			
		}
	}
	
	static void rollBackCopyBoard() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				copyBoard[i][j] = board[i][j];
			}
		}
	}

}
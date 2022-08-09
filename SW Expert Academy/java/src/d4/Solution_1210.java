package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210 {
	static int[][] board;
	static boolean[][] checkUsedLocationBoard;

	// 위, 오른쪽, 아래쪽, 왼쪽
//	static final int[] dx = {-1,0,+1,0};
//	static final int[] dy = {0,+1,0,-1};
	static int startLocation;

	static void searchStartPoint(int current_x, int current_y) {

		if (startLocation != 0)
			return;

		// 출발점에 도착했으면
		if (current_x == 0) {
//			print();
			startLocation = current_y;
			return;
		}
		
		//왼쪽 체크
		if(!(current_y - 1 < 0)) {
			int left_position_y = current_y - 1;
			
			// 왼쪽 체크(왼쪽이 1이고 안갔으면)
			if (board[current_x][left_position_y] == 1 && checkUsedLocationBoard[current_x][left_position_y] == false) {
				checkUsedLocationBoard[current_x][left_position_y] = true;
				searchStartPoint(current_x, left_position_y);
			}
		}
		
		//오른쪽 체크
		if(!(current_y + 1 > 99)) {
			int right_position_y = current_y + 1;
			
			// 오른쪽 체크(오른쪽이 1이고 안갔으면)
			if (board[current_x][right_position_y] == 1
					&& checkUsedLocationBoard[current_x][right_position_y] == false) {
				checkUsedLocationBoard[current_x][right_position_y] = true;
				searchStartPoint(current_x, right_position_y);
			}
			
		}
		
		// 위로 올라가기
		int up_position_x = current_x - 1;
		if (board[up_position_x][current_y] == 1 && checkUsedLocationBoard[up_position_x][current_y] == false) {
			checkUsedLocationBoard[up_position_x][current_y] = true;
			searchStartPoint(up_position_x, current_y);
		}
	}

	static void print() {
		for (int j = 0; j < 100; j++) {
			for (int k = 0; k < 100; k++) {
				System.out.print(checkUsedLocationBoard[j][k] ? "O" : ".");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = 10;
		for (int i = 1; i <= TC; i++) {
			board = new int[100][100];
			checkUsedLocationBoard = new boolean[100][100];
			int testCaseNumber = Integer.parseInt(br.readLine());
			StringTokenizer st;
			for (int j = 0; j < 100; j++) {
				st = new StringTokenizer(br.readLine());

				int[] tempList = new int[100];

				for (int k = 0; k < 100; k++) {
					tempList[k] = Integer.parseInt(st.nextToken());
				}

				board[j] = tempList;
			}
			// 여기까지 인풋

			// 디버깅 출력
//			for (int j = 0; j < 100; j++) {
//				System.out.println(Arrays.toString(board[j]));
//			}

			// 2 찾기
			for (int index = 0; index < 100; index++) {
				if (board[99][index] == 2) {
					// 탐색 실행
					searchStartPoint(99, index);
					break;
				}
			}

			sb.append("#" + i + " " + startLocation + "\n");
			startLocation = 0;
		}
		System.out.println(sb);
	}
}

package gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_17406 {
	static int N, M, K;

	static int[] di = { 0, 1, 0, -1 }; // 0: right, 1: down, 2: left, 3: up
	static int[] dj = { 1, 0, -1, 0 };
	static int[][] board;
	static int[][] originalBoard;

	static Rotation[] rotations;
	static Rotation[] numbers;
	static boolean[] isSelected;

	static int totalMin = Integer.MAX_VALUE;

	static Rotation[][] resultList;
	static int globalIndex = 0;

	static int getMinBoard() {
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < board.length; i++) {
			int sum = 0;

			for (int j = 0; j < board[0].length; j++) {
				sum += board[i][j];
			}

			min = Math.min(min, sum);
		}

		return min;
	}

	// 기존 보드의 값을 받아서 새로운 정사각형 보드를 리턴
	static void rotate(int sX, int sY, int eX, int eY, int dept, int rX, int rY) {
		int[][] copyBoard = new int[board.length][board[0].length];

		for (int d = 0; d < dept; d++) {
			int nowi = sX + d, nowj = sY + d; // 레이어 좌상 시작점.
			int dir = 0;

			while (true) {
				int nexti = nowi + di[dir];
				int nextj = nowj + dj[dir];
//			System.out.println("next X:" + nexti + " nextY:" + nextj);
				// 옆칸 못쓰는 칸 판단..! 방향전환
				if (nextj >= (eY - d) || nexti >= (eX - d) || nextj < (sY + d) || nexti < (sX + d)) {
					dir++;
					if (dir == 4) {
						break;
					} else {
						continue;
					}
				}

				copyBoard[nexti][nextj] = board[nowi][nowj]; // 옆칸 땡겨오기
				nowi = nexti; // 난 이제 옆칸으로~~
				nowj = nextj;
			}
		}

		// 반지름에 해당하는 값 넣어주기
		copyBoard[rX][rY] = board[rX][rY];

		for (int i = 0; i < copyBoard.length; i++) {
			for (int j = 0; j < copyBoard[0].length; j++) {
				if (copyBoard[i][j] != 0) {
					board[i][j] = copyBoard[i][j];
				}
			}
		}

	}

	static void perm(int count) {
		// 기저 조건
		if (count == K) {

			for (int j = 0; j < numbers.length; j++) {
				resultList[globalIndex][j] = numbers[j];
			}

			globalIndex++;

			return;
		}

		// 가능한 모든 수에 대해 시도(input 배열의 모든 수 시도)
		for (int i = 0; i < K; i++) {
			// 시도하는 수가 선택 되었는지 판단
			if (isSelected[i]) {
				continue;
			}
			// 선택되지 않았다면 수를 사용
			// 이번에는 i가 아닌 rotations 배열에 있는 값을 사용
			numbers[count] = rotations[i];
			// 수를 사용하였다면 사용 표시
			isSelected[i] = true;
			// 다음 수 뽑기
			perm(count + 1);
			// 내 자릿수는 고정된 채로 하위 모든 다른 자릿수를 만들고 돌아왔다면 이제 다른 숫자도 탐색할 수 있도록 미사용으로 바꿔주기
			isSelected[i] = false;
		}

	}

	public static int fact(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fact(n - 1) * n;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		board = new int[N][M];
		originalBoard = new int[N][M];

		rotations = new Rotation[K];
		numbers = new Rotation[K];
		isSelected = new boolean[K];

		resultList = new Rotation[fact(K)][K];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
				originalBoard[i][j] = board[i][j];
			}
		}

		for (int i = 0; i < K; i++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			int S = sc.nextInt();
			rotations[i] = new Rotation(R, C, S);
		}
		// Input End

		// 순열 만들기
		perm(0);

		// 순열 돌리기(순열 하나당 배열 한사이클)
		for (int index = 0; index < resultList.length; index++) {
			Rotation[] currentRotationList = resultList[index];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					board[i][j] = originalBoard[i][j];
				}
			}

			for (int i = 0; i < currentRotationList.length; i++) {
				int startX = currentRotationList[i].r - currentRotationList[i].s;
				int startY = currentRotationList[i].c - currentRotationList[i].s;
				int endX = currentRotationList[i].r + currentRotationList[i].s;
				int endY = currentRotationList[i].c + currentRotationList[i].s;
				int dept = (endX - startX) / 2;
				int rX = startX + ((endX - startX) / 2);
				int rY = startY + ((endY - startY) / 2);

				rotate(startX - 1, startY - 1, endX, endY, dept, rX - 1, rY - 1);
			}
			int currentMin = getMinBoard();
			totalMin = Math.min(totalMin, currentMin);
		}

		System.out.println(totalMin);
	}

	static class Rotation {
		int r;
		int c;
		int s;

		public Rotation(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}

		@Override
		public String toString() {
			return "Rotation [r=" + r + ", c=" + c + ", s=" + s + "]";
		}
	}
}

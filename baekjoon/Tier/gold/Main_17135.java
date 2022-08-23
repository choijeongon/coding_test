package gold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_17135 {
	static int N;
	static int M;
	static int D;
	static int[][] board;
	static int[][] copyBoard;
	
	static int minX;
	static int minY;

	static int maxValue;

	// 조합 변수
	static int[] inputList;
	static int[] numbers;
	static List<int[]> arrowCombList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//높이
		N = sc.nextInt();
		//넓이
		M = sc.nextInt();
		//궁수 공격 제한거리
		D = sc.nextInt();
		
		//맨 아랫칸에 궁수 배치
		board = new int[N + 1][M];
		copyBoard = new int[N + 1][M];

		//조합
		inputList = new int[M];
		numbers = new int[3];
		arrowCombList = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			inputList[i] = i;
		}

		maxValue = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
				copyBoard[i][j] = board[i][j];
			}
		}
		// Input End

//		printBoard();

		// 궁수 배치하기(조합)
		comb(0, 0);

		// 궁수 위치의 조합만큼 시뮬레이션 돌리기
//		for (int i = 0; i < 1; i++) {
		for (int i = 0; i < arrowCombList.size(); i++) {
			int[] arrowPersonPositionList = arrowCombList.get(i);
			System.out.println("궁수 조합" + i);
			rollBackCopyBoard();

			Position[] arrowPeople = new Position[3];

			// copyBaord에 궁수 배치하기
			int castleX = N;
			// 궁수는 2로 생성
			for (int j = 0; j < arrowPersonPositionList.length; j++) {
				copyBoard[castleX][arrowPersonPositionList[j]] = 2;
				arrowPeople[j] = new Position(castleX, arrowPersonPositionList[j]);
			}


			int count = 0;
//			printCopyBoard();

			// 시뮬레이션 시작
			while (true) {
				System.out.println("내 턴 실행 전");
				printCopyBoard();
				
				// 적들의 좌표가 보관되어 있는 리스트
				List<Position> enemyList = new ArrayList<>();
				

				// 공격하려는 적 뽑기
				for (Position p : arrowPeople) {
					List<Position> huboList = new ArrayList<>();
					
					for (int x = 0; x < N; x++) {
						for (int y = 0; y < M; y++) {
							int currentDistance = getDistance(x, y, p.x, p.y);
							
							// 1이고 거리 조건을 만족해야 함
							if (copyBoard[x][y] == 1 && D >= currentDistance) {
								huboList.add(new Position(x, y));
								
							}
						}
					}
					
					
					for (int j = 0; j < huboList.size(); j++) {
						if(j==0) {
							minX = huboList.get(j).x;
							minY = huboList.get(j).y;
						} else {
							int currentDistance = getDistance(huboList.get(j).x, huboList.get(j).y, p.x, p.y);
							int minPersonDistance = getDistance(minX, minY, p.x, p.y);
							
							// 거리가 최소값이여야 한다.
							if (minPersonDistance > currentDistance) {
								minX = huboList.get(j).x;
								minY = huboList.get(j).y;
								// 거리가 같으면 왼쪽에 있는 사람이 타겟이 된다.
							} else if (minPersonDistance == currentDistance) {
								if(minX > huboList.get(j).x && minY > huboList.get(j).y) {
									minX = huboList.get(j).x;
									minY = huboList.get(j).y;
								} else if(minX > huboList.get(j).x) {
									minX = huboList.get(j).x;
									minY = huboList.get(j).y;
								} else if(minY > huboList.get(j).y) {
									minX = huboList.get(j).x;
									minY = huboList.get(j).y;
								}
							}
							
						}
					}

					enemyList.add(new Position(minX, minY));
				}

				// 적 죽이기
				if (!enemyList.isEmpty()) {
					for (int j = 0; j < enemyList.size(); j++) {
						Position killHuboPerson = enemyList.get(j);
						
						System.out.println("killHuboPerson: " + killHuboPerson.x + ", " + killHuboPerson.y);

						if (copyBoard[killHuboPerson.x][killHuboPerson.y] == 1) {
							copyBoard[killHuboPerson.x][killHuboPerson.y] = 0;
							count++;
							System.out.println("count: " + count);
						}

					}
				}
				
				System.out.println("내 턴 실행 후");
				printCopyBoard();
				playYourTurn();
				System.out.println("적 턴 실행 후");
				printCopyBoard();

				// 게임 종료 체크
				if (checkGameOver()) {
					break;
				}
			}
			System.out.println("total count: " + count);
			System.out.println("-----------궁수 조합 끝----------------");

			maxValue = Math.max(maxValue, count);
		}

		// OutPut
		System.out.println("maxValue: " + maxValue);

	}

	static void comb(int count, int start) {
		if (count == 3) {
			int[] tempList = new int[3];

			for (int i = 0; i < 3; i++) {
				tempList[i] = numbers[i];
			}

			arrowCombList.add(tempList);
//			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = start; i < M; i++) {
			numbers[count] = inputList[i];
			comb(count + 1, i + 1);
		}
	}

	static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	static void printCopyBoard() {
		for (int[] list : copyBoard) {
			System.out.println(Arrays.toString(list));
		}
		System.out.println("-------------------");
	}

	static void rollBackCopyBoard() {
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < M; j++) {

				// 궁수 열도 초기화
				if (i == N) {
					copyBoard[i][j] = 0;
				} else {
					copyBoard[i][j] = board[i][j];
				}

			}
		}
	}

	static void playYourTurn() {
		// copyBoard의 행을 마지막 행부터 한칸씩 앞으로 당긴다.
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if (i == 0) {
					copyBoard[i][j] = 0;
				} else {
					copyBoard[i][j] = copyBoard[i - 1][j];
				}
			}
		}

	}

	static boolean checkGameOver() {
		// copyBoard를 조사했을 떄 모두 0이면 게임 종료

		boolean gameOver = true;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 1이 하나라도 있으면 게임은 끝나지 않았음
				if (copyBoard[i][j] == 1) {
					gameOver = false;
				}

			}
		}

		return gameOver;
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
			return "Person [x=" + x + ", y=" + y + "]";
		}
	}

}
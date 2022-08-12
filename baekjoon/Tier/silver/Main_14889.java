package silver;

import java.util.Arrays;
import java.util.Scanner;

public class Main_14889 {
	static int N, R, min;

	static int[][] board;

	static int[] A_TEAM;
	static int[] B_TEAM;

	static int[] inputList;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		R = N / 2;


		min = Integer.MAX_VALUE;

		board = new int[N][N];
		inputList = new int[N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i <= N; i++) {
			inputList[i - 1] = i;
		}
		// input End

		A_TEAM = new int[R];
		B_TEAM = new int[R];

		comb(0, 0);

		// output
		System.out.println(min);
	}


	static void comb(int count, int start) {
		// 기저 조건
		if (count == R) {
//			System.out.println("A Team");
//			System.out.println(Arrays.toString(A_TEAM));
			// B팀 구하기(inputList - A_TEAM)
			B_TEAM = new int[R];
			int b_index = 0;

			for (int i = 0; i < inputList.length; i++) {
				int checkValue = inputList[i];
				// value가 A팀에 포함되어 있지 않는다면 B팀에 넣어주기
				if (!Arrays.stream(A_TEAM).anyMatch(k -> k == checkValue)) {
					B_TEAM[b_index] = checkValue;
					b_index++;
				}
			}

//			System.out.println("B Team");
//			System.out.println(Arrays.toString(B_TEAM));

			int a_team_ability = 0;
			int b_team_ability = 0;

			// 각 팀의 능력치 구하기
			for (int i = 0; i < A_TEAM.length; i++) {
				for (int j = 0; j < A_TEAM.length; j++) {
					if(A_TEAM[i] != A_TEAM[j]) {
						a_team_ability += board[A_TEAM[i]-1][A_TEAM[j]-1];
					}
				}
			}
			
			for (int i = 0; i < B_TEAM.length; i++) {
				for (int j = 0; j < B_TEAM.length; j++) {
					if(B_TEAM[i] != B_TEAM[j]) {
						b_team_ability += board[B_TEAM[i]-1][B_TEAM[j]-1];
					}
				}
			}
			
			
			int ability_different = Math.abs(a_team_ability - b_team_ability);

			min = Math.min(min, ability_different);

			return;
		}

		// inputList의 값을 모두 돌아본다.
		for (int i = start; i < inputList.length; i++) {
			A_TEAM[count] = inputList[i];
			comb(count + 1, i + 1);
		}
	}
}

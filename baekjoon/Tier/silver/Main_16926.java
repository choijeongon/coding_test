package silver;

import java.util.Scanner;

public class Main_16926 {
	
	static int N, M, R;
	static int[][] map;
	static int[][] newMap;
	
	static void arrayTurn() {
		int min = Math.min(N, M);

		int limit = min / 2 - 1;

		int dept = 0;

		while (dept <= limit) {
			for (int i = dept; i < N; i++) {
				for (int j = dept; j < M; j++) {
					if(i != dept &&  j!= dept && j!= M - 1 - dept && i != N - 1 - dept) {
						continue;
					}
					
					// 영역 나누기
					// Top
					if (i == dept) {
						// 예외 체크
						if (j + 1 < (M - dept)) {
							if(newMap[i][j] == 0)
							newMap[i][j] = map[i][j + 1];
						}
					}
					// Left
					if (j == dept) {
						// 예외 체크
						if (i - 1 >= dept) {
							if(newMap[i][j] == 0)
							newMap[i][j] = map[i - 1][j];
						}
					}

					// Right
					if (j == M - 1 - dept) {
						// 예외 체크
						if (i + 1 < (N - dept)) {
							if(newMap[i][j] == 0)
							newMap[i][j] = map[i + 1][j];
						}
					}

					// bottom
					if (i == N - 1 - dept) {
						// 예외 체크
						if (j - 1 >= dept) {
							if(newMap[i][j] == 0)
							newMap[i][j] = map[i][j - 1];
						}
					}
				}
			}

			dept++;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		 N = sc.nextInt();
		 M = sc.nextInt();
		 R = sc.nextInt();

		 map = new int[N][M];
		 newMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

//		for (int[] list : map) {
//			System.out.println(Arrays.toString(list));
//		}
		
		for (int index = 0; index < R; index++) {
			arrayTurn();
			
			//map Update
			map = deepCopy(newMap);
			
			newMap = new int[N][M];
			
//			for (int i = 0; i < N; i++) {
//				Arrays.fill(newMap[i], 0);
//			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]+ " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static int[][] deepCopy(int[][] original2) {
		if(original2 == null) return null;
		int[][] result = new int[original2.length][original2[0].length];
		
		for(int i=0; i<original2.length; i++){
			System.arraycopy(original2[i], 0, result[i], 0, original2[0].length);
		}
		
		return result;
	}
}
package d2;

import java.util.Arrays;
import java.util.Scanner;

public class swea_1954 {
    public static void main(String[] args) {
    	int[] direct_x = { 0, 1, 0, -1 };
    	int[] direct_y = { 1, 0, -1, 0 };
    	
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();

            int[][] board = new int[N][N];

            int direct = 0;

            int current_x = 0;
            int current_y = 0;

            int range = N * N + 1;

            for (int i = 1; i < range; i++) {
                board[current_x][current_y] = i;
                
                current_x += direct_x[direct];
                current_y += direct_y[direct];

                if (current_x >= N || current_y >= N || current_x < 0  || current_y < 0) {
                    current_x -= direct_x[direct];
                    current_y -= direct_y[direct];

                    direct = (direct + 1) % 4;

                    current_x += direct_x[direct];
                    current_y += direct_y[direct];
                }
                if (board[current_x][current_y] != 0) {
                	current_x -= direct_x[direct];
                	current_y -= direct_y[direct];
                	
                	direct = (direct + 1) % 4;
                	
                	current_x += direct_x[direct];
                	current_y += direct_y[direct];
                }
                
            }
            
            sb.append("#" + tc + "\n");
            
//            System.out.println("#" + tc);
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < board.length; j++) {
            		sb.append(board[i][j] + " ");
//					System.out.print(board[i][j] + " ");
				}
            	sb.append("\n");
//            	System.out.println();
            }
        }
        System.out.println(sb);
    }
}
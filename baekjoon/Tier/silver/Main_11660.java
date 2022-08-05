package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] sigma = new int[N+1][N+1]; // i번째, j번째 라서 0인덱스 안씀.
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				sigma[i][j] = sigma[i][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int m = 0; m < M; m++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int x= x1; x<=x2;x++) {
				sum += sigma[x][y2] - sigma[x][y1-1];
			}
			sb.append(sum+"\n");
		}
		System.out.println(sb);
	}
}

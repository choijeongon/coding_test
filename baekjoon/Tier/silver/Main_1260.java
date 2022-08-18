package silver;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1260 {
	static int N;
	static int M;
	static int V;
	static int[][] adjMatrix;
	static boolean visitedDFS[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		adjMatrix = new int[N+1][N+1];
		visitedDFS = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[to][from] = adjMatrix[from][to] = 1;
		}
		//Input End
		
		//Input Check
		for(int[] list : adjMatrix) {
			System.out.println(Arrays.toString(list));
		}
		
		dfs(V);
		System.out.println();
		bfs();
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		//선 방문 예약
		visited[V] = true;;
		queue.offer(V);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print(cur + " ");
			
			for (int i = 1; i < N+1; i++) {
				if(!visited[i] && adjMatrix[cur][i] != 0) {
					visited[i] = true;;
					queue.offer(i);
				}
			}
		}
		
	}

	private static void dfs(int cur) {
		visitedDFS[cur] = true;
		System.out.print(cur + " ");
		
		for (int i = 1; i < N+1; i++) {
			if(!visitedDFS[i] && adjMatrix[cur][i] != 0) {
				dfs(i);
			}
		}
	}
}

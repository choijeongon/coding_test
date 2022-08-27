package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrix {
	
	//가중치가 없으면 boolean형이어도 상관 없음
	static int[][] adjMatrix;
	//노드의 수
	static int N;
	//간선의 수
	static int E;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		E = sc.nextInt();
		
		adjMatrix = new int[N][N]; //0으로 자동 초기화
		
		for (int i = 0; i < E; i++) { //간선 정보에 해당하는 부분만 덮어씀
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			//무향 그래프일 경우(유향 그래프일 경우 위에 코드만 해주면 된다.)
			adjMatrix[from][to] = 1;
			adjMatrix[to][from] = 1;
		}
		
		bfs();
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];
		
		//편의상 0번 정점 시작점
		visited[0] = true;
		queue.offer(0);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println((char)(current+'A'));
			
			//현 정점의 인접정점들을 큐에 넣어서 차후 탐색하도록 만들기
			for (int i = 0; i < N; i++) {
				if(!visited[i] && adjMatrix[current][i] != 0) { //방문하지 않았으며 인접한 경우
					visited[i] = true;
					queue.offer(i);
				}
			}
			System.out.println();
			
		}
		
	}
}

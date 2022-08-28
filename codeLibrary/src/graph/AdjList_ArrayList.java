package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjList_ArrayList {
	static int N;
	static int E;
	
	static int[] visited;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		E = sc.nextInt();
		
		list = new ArrayList[N];
		visited = new int[N];
		
		//꼭 ArrayList 객체를 배열의 요소마다 생성을 해줘야 한다.
		for(int i = 0;i < N; i++) {
			list[i] = new ArrayList();
		}
		
		for(int i =0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			list[from].add(to);
			list[to].add(from);
		}
		//Input End
		bfs(0);
		dfs(0);
		
	}
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList();
		//bfs 전용 방문체크 배열 
		int[] visited = new int[N];
		
		// 시작정점을 큐에 삽입한다. 그러면서 방문체크도 한다.
		queue.offer(start);
		visited[start] = 1;
		
		while(!queue.isEmpty()) {
			// 큐에서 하나를 무조건 꺼낸다.
			int current = queue.poll();
			// 할일을 한다.
			System.out.print((char)(current + 'A') + " ");
			// 현재에 연결된 나머지들에 대해서 작업한다.
			for(int index : list[current]) {
				// 이미 방문처리한 것은 무시
				if(visited[index] == 1) {
					continue;
				}
				// 그렇지 않은 것은 큐에 삽입하고 방문처리 한다.
				queue.offer(index);
				visited[index] = 1;
			}
		}
		System.out.println();
	}
	
	static void dfs(int current) {
		visited[current] = 1;
		System.out.print((char)(current + 'A') + " ");
		
		for(Integer index : list[current]) {
			if(visited[index] == 1) {
				continue;
			}
			
			dfs(index);
		}
	}
	
}

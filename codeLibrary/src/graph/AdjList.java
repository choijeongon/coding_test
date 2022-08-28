package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjList {
	static Node[] adjList;
	static boolean[] visited;
	//노드의 수
	static int N;
	//간선의 수
	static int E;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		E = sc.nextInt();
		
		adjList = new Node[N];
		visited = new boolean[N];
		
		for (int i = 0; i < E; i++) { //간선 정보에 해당하는 부분만 덮어씀
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			//뒤에 넣는 친구가 맨 앞으로 들어감 따라서 탐색도 나중에 들어간 순으로 진행된다.
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		//Input End
		
		bfs();
		dfs(0);
	}
	
	static void dfs(int current) {
		visited[current] = true;
		System.out.print((char)(current+'A'));
		
		//현 정점의 인접정점들을 큐에 넣어서 차후 탐색하도록 만들기
		for (Node temp = adjList[current]; temp != null; temp = temp.next) {
			if(!visited[temp.to]) { //방문하지 않았으며 (인접한 경우는 인접리스트이기 때문에 따로 체크할 필요 없음)
				dfs(temp.to);
			}
		}
	}
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];
		
		//편의상 0번 정점 시작점
		visited[0] = true;
		queue.offer(0);
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print((char)(current+'A'));
			
			//현 정점의 인접정점들을 큐에 넣어서 차후 탐색하도록 만들기
			for (Node temp = adjList[current]; temp != null; temp = temp.next) {
				if(!visited[temp.to]) { //방문하지 않았으며 (인접한 경우는 인접리스트이기 때문에 따로 체크할 필요 없음)
					visited[temp.to] = true;
					queue.offer(temp.to);
				}
			}
		}
		System.out.println();
	}
	
	static class Node{
		int to;
		Node next;
		
		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}
}

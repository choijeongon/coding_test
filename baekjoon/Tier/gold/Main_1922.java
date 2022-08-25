package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1922 {
	static int N;
	static int M;
	
	LinkedList<Edge>[] adjList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		LinkedList<Edge>[] adjList = new LinkedList[N + 1];
		
		StringTokenizer st;
		
		for (int v = 1; v <= N; v++) {
			adjList[v] = new LinkedList<>();
		}
		
		for (int e = 0; e < M; e++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new Edge(weight, to));
			adjList[to].add(new Edge(weight, from));
		}
		
		boolean[] visited = new boolean[N+1];
		long result = 0; // 전체 정점을 연결한 총 간선비용.
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 1));
		
		int vertexCnt = 0;
		
		while(!pq.isEmpty()) {
			Edge minEdge = pq.poll();
			
			 if(visited[minEdge.num]) {
				 continue;
			 }
			 
			 result += minEdge.weight;
			 visited[minEdge.num] = true;
			 
			 vertexCnt++;
			 if(vertexCnt == N) {
				 break;
			 }
			 
			 for(Edge edge: adjList[minEdge.num]) {
				 if(!visited[edge.num]) {
					 pq.add(edge);
				 }
			 }
		}
		
		System.out.println(result);
		
	}
	static class Edge implements Comparable<Edge> {
		int weight, num;

		public Edge(int weight, int num) {
			this.weight = weight;
			this.num = num;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}

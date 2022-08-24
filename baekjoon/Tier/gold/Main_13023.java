package gold;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_13023 {
	// 사람의 수
	static int N;

	// 친구 관계의 수
	static int M;
	
	static int answer = 0;

	static ArrayList<Integer>[] list;
	static int[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		list = new ArrayList[N];
		visited = new int[N];

		// 꼭 생성을 해줘야 한다.(조심!!!!)
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList();
		}

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			// 양방향(단방향이면 얘만 써줘도 된다.)
			// 여러 개의 데이터가 필요하면 클래스를 직접 만들어서 쓰면 된다.
			list[from].add(to);
			list[to].add(from);
		}
		
		for (int i = 0; i < N; i++) {
			dfs(i, 0); //모든 정점에서 시작
			if(answer == 1) {
				break;
			}
//			System.out.println("--------------");
		}
		
		
		System.out.println(answer);
	}

	static void dfs(int current, int count) {
		visited[current] = 1;
		count++;
//		System.out.println("current: " + current);
//		System.out.println("count: " + count);
		
		if(count == 5) {
			answer = 1;
			return;
		}
		
		for(Integer idx : list[current]) {
			//이미 방문 했니?
			if(visited[idx] == 1) {
				continue;
			}
			
			//재귀 호출
			dfs(idx, count);
		}
		visited[current] = 0;
	}
}

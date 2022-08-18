package silver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//교수님 코드임
public class Main_2644 {
	static int N;
	static int[] v;
	
	//인접 행렬, 인접리스트 배열(정점의 갯수만큼)
	static ArrayList<Integer>[] list;  
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //정점수
		v = new int[N]; //방문체크 배열
		
		list = new ArrayList[N];
		
		//꼭 생성을 해줘야 한다.(조심!!!!)
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList();
		}
		
		int E = sc.nextInt(); //간선 수
		
		for(int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			//양방향(단방향이면 얘만 써줘도 된다.)
			//여러 개의 데이터가 필요하면 클래스를 직접 만들어서 쓰면 된다.
			list[from].add(to);
			list[to].add(from);
		}
//		dfs(0); //임의의 정점에서 시작
		bfs(0);

	}
	
	static void bfs(int start) {
		// 큐라는 자료 구조가 필요하다.
		Queue<Integer> q = new LinkedList();
		// 시작정점을 큐에 삽입한다. 그러면서 방문체크도 한다.
		q.offer(start);
		v[start] = 1;
		// 큐가 빌때까지 반복한다.
		while(!q.isEmpty()) {
			// 큐에서 하나를 무조건 꺼낸다.
			int cur = q.poll();
			// 할일을 한다.
			System.out.print((char)(cur + 'A') + " ");
			// 현재에 연결된 나머지들에 대해서 작업한다.
			for(int idx : list[cur]) {
				// 이미 방문처리한 것은 무시
				if(v[idx] == 1) {
					continue;
				}
				// 그렇지 않은 것은 큐에 삽입하고 방문처리 한다.
				q.offer(idx);
				v[idx] = 1;
			}
		}
		
		}
	
	static void dfs(int cur) {
		v[cur] = 1; //시작하자 마자 방문체크 함
		System.out.print((char)(cur+ 'A') + " ");

		//현재 정점에서 연결된 나머지 정점들 재귀 호출(인접 행렬이면 배열만큼 반복)
		//연결된 친구들만 존재하기 때문에 판단하는 코드 없어도 된다.
		for(Integer idx : list[cur]) {
			//이미 방문 했니?
			if(v[idx] == 1) {
				continue;
			}
			
			//재귀 호출
			dfs(idx);
			
		}
	}

}

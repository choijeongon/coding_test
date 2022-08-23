package silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697 {
	// 수빈이의 위치
	static int N;
	
	//동생에 위치
	static int K;
	
	static int min;
	
	static int dept;
	static boolean[] visit;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		K = sc.nextInt();
		
		min = Integer.MAX_VALUE;
		
		visit = new boolean[100001];
		
		dept=0;
		
		bfs(N);
		
		System.out.println(min);
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(start);
		//방문체크?
//		visit[start] = true;
		
		loop:
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for (int s = 0; s < size; s++) {
				int currentPosition = queue.poll();
				if(currentPosition < 0 || currentPosition > 100000) {
					continue;
				}
				
				if(visit[currentPosition]) {
					continue;
				}
				
//				System.out.println(currentPosition);
				
				if(currentPosition == K) {
					min = dept;
					break loop;
				}
				
				visit[currentPosition] = true;
				
				queue.offer(currentPosition*2);
				queue.offer(currentPosition-1);
				queue.offer(currentPosition+1);
				
			}
			dept++;
		}
	}
}

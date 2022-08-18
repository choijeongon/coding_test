package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test {
	static int n; //입력 인원수
	static int s, e, m;
	static ArrayList<Integer>[] list;
	static int res = -1;
	static boolean[] v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		s = sc.nextInt();
		e = sc.nextInt();
		m = sc.nextInt();
		
		list = new ArrayList[n+1];
		v = new boolean[n+1];
		
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList();
		}
		
		for(int i =0; i <m; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			list[from].add(to);
			list[to].add(from);
		} // 관계 입력
		bfs();
		
		System.out.println(res);
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList();
		q.offer(s);
		v[s] = true;
		int depth = 0;
		while(!q.isEmpty()) {
			//depth 관리
			int size = q.size();
			for(int i=0; i< size; i++) {
				int cur = q.poll();
				if(cur == e) {
					res = depth;
				}
				for(int idx : list[cur]) {
					//방문했으면 통과
					if(v[idx]) {
						continue;
					}
					q.offer(idx);
					v[idx] = true;
				}
			}
			depth++;
			
		}
		
	}
}

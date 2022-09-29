package etc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1463 {
	static int N;
	
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		min = Integer.MAX_VALUE;
		
//		dfs(N, 0);
		bfs();
		
		System.out.println(min);
	}

	static void dfs(int value, int count) {
		if(value == 1) {
			min = Math.min(min, count);
			return;
		}
		
		if(value < 1) {
			return;
		}
		
		if(value % 3 == 0) {
			dfs(value / 3, count+1);
		}
		if(value %2 ==0) {
			dfs(value/2, count+1);
		}
		
		dfs(value-1, count+1);
	}
	
	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(N, 0));
		
		while(!queue.isEmpty()) {
			Point x = queue.poll();
			
			if(x.value == 1) {
				min = Math.min(min, x.count);
				return;
			}
			
			if(x.value %3 == 0) {
				queue.add(new Point(x.value/3, x.count+1));
			}
			if(x.value %2 == 0) {
				queue.add(new Point(x.value/2, x.count+1));
			}
			
			queue.add(new Point(x.value-1, x.count+1));
		}
	}
	
	static class Point{
		int value;
		int count;
		
		public Point(int value, int count) {
			this.value = value;
			this.count = count;
		}
	}
	
}

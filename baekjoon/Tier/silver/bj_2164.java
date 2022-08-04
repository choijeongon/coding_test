package silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
//		System.out.println(queue.toString());
		
		while(queue.size() > 1) {
			queue.poll();
			if(queue.size() == 1) {
				break;
			}
			int value = queue.poll();
			queue.offer(value);
		}
		
		System.out.println(queue.poll());
	}
}

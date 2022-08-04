package d3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea_1225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int testCase = sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();
			
			for (int i = 0; i < 8; i++) {
				queue.add(sc.nextInt());
			}
			//여기까지 입력
			while(true) {
				int first = queue.poll();
				first -= 1;
				if(first <= 0) {
					queue.offer(0);
					break;
				} else {
					queue.offer(first);
				}
				
				int second = queue.poll();
				second -= 2;
				if(second <= 0) {
					queue.offer(0);
					break;
				} else {
					queue.offer(second);
				}
				
				int third = queue.poll();
				third -= 3;
				if(third <= 0) {
					queue.offer(0);
					break;
				} else {
					queue.offer(third);
				}
				
				int four = queue.poll();
				four -= 4;
				if(four <= 0) {
					queue.offer(0);
					break;
				} else {
					queue.offer(four);
				}
				
				int five = queue.poll();
				five -= 5;
				if(five <= 0) {
					queue.offer(0);
					break;
				} else {
					queue.offer(five);
				}
			}
			System.out.print("#" + testCase + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
	}
}

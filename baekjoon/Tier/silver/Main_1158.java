package silver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> resultList = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		// count == 3이 될때마다 pop
		int count = 0;
		
		while(!queue.isEmpty()) {
			for (int i = 0; i < N; i++) {
				count++;
				
				if((count % K) == 0) {
					resultList.add(queue.poll());
//				System.out.println(queue.poll());
				} else {
					queue.add(queue.poll());
				}
			}
		}
		
		
		System.out.print("<");
		for (int i = 0; i < resultList.size(); i++) {
			if(i == resultList.size()-1) {
				System.out.print(resultList.get(i));
			} else {
				System.out.print(resultList.get(i)+", ");
			}
		}
		System.out.print(">");
	}
}

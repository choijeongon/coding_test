package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1228 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			//0 ~ 999999사이 암호 갯수
			String[] originalList = new String[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < originalList.length; i++) {
				originalList[i] = st.nextToken();
			}
			
			int orderNumber = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			Queue queue = new LinkedList();
			
//			System.out.println("N: " + N);
//			System.out.println(Arrays.toString(originalList));
//			System.out.println("orderNumber: " + orderNumber);
			
			for (int i = 0; i < orderNumber; i++) {
				char order = st.nextToken().charAt(0);
				int start_location = Integer.parseInt(st.nextToken());
				int insertNumber = Integer.parseInt(st.nextToken());
				
				String[] insertList = new String[insertNumber];
				
				for (int j = 0; j < insertList.length; j++) {
					insertList[j] = st.nextToken();
				}
				
//				System.out.println("order: " + order);
//				System.out.println("start_location: " + start_location);
//				System.out.println("insertNumber: " + insertNumber);
//				System.out.println(Arrays.toString(insertList));
				
				//처음 파트 삽입
				for (int j = 0; j < start_location; j++) {
					queue.add(originalList[j]);
				}
				
				//중간 삽입
				
				//마지막 파트 삽입
				for (int j = start_location; j < originalList.length; j++) {
					queue.add(originalList[j]);
				}
			}
			
		}
	}
}

package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1228 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			LinkedList<Integer> list = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int len = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < len; i++) {
				String ch = st.nextToken(); // I
				int idx = Integer.parseInt(st.nextToken()); // 삽입 위치
				int count = Integer.parseInt(st.nextToken()); // 삽입 갯수
				
				for (int c = 0; c < count; c++) {
					int addNum = Integer.parseInt(st.nextToken());
					list.add(idx+c, addNum);
				}
			} //len번의 삽입 명령 수행 이후
			
			System.out.print("#"+tc+ " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}
}

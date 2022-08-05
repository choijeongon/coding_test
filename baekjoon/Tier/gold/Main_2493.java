package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Top> top_stack = new Stack<Top>();

		int N = Integer.parseInt(br.readLine());

		Top[] top_list = new Top[N + 1];

		int[] result_list = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i < top_list.length; i++) {
			top_list[i] = new Top(i, Integer.parseInt(st.nextToken()));
		}

		for (int i = 1; i < top_list.length; i++) {
			Top currentTop = top_list[i];

			while (!top_stack.isEmpty()) {
				if (top_stack.peek().height >= currentTop.height) {
					result_list[i] = top_stack.peek().index;
					break;
				}
				top_stack.pop();
			}

			if (top_stack.isEmpty()) {
				result_list[i] = 0;
			}
			top_stack.add(currentTop);
		}

		for (int i = 1; i < result_list.length; i++) {
			System.out.print(result_list[i] + " ");
		}
	}

	static class Top {
		int index;
		int height;

		public Top(int index, int height) {
			this.index = index;
			this.height = height;
		}
	}
}

package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class swea_1218 {
	static char op(char ch) {
		switch (ch) {
		case '(':
			return ')';
		case '{':
			return '}';
		case '[':
			return ']';
		case '<':
			return '>';
		default:
			return '0';
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		final char leftSmall = '(';
		final char leftMiddle = '{';
		final char leftBig = '[';
		final char leftGuk = '<';
		final char rightSmall = ')';
		final char rightMiddle = '}';
		final char rightBig = ']';
		final char rightGuk = '>';

		for (int tc = 1; tc <= 10; tc++) {
			Stack<Character> stack = new Stack<>();

			int strLength = Integer.parseInt(br.readLine());

			char[] str_list = br.readLine().toCharArray();

			int result = 1;
			char answer_char = ' ';

			loop:
			for (int i = 0; i < str_list.length; i++) {
				if (str_list[i] == leftSmall || str_list[i] == leftMiddle || str_list[i] == leftBig
						|| str_list[i] == leftGuk) {
					stack.add(str_list[i]);
				} else {
					switch (str_list[i]) {
					case rightSmall:
						answer_char = stack.pop();
						if(answer_char != leftSmall) {
							result = 0;
							break loop;
						}
						break;
					case rightMiddle:
						answer_char = stack.pop();
						if(answer_char != leftMiddle) {
							result = 0;
							break loop;
						}
						break;
					case rightBig:
						answer_char = stack.pop();
						if(answer_char != leftBig) {
							result = 0;
							break loop;
						}
						break;
					case rightGuk:
						answer_char = stack.pop();
						if(answer_char != leftGuk) {
							result = 0;
							break loop;
						}
						break;
					}
				}
			}
			
			if(!stack.isEmpty()) {
				result = 0;
			}
			
			System.out.println("#"+ tc +" " + result);
		}
	}
}

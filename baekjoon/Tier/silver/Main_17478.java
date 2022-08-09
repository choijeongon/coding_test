package silver;

import java.util.Scanner;

public class Main_17478 {
	static int count = 0;
	static String line_one = "\"재귀함수가 뭔가요?\"";
	static String line_two = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
	static String line_three = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
	static String line_four = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
	static String feadback = "라고 답변하였지.";
	static String underBar = "____";
	
	static String realAnswer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
	
	static void chatbot(int number) {
		String line_one_answer = "";
		String line_two_answer = "";
		String line_three_answer = "";
		String line_four_answer = "";
		String feadback_answer = "";
		String realAnswer_answer = "";
		
		if(number == 0) {
			for (int i = 0; i < count; i++) {
				line_one_answer += underBar;
				realAnswer_answer += underBar;;
				feadback_answer += underBar;
			}
			
			line_one_answer += line_one;
			realAnswer_answer += realAnswer;
			feadback_answer += feadback;
			
			System.out.println(line_one_answer);
			System.out.println(realAnswer_answer);
			System.out.println(feadback_answer);
			return;
		}
		
		
		for (int i = 0; i < count; i++) {
			line_one_answer += underBar;
			line_two_answer += underBar;
			line_three_answer += underBar;
			line_four_answer += underBar;
			feadback_answer += underBar;
		}
		
		line_one_answer += line_one;
		line_two_answer += line_two;
		line_three_answer += line_three;
		line_four_answer += line_four;
		feadback_answer += feadback;
		
		System.out.println(line_one_answer);
		System.out.println(line_two_answer);
		System.out.println(line_three_answer);
		System.out.println(line_four_answer);
		count++;
		chatbot(number-1);
		System.out.println(feadback_answer);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		chatbot(N);
	}
}

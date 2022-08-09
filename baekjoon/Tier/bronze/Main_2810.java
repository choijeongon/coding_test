package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2810 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String movie_seat = br.readLine();
		
		String answer_string = "*";
		
		int count = 0;
		int answer = 0;
		
		while(!movie_seat.isEmpty()) {
			if(movie_seat.startsWith("S")) {
				answer_string += "S*";
				movie_seat = movie_seat.substring(1);
			} else if(movie_seat.startsWith("LL")) {
				answer_string += "LL*";
				movie_seat = movie_seat.replaceFirst("LL", "");
			}
		}
		
		for (int i = 0; i < answer_string.length(); i++) {
			if(answer_string.charAt(i) == '*') {
				count++;
			}
		}
		
		if(count >= N) {
			answer = N;
		} else {
			answer = count;
		}
		
		System.out.println(answer);
	}
}

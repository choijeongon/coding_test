package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2954 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String origine = br.readLine();
		String answer = "";
		
		while(!origine.isEmpty()) {
			answer += origine.charAt(0);
			if(origine.startsWith("a") || origine.startsWith("e") || origine.startsWith("i") || origine.startsWith("o") || origine.startsWith("u")) {
				origine = origine.substring(3);
			} else {
				origine = origine.substring(1);
			}
		}
		
		System.out.println(answer);
	}
}

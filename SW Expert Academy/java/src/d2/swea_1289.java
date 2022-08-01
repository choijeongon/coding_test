package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1289 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			
			int count = 0;
			
			String s = br.readLine();
			String firstValue = "";
			
			for (int i = 0; i < s.length(); i++) {
				firstValue += "0";
			}
			
			int index = 0;
			
			while(!s.equals(firstValue)) {
				if(s.charAt(index) == firstValue.charAt(index)) {
					index++;
				} else {
					firstValue = s.substring(0, index);
					
					if(s.charAt(index) == '0') {
						while(firstValue.length() < s.length()) {
							firstValue += '0';
						}
					} else if(s.charAt(index) == '1') {
						while(firstValue.length() < s.length()) {
							firstValue += '1';
						}
					}

					index++;
					count++;
				}
			}
			System.out.println("#" + tc + " " +count);
		}
	}
}
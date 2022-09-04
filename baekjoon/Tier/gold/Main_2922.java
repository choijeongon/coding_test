package gold;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2922 {
	static String originalStr;
	static char[] charList;
	
	//빈칸의 갯수
	static int R;
	
	//즐거운 단어를 만들 수 있는 경우의 수
	static int totalCount;
	
	static char[] inputList = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	static char[] numbers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		originalStr = sc.nextLine();
		
		charList = new char[originalStr.length()];
		
		charList = originalStr.toCharArray();
		
		R = 0;
		totalCount = 0;
		
		for (int i = 0; i < charList.length; i++) {
			if(charList[i] == '_') {
				R++;
			}
		}
		
		numbers = new char[R];
		
		duplicationPerm(0);
		
		System.out.println(totalCount);
	}
	
	static void duplicationPerm(int count) {
		if(count == R) {
//			System.out.println(Arrays.toString(numbers));
			
			char[] copyCharList = originalStr.toCharArray();
			
			int numbersCount = 0;
			
			for (int i = 0; i < copyCharList.length; i++) {
				//numbers 하나씩 _에 넣는다.
				if(copyCharList[i] == '_') {
					copyCharList[i] = numbers[numbersCount++];
				}
			}
			
//			System.out.println(Arrays.toString(copyCharList));
			
			//L을 포함했는가?
			String newString = new String(copyCharList);
			
			//원본 문자열이 L을 포함하지 않았을 경우만 체크
			if(!originalStr.contains("L")) {
				if(!newString.contains("L")) {
					return;
				}
			}
			
			int moCount = 0;
			int jaCount = 0;
			
			//모음 자음 체크
			for (int i = 0; i < copyCharList.length; i++) {				
				if(moCheck(copyCharList[i])) {
					moCount++;
					jaCount = 0;
				} else {
					jaCount++;
					moCount = 0;
				}
				
				if(moCount >= 3 || jaCount >= 3) {
					return;
				}
			}
			
			totalCount++;
			return;
		}
		
		for (int i = 0; i < inputList.length; i++) {
			numbers[count] = inputList[i];
			duplicationPerm(count+1);
		}
	}
	
	static boolean moCheck(char value) {
		if(value == 'A' || value == 'E' ||value == 'I' ||value == 'O' ||value == 'U') {
			return true;
		} else {
			return false;
		}
	}
}

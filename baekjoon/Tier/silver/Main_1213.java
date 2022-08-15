package silver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_1213 {
	
	static int N;
	
	static char[] hansoName;
	static char[] resultList;
	static boolean[] isSelected;
	static Set<String> set = new HashSet<String>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String hanso = sc.nextLine();
		
		hansoName = new char[hanso.length()];
		
		N = hanso.length();
		
		resultList = new char[N];
		isSelected = new boolean[N];
		
		hansoName = hanso.toCharArray();
		
		perm(0);
		
		String answer = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";
		
		if(!set.isEmpty()) {
			
			for(String value : set) {
				//0보다 큰게 더 빠른것
				if(answer.compareTo(value) > 0) {
					answer = value;
				}
			}
			
			System.out.println(answer);
		} else {
			System.out.println("I'm Sorry Hansoo");
		}
	}
	
	static void perm(int count) {
		if(count == N) {
			if(palindromeCheck(resultList)) {
//				System.out.println(Arrays.toString(resultList));
				String result = new String(resultList);
				set.add(result);
			}
			return; 
		}
		
		for (int i = 0; i < hansoName.length; i++) {
			if(isSelected[i]) {
				continue;
			}
			
			resultList[count] = hansoName[i];
			isSelected[i] = true;
			perm(count+1);
			isSelected[i] = false;
		}
	}
	
	static boolean palindromeCheck(char[] arr) {
		String original = new String(arr);
		String reverse = "";
		
		for (int i = arr.length-1; i >= 0; i--) {
			reverse += arr[i];
		}
		
		if(original.equals(reverse)) {
			return true;
		} else {
			return false;
		}
	}
}

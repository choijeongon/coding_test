package gold;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1759 {
	
	static int L;
	static int C;
	static char[] inputList;
	
	static char[] numbers;
	static boolean[] isSelected;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		C = sc.nextInt();
		
		inputList = new char[C];
		isSelected = new boolean[C];
		numbers= new char[L];
		
		for (int i = 0; i < C; i++) {
			inputList[i] = sc.next().charAt(0);
		}
		
		Arrays.sort(inputList);
		
//		System.out.println(Arrays.toString(inputList));
//		perm(0);
		comb(0, 0);
		
		System.out.println(sb);
	}
	
	static void perm(int count) {
		if(count == L) {
			if(check(numbers)) {
				for(char value : numbers) {
					sb.append(value);
//					System.out.print(value);
				}
				sb.append("\n");
//				System.out.println();
			}
			return;
		}
		
		for (int i = 0; i < C; i++) {
			if(isSelected[i]) {
				continue;
			}
			
			numbers[count] = inputList[i];
			isSelected[i] = true;
			perm(count+1);
			isSelected[i] = false;
		}
	}
	
	static void comb(int count, int start) {
		if(count == L) {
			if(check(numbers)) {
				for(char value : numbers) {
					sb.append(value);
//					System.out.print(value);
				}
				sb.append("\n");
//				System.out.println();
			}
			return;
		}
		
		for (int i = start; i < C; i++) {
			numbers[count] = inputList[i];
			comb(count+1, i+1);
		}
	}
	
	static boolean check(char[] list) {
	
		int moCount = 0;
		int jaCount = 0;
		
		for(char value : list) {
			if(moCount >= 1 && jaCount >= 2) {
				break;
			}
			
			if(value == 'a' || value == 'e' || value == 'i' || value == 'o' || value == 'u') {
				moCount++;
			} else {
				jaCount++;
			}
		}
		
		boolean sequenceCheck = true;
		
		for (int i = 0; i < list.length; i++) {
			//마지막이 아니라면
			if(i != list.length-1) {
				int currentAscill = list[i];
				int nextAscill = list[i+1];
				
				if(currentAscill > nextAscill) {
					sequenceCheck = false;
					break;
				}
			}
		}
		
		if(moCount >= 1 && jaCount >= 2 && sequenceCheck) {
			return true;
		} else {
			return false;
		}
	}
}

package test;

import java.util.Arrays;
import java.util.Scanner;

public class CombTest {
	static int N;
	static int R;
	
	static int[] resultList;
	static int[] inputList;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		
		resultList = new int[R];
		inputList = new int[N];
		
		for (int i = 0; i < inputList.length; i++) {
			inputList[i] = sc.nextInt();
		}
		//Input End
		
		comb(0, 0);
	}
	
	static void comb(int count, int start) {
		if(count == R) {
			System.out.println(Arrays.toString(resultList));
			return;
		}
		
		for (int i = start; i < inputList.length; i++) {
			resultList[count] = inputList[i];
			comb(count+1, i+1);
		}
	}
}

package test;

import java.util.Arrays;
import java.util.Scanner;

public class PermTest {

	static int N;
	static int R;
	
	static int[] resultList;
	static int[] inputList;
	static boolean[] isSelected;
	
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		
		resultList = new int[R];
		inputList = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < inputList.length; i++) {
			inputList[i] = sc.nextInt();
		}
		//Input End
		
		perm(0);
		
	}
	
	static void perm(int count) {
		if(count == R) {
			System.out.println(Arrays.toString(resultList));
			return;
		}
		
		for (int i = 0; i < inputList.length; i++) {
			if(isSelected[i]) {
				continue;
			}
			
			resultList[count] = inputList[i];
			isSelected[i] = true;
			perm(count+1);
			isSelected[i] = false;
		}
	}
}

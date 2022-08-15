package test;

import java.util.Arrays;
import java.util.Scanner;

public class SubsetTest {
	
	static int N;
	
	static int[] inputList;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		inputList = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < inputList.length; i++) {
			inputList[i] = sc.nextInt();
		}
		//Input End
		
		
		subset(0);
	}
	
	static void subset(int index) {
		if(index == N) {
			for (int i = 0; i < inputList.length; i++) {
				System.out.print(isSelected[i] ? inputList[i] : "X");
				System.out.print("\t");
			}
			System.out.println();
			
			return;
		}
		
		isSelected[index] = true;
		subset(index+1);
		isSelected[index] = false;
		subset(index+1);
		
	}

}

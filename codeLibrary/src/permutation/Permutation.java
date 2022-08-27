package permutation;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation {
	
	static int N;
	static int R;
	
	static int[] inputList;
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		
		inputList = new int[N];
		isSelected = new boolean[N];
		numbers = new int[R];
		
		for (int i = 0; i < N; i++) {
			inputList[i] = sc.nextInt();
		}
		//Input End
		
		perm(0);
	}
	
	static void perm(int count) {
		if(count == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) {
				continue;
			}
			
			numbers[count] = inputList[i];
			isSelected[i] = true;
			perm(count +1);
			isSelected[i] = false;
		}
	}
}

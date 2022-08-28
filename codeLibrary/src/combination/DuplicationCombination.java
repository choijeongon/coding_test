package combination;

import java.util.Arrays;
import java.util.Scanner;

public class DuplicationCombination {
	//뽑힐 대상들의 갯수
	static int N;
	
	//뽑아야 하는 숫자
	static int R;
	
	static int totalCount;
	
	//뽑힐 대상들의 리스트
	static int[] inputList;
	
	//뽑은 대상들을 저장해놓는 배열
	static int[] numbers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		totalCount = 0;
		
		inputList = new int[N];
		numbers = new int[R];
		
		for (int i = 0; i < N; i++) {
			inputList[i] = sc.nextInt();
		}
		//Input End
		
		comb(0, 0);
		System.out.println("총 경우의 수: " + totalCount);
	}
	
	static void comb(int count, int start) {
		if(count == R) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		
		for (int i = start; i < N; i++) {
			numbers[count] = inputList[i];
			comb(count+1, i);
		}
	}
}

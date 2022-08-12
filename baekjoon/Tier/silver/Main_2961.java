package silver;

import java.util.Scanner;

public class Main_2961 {
	static int N;
	static int[] sinList;
	static int[] ssonList;
	static boolean[] isSelected;
	
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		min = Integer.MAX_VALUE;
		
		sinList = new int[N];
		ssonList = new int[N];
		
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			sinList[i] = sc.nextInt();
			ssonList[i] = sc.nextInt();
		}
		//input
		
//		System.out.println(Arrays.toString(sinList));
//		System.out.println(Arrays.toString(ssonList));
		
		subset(0);
		
		//output
		System.out.println(min);
	}
	
	static void subset(int index) {
		if(index == N) {
			int sinScore = 1;
			int ssonScore = 0;
			
			boolean kong = true;
			
//			System.out.println(Arrays.toString(isSelected));
			
			//공집합 검사
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					kong = false;
				}
			}
			
			if(kong) {
				return;
			}
			
			for (int i = 0; i < N; i++) {
				if(isSelected[i]) {
					sinScore *= sinList[i];
					ssonScore += ssonList[i];
				}
			}
//			System.out.println("sinScore: " + sinScore);
//			System.out.println("ssonScore: " + ssonScore);
			int differnt = Math.abs(sinScore - ssonScore);
			
			min = Math.min(min, differnt);
			return;
		}
		
		isSelected[index] = true;
		subset(index+1);
		isSelected[index] = false;
		subset(index+1);
	}
}

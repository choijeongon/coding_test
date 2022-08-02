package d3;

import java.util.Scanner;

public class swea_1208 {
	
	static int max; 
	static int min;
	
	static int maxIndex;
	static int minIndex;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			
			int dumpCount = sc.nextInt();
			
			int answer = 0;
			
			int[] boxList = new int[100];
			
			for (int index = 0; index < 100; index++) {
				boxList[index]= sc.nextInt();
			}
			
			while(dumpCount >= 0) {
				max = 0;
				min = 100;
				
				maxIndex = -1;
				minIndex = -1;
				//MAX, MIN 찾기
				for (int i = 0; i < boxList.length; i++) {
					if(boxList[i] > max) {
						max = boxList[i];
						maxIndex = i;
					}
					
					if(boxList[i] < min) {
						min = boxList[i];
						minIndex = i;
					}
				}
				boxList[maxIndex]--;
				boxList[minIndex]++;
				dumpCount--;
			}
			
			answer = boxList[maxIndex] - boxList[minIndex] +2;
			
			System.out.println("#"+tc+" "+ answer);
		}
	}
}

package bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Main_20361 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//컵의 갯수
		int N = sc.nextInt();
		// 처음 숨겨둔 공의 위치
		int X = sc.nextInt();
		// 몇번 컵을 바꾸는지
		int K = sc.nextInt();
		
		int[] cup_list = new int[N];
		int[][] transfer_list = new int[K][2];
		
		cup_list[X-1] = 1;
		
		for (int i = 0; i < K; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int[] temp_list = new int[2];
			temp_list[0] = a;
			temp_list[1] = b;
			
			transfer_list[i] = temp_list;
		}
		
		for(int[] li : transfer_list) {
			int temp = cup_list[li[0]-1];
			cup_list[li[0]-1] = cup_list[li[1]-1];
			cup_list[li[1]-1] = temp;
		}
		
		for (int i = 0; i < cup_list.length; i++) {
			if(cup_list[i] == 1) {
				System.out.println(i+1);
			}
		}
	}
}

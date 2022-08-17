package test;

import java.util.Scanner;

public class Main {
	static int N;
	static long ans;
	static Ingredient[] ingredients;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		 N = sc.nextInt();
		 
		 ingredients = new Ingredient[N];
		 
		 for (int i = 0; i < N; i++) {
			ingredients[i] = new Ingredient(sc.nextInt(), sc.nextInt()); // 신맛, 쓴맛
		}
		 
		 ans = Long.MAX_VALUE;
		 subset();
		 
		 System.out.println(ans);
	}
	
	private static void subset() {
//		for (int select = 0; select < Math.pow(2, N); select++) { // 2^N
		for (int select = 0; select < (1<<N); select++) { 
			for (int idx = 0; idx < N; idx++) {
				if(((1<<idx)&select) > 0) { //해당 자리의 bit가 1이면 부분 집합에 idx번 재료가 포함되었구나!
					
				}
			}
			// idx를 N만큼 돌려서 재료 포함여부로 신만 쓴맛 계산 했으면
		}
	}

	static class Ingredient{
		int bitter;
		int sour;
		
		public Ingredient(int s, int b) {
			sour = s;
			bitter = b;
		}
	}
}
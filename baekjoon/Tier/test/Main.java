package test;

import java.util.Arrays;
import java.util.Scanner;

/*
N개의 화학 물질 c1...cn
ci마다 최저 보관 온도 xi와 최고 보관 온도 yi
xi <= ci <= yi

 여러 대의 냉장고 가능하면 적은 수의 냉장고
 1 <= N <= 100
 
 -270 ~ 10000
*/

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		ChemicalSubstance[] chemicalSubstanceList = new ChemicalSubstance[N];

		for (int i = 0; i < N; i++) {
			chemicalSubstanceList[i] = new ChemicalSubstance(sc.nextInt(), sc.nextInt());
		}
		// Input End

		// 정렬
		Arrays.sort(chemicalSubstanceList);

//		System.out.println(Arrays.toString(chemicalSubstanceList));
		int count = 1;
		
		// 첫 번째 최대 온도
		int refrigeratorTemperature = chemicalSubstanceList[0].maxTemperature;
		
		for (int i = 1; i < chemicalSubstanceList.length; i++) {
			ChemicalSubstance currentChemicalSubstance = chemicalSubstanceList[i];
			
			if(refrigeratorTemperature < currentChemicalSubstance.minTemperature) {
				count++;
				refrigeratorTemperature = currentChemicalSubstance.maxTemperature;
			}
		}
		
		System.out.println(count);
	}

	static class ChemicalSubstance implements Comparable<ChemicalSubstance> {
		int minTemperature;
		int maxTemperature;

		public ChemicalSubstance(int minTemperature, int maxTemperature) {
			this.minTemperature = minTemperature;
			this.maxTemperature = maxTemperature;
		}

		@Override
		public String toString() {
			return "ChemicalSubstance [minTemperature=" + minTemperature + ", maxTemperature=" + maxTemperature + "]\n";
		}

		@Override
		public int compareTo(ChemicalSubstance o) { //최저 온도 기준 오름차순, 최저 온도가 같다면 최고 온도 기준 오름차순
			return this.maxTemperature != o.maxTemperature ? this.maxTemperature - o.maxTemperature
					: this.minTemperature - o.minTemperature;
		}
	}
}

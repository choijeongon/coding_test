package d3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_5215 {
	static int N, L;
	static boolean[] isSelected;
	static List<Ingredient[]> resultList = new ArrayList<>();
	static int MaxValue;
	static Ingredient[] ingredientList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt();
			L = sc.nextInt();
			MaxValue = 0;

			ingredientList = new Ingredient[N];

			isSelected = new boolean[N];

			for (int i = 0; i < N; i++) {
				int score = sc.nextInt();
				int calorie = sc.nextInt();
				ingredientList[i] = new Ingredient(score, calorie);
			}
			
			resultList = new ArrayList<>();

			subset(0);

			// 부분집합 리스트
			for (int i = 0; i < resultList.size(); i++) {
				Ingredient[] currentJohap = new Ingredient[N];
				currentJohap = resultList.get(i);

				int addAllScore = 0;
				int addAllCalorie = 0;

				for (int j = 0; j < currentJohap.length; j++) {
					if(currentJohap[j] != null) {
						addAllCalorie += currentJohap[j].calorie;
						addAllScore += currentJohap[j].score;
					}
				}

				MaxValue = Math.max(MaxValue, addAllScore);
			}
			System.out.println("#" + tc + " " + MaxValue);
		}
	}

	private static void subset(int index) {
		if (index == N) {
			Ingredient[] numbers = new Ingredient[N];
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					numbers[i] = ingredientList[i];
				}
			}

			int sumCal = 0;

			for (int i = 0; i < numbers.length; i++) {
				if(numbers[i] != null) {
					sumCal += numbers[i].calorie;
				}
			}
			
			//최대값보다 작은 친구들만 리스트에 넣기
			if (sumCal <= L) {
				resultList.add(numbers);
			}

			return;
		}

		// 원소 선택
		isSelected[index] = true;
		subset(index + 1);
		// 원소 미선택
		isSelected[index] = false;
		subset(index + 1);
	}

	static class Ingredient {
		int score;
		int calorie;

		public Ingredient(int score, int calorie) {
			this.score = score;
			this.calorie = calorie;
		}

		@Override
		public String toString() {
			return "Ingredient [score=" + score + ", calorie=" + calorie + "]";
		}
	}
}

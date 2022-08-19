package d5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_1247 {
	static int N;

	static boolean[] isSelected;
	static Position[] numbers;
	static Position[] customerList;
	static int minDistance;

	static int companyX;
	static int companyY;

	static int houseX;
	static int houseY;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			int customerNumber = sc.nextInt();

			N = customerNumber;
			isSelected = new boolean[N];
			numbers = new Position[N];

			companyX = sc.nextInt();
			companyY = sc.nextInt();

			houseX = sc.nextInt();
			houseY = sc.nextInt();

			minDistance = Integer.MAX_VALUE;

			customerList = new Position[customerNumber];

			for (int index = 0; index < customerNumber; index++) {
				customerList[index] = new Position(sc.nextInt(), sc.nextInt());
			}

			perm(0);

			System.out.println("#" + tc + " " + minDistance);
		}
	}

	static void perm(int count) {
		if (count == N) {
			Position[] tempList = new Position[N];

			for (int i = 0; i < N; i++) {
				tempList[i] = new Position(numbers[i].x, numbers[i].y);
			}

			// 회사 -> 고객들 -> 우리 집 방문하는 거리 구하기
			int totalDistance = 0;

			// 회사 -> 첫 고객 거리
			totalDistance += getDistance(companyX, companyY, numbers[0].x, numbers[0].y);

			// 고객들 집 + 우리 집 거리 더하기
			for (int j = 0; j < numbers.length; j++) {
				// 마지막 고객 집 이라면 우리 집 더하기
				if (j == numbers.length - 1) {
					totalDistance += getDistance(numbers[j].x, numbers[j].y, houseX, houseY);
				} else {
					totalDistance += getDistance(numbers[j].x, numbers[j].y, numbers[j + 1].x, numbers[j + 1].y);
				}
			}

			minDistance = Math.min(minDistance, totalDistance);
//				System.out.println(Arrays.toString(currentList));

			return;
		}

		for (int i = 0; i < N; i++) {
			// 이미 사용중이면
			if (isSelected[i]) {
				continue;
			}

			numbers[count] = customerList[i];
			isSelected[i] = true;
			perm(count + 1);
			isSelected[i] = false;
		}
	}

	static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	static class Position {
		int x;
		int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + "]";
		}

	}
}

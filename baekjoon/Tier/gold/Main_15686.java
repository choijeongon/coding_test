package gold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_15686 {
	static int N;
	static int M;
	static int[][] city;
	static List<House> houseList = new ArrayList<>();
	static List<Chicken> chickenHouseList = new ArrayList<>();
	static int min;

	static Chicken[] chicken_comb;
	static List<Chicken[]> chicken_comb_list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		
		min = Integer.MAX_VALUE;

		city = new int[N][N];

		chicken_comb = new Chicken[M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				city[i][j] = sc.nextInt();

				// 치킨집 더하기
				if (city[i][j] == 2) {
					chickenHouseList.add(new Chicken(i, j));
				}

				// 집 더하기
				if (city[i][j] == 1) {
					houseList.add(new House(i, j));
				}
			}
		}
		// input End

//        for(int[] list : city) {
//            System.out.println(Arrays.toString(list));
//        }
//        System.out.println("-----------------------");
//        
//        for(Chicken chicken : chickenHouseList) {
//            System.out.println(chicken);
//        }
//        
//        System.out.println("-----------------------");
//        
//        for(House house : houseList) {
//        	System.out.println(house);
//        }

		// 폐업 시키지 않을 치킨집의 조합 구하기
		comb(0, 0);
		
        // 각각의 치킨집 조합에서 도시의 치킨 거리가 최소인것을 찾는다. 
		for (int johapIndex = 0; johapIndex < chicken_comb_list.size(); johapIndex++) {
			Chicken[] current_chicken_comb = chicken_comb_list.get(johapIndex);

			int currentChickenDistance = 0;

			// 해당 조합에서 모든 집의 치킨 거리를 구해서 더한다. -> 도시의 치킨 거리
			for (int index = 0; index < houseList.size(); index++) {
				House currentHouse = houseList.get(index);

				int currentHouseChickenDistance = Integer.MAX_VALUE;

				// 현재 조합의 모든 치킨집과의 치킨 거리를 구한 값의 최소값이 해당 집의 치킨 거리이다.
				for (int i = 0; i < current_chicken_comb.length; i++) {
					currentHouseChickenDistance = Math.min(currentHouseChickenDistance, getChickenDistance(
							currentHouse.x, currentHouse.y, current_chicken_comb[i].x, current_chicken_comb[i].y));
				}
				
				currentChickenDistance += currentHouseChickenDistance;
			}
			
			min = Math.min(min, currentChickenDistance);

		}

		// output
        System.out.println(min);
	}

	static int getChickenDistance(int houseX, int houseY, int chickenX, int chickenY) {
		int chickenDistance = Math.abs(houseX - chickenX) + Math.abs(houseY - chickenY);

		return chickenDistance;
	}

	static void comb(int count, int start) {
		// 기저 조건
		if (count == M) {
//			System.out.println(Arrays.toString(chicken_comb));
			Chicken[] temp_comb = new Chicken[M];

			for (int i = 0; i < chicken_comb.length; i++) {
				temp_comb[i] = new Chicken(chicken_comb[i].x, chicken_comb[i].y);
			}

			chicken_comb_list.add(temp_comb);
			return;
		}

		for (int i = start; i < chickenHouseList.size(); i++) {
			chicken_comb[count] = chickenHouseList.get(i);
			comb(count + 1, i + 1);
		}
	}

	static class House extends Building {
		public House(int x, int y) {
			super(x, y);
		}

		@Override
		public String toString() {
			return "House [x=" + x + ", y=" + y + "]";
		}
	}

	static class Chicken extends Building {
		public Chicken(int x, int y) {
			super(x, y);
		}

		@Override
		public String toString() {
			return "Chicken [x=" + x + ", y=" + y + "]";
		}
	}

	static class Building {
		int x;
		int y;

		public Building(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
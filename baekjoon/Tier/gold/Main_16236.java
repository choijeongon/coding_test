package gold;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_16236 {
	static int sharki;
	static int sharkj;
	static int sharkEat;
	static int sharkSize;

	static int N;
	static int[][] map;
	static boolean[][] visit; // 먹이 탐색하면서 큐에 중복칸 들어가지 말라고 쓸 배열
	static int ans;

	static int[] di = { 0, 0, 1, -1 };
	static int[] dj = { 1, -1, 0, 0 };

	static class Point implements Comparable<Point> {
		int i;
		int j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public int compareTo(Point o) {
			if (this.i == o.i) {
				return this.j - o.j;
			}
			return this.i - o.i;

//			if (this.i > o.i) {
//				return +1;
//			} else if (this.i < o.i) {
//				return -1;
//			} else {
//				if (this.j > o.j) {
//					return +1;
//				} else if (this.j < o.j) {
//					return -1;
//				}
//			}
//			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();

				if (map[i][j] == 9) { // 초기 상어 위치
					sharki = i;
					sharkj = j;
					sharkSize = 2; // 초기 크기
					sharkEat = 0;
					map[i][j] = 0; // 상어 공중부양.
				}
			}
		} // end Input

		while (true) {
			if (!findFeed()) { // 먹이 찾는데 실패하면
				break;
			}
		}

		System.out.println(ans);
	}

	static boolean findFeed() { // 상어 위치에서 탐색 시작
		Queue<Point> queue = new LinkedList<>();
		visit = new boolean[N][N];

		queue.offer(new Point(sharki, sharkj));
		visit[sharki][sharkj] = true;

		int dist = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			PriorityQueue<Point> feed = new PriorityQueue<>();

			for (int s = 0; s < size; s++) {
				Point now = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nexti = now.i + di[d];
					int nextj = now.j + dj[d];

					if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N) {
						if (map[nexti][nextj] > 0 && map[nexti][nextj] < sharkSize) { // 먹이다!
							feed.add(new Point(nexti, nextj));
						}
						if ((map[nexti][nextj] == 0 || map[nexti][nextj] == sharkSize) && !visit[nexti][nextj]) {
							queue.add(new Point(nexti, nextj));
							visit[nexti][nextj] = true;
						}
					}
				}
			}
			if (!feed.isEmpty()) {
				Point f = feed.poll();
				sharkEat++;
				map[f.i][f.j] = 0; // 해당 먹이 먹고
				sharki = f.i; // 먹이 위치로 이동
				sharkj = f.j;

				if (sharkEat == sharkSize) { // 상어 성장
					sharkSize++;
					sharkEat = 0;
				}
				ans += dist + 1; // 이번 먹이를 먹느라 움직인 거리
				return true;
			}
			dist++;
		}

		return false;
	}
}

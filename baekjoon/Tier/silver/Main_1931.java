package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1931 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] meetingList = new int[N][];
		
		StringTokenizer st;

		for (int i = 0; i < meetingList.length; i++) {
			st = new StringTokenizer(br.readLine());
			int startTime = Integer.parseInt(st.nextToken());
			int lastTime = Integer.parseInt(st.nextToken());

			int[] time = new int[] { startTime, lastTime };

			meetingList[i] = time;
		}
		
		Arrays.sort(meetingList, new Comparator<int[]>() {
		    @Override
			public int compare(int[] o1, int[] o2) {
		    	return o1[1]-o2[1];
	           }
	        });
		
//		for (int i = 0; i < meetingList.length; i++) {
//			System.out.println(Arrays.toString(meetingList[i]));
//		}

		int count = 1;
		int searchedIndex = 0;

		int minEndTime = meetingList[0][1];

		loop: while (true) {
			boolean search = false;
			int currentMinEndTime = meetingList[N-1][1]+1;

			for (int i = searchedIndex; i < meetingList.length; i++) {
				int startTime = meetingList[i][0];
				int endTime = meetingList[i][1];

				// 이전에 회의가 끝났던 시간 이후 가장 먼저 끝나는 회의 찾기
				if (startTime >= minEndTime) {
					currentMinEndTime = Math.min(currentMinEndTime, endTime);
					//이전에 찾았던 애들은 다시 찾지 않음
					searchedIndex = i;
					search=true;
					break;
				}
			}

			if (!search) {
				break loop;
			} else {
				minEndTime = currentMinEndTime;
				count++;
			}

		}
		System.out.println(count);
	}
}

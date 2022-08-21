package silver;

import java.util.Scanner;

public class Main_11286 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		int arrSize = 0;
		
		for (int i = 0; i < N; i++) {
			int value = sc.nextInt();
			
			if(value != 0) {
				arr[arrSize] = value;
				arrSize++;
			} else if(value == 0) {
				int minValue = Integer.MAX_VALUE;
				int minIndex = -1;
				
				// 값이 없다면
				if(arrSize == 0) {
					System.out.println("0");
				} else {
					//값이 있다면
					for (int index = 0; index < arrSize; index++) {
						int currentValue = Math.abs(arr[index]);
						
						//현재 인덱스의 절대 값이 minValue 보다 작다면
						if(currentValue < minValue) {
							minValue = currentValue;
							minIndex = index;
						}
						
						//두 수의 절대값이 같을 경우
						if(currentValue == minValue) {
							//arr[index]가 작으면
							if(minValue > arr[index]) {
								minValue = currentValue;
								minIndex = index;
							}
						}
					}
					System.out.println(arr[minIndex]);
					//swap - 현재 min값 인덱스랑 값이 존재하는 인덱스
					arr[minIndex] = arr[arrSize-1];
					
					arrSize--;
				}
				
				
			}
		}

	}
}

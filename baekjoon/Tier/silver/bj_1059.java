package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class bj_1059 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N  =stoi(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i]= stoi(st.nextToken());	
		}
		st = new StringTokenizer(in.readLine());
		int M = stoi(st.nextToken());
		Arrays.sort(arr);
		int left=0, right=987654321;
		boolean find=false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]>M) {
				right=Math.min(right, arr[i]);
			}else if(arr[i]<M){
				left=Math.max(left, arr[i]);
			}else {
				find=true;
				break;
			}
		}
		int L = (M-left-1);
		int R = (right-M-1);
		int answer = L + R +(L*R);
		if(find)
			System.out.println(0);
		else
			System.out.println(answer);
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}

//public class bj_1059 {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		int L = Integer.parseInt(st.nextToken());
//
//		int[] list = new int[L];
//		
//		st = new StringTokenizer(br.readLine());
//
//		for (int i = 0; i < L; i++) {
//			list[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		st = new StringTokenizer(br.readLine());
//
//		int n = Integer.parseInt(st.nextToken());
//
//		int count = 0;
//
//		int minNearLowerValue = Integer.MIN_VALUE;
//		int maxNearUpperValue = Integer.MAX_VALUE;
//
//		boolean equ = false;
//		
//		Arrays.sort(list);
//
//		for (int i = 0; i < list.length; i++) {
//			if (list[i] == n) {
//				equ = true;
//				break;
//			}
//
//			if (list[i] < n) {
//				minNearLowerValue = Math.max(minNearLowerValue, list[i]);
//			}
//
//			if (list[i] > n) {
//				maxNearUpperValue = Math.min(maxNearUpperValue, list[i]);
//			}
//		}
//		
//
//		if (!equ) {
//			int Left = (n-minNearLowerValue-1);
//			int Right = (maxNearUpperValue - n -1);
//			count = Left+Right + (Left*Right);
//		}
//		System.out.println(count);
//	}
//}

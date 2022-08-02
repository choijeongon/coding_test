package day0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class swea_2805 {
	static char[][] parm;
	static int center;
	static int sum;
	
	static int searchCenterToEndDistance (int num) {
		int distance = 0;
		for (int i = 1; i < num; i+= 2) {
			distance++;
		}
		return distance;
	}
	
	static void getOneRowUP(int count) {
		if(count==0) {
			sum += (parm[0][center] - '0');
			return;
		}
		
		int start = center-count;
		int end = center+count;
		
		for (int i = start; i <= end; i++) {
			sum += (parm[count][i] - '0');
		}
		
		getOneRowUP(count-1);
	}
	
	static void getOneRowDown(int count, int endCheck) {
		if(endCheck==parm.length-1) {
			sum += (parm[parm.length-1][center] - '0');
			return;
		}
		
		int start = center-count;
		int end = center+count;
		
		for (int i = start; i <= end; i++) {
			sum += (parm[endCheck][i] - '0');
		}
		
		getOneRowDown(count-1, endCheck+1);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder(); 
		
		for (int testCaseNumber = 1; testCaseNumber <= T; testCaseNumber++) {
			int parmSize = Integer.parseInt(br.readLine());
			
			parm = new char[parmSize][parmSize];
			
			for (int i = 0; i < parm.length; i++) {
				parm[i] = br.readLine().toCharArray();
			}
			//여기까지 입력
			
			//입력 디버깅
//			System.out.println("parmSize: " + parmSize);
//			
//			for (int i = 0; i < parm.length; i++) {
//				System.out.println(Arrays.toString(parm[i]));
//			}
			///
			
			center = searchCenterToEndDistance(parmSize);
			sum = 0;
			
			//중앙 열 포함 위에 값 더하기
			getOneRowUP(center);
			
			//중앙 열 포함 아래값 더하기
			getOneRowDown(center, center);
			
			//중앙 열이 두번 더해졌으므로 빼기
			for (int i = 0; i < parm.length; i++) {
				sum -= (parm[center][i] - '0');
			}
			
			sb.append("#" + testCaseNumber + " " + sum +"\n");
		}
		System.out.println(sb);
	}
}

package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_1244 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int switchNumber = Integer.parseInt(br.readLine());
		switchNumber += 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] switchList = new int[switchNumber];
		
		for (int i = 1; i < switchNumber; i++) {
			switchList[i] = Integer.parseInt(st.nextToken());
		}
		
		int studentNumber = Integer.parseInt(br.readLine());
		
		int[][] studentSwitchNumberList = new int[studentNumber][];
		
		for (int i = 0; i < studentSwitchNumberList.length; i++) {
			st = new StringTokenizer(br.readLine());
			
			int[] temp_list = new int[2];
			temp_list[0] = Integer.parseInt(st.nextToken());
			temp_list[1] = Integer.parseInt(st.nextToken());
			
			studentSwitchNumberList[i] = temp_list;
		}
		
		//로직 구현
		for (int i = 0; i < studentSwitchNumberList.length; i++) {
			int gender = studentSwitchNumberList[i][0];
			int key = studentSwitchNumberList[i][1];
			
			//남자라면
			if(gender == 1) {
				//key의 배수로
				for(int j = key; j<switchNumber; j+=key) {
					switchList[j] = switchList[j] == 1 ? 0 : 1;
//					switchList[j]^=1;
				}
			}
			else if(gender == 2){
				int left = key-1;
				int right = key+1;
				
				while(true) {//대칭 찾아서
					if(left<1 || right>= switchNumber)
					{
						break;
					}
					if(switchList[left] != switchList[right]) {
						break;
					}
					left--; 
					right++;
				}
				left++; 
				right--;
				
				while(left<=right) {
					switchList[left] = switchList[left] == 1 ? 0 : 1;
//					switchList[left] ^=1;
					left++;
				}
			}
		}
		
		for (int i = 1; i < switchList.length; i++) {
			System.out.print(switchList[i] + " ");
			if(i%20==0) {
				System.out.println();
			}
		}
	}
}

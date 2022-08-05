package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_12891 {
	static char[] DNA_LIST; // 순열 재료
	static int[] DNA_COUNT;
	static int PART_LENGTH;
	
    public static int convert(char c) {
        switch(c) {
        case 'A' : return 0;
        case 'C' : return 1;
        case 'G' : return 2;
        case 'T' : return 3;
        default : return -1;
        }
    }
    
    public static boolean confirmPassword(int[] list) {
        for(int i=0;i<4;i++) {
        	// 입력받은 문자의 카운팅 숫자가 최소 숫자보다 작으면 Fail
            if(DNA_COUNT[i]>list[i]) {
            	return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int answer = 0;

		int DNA_LENGTH = Integer.parseInt(st.nextToken());
		PART_LENGTH = Integer.parseInt(st.nextToken());

		DNA_LIST = br.readLine().toCharArray();
		DNA_COUNT = new int[4];
		// 0번째 A, 1번째 C, 2번째 G, 3번째 T COUNT 저장
		int[] CheckPassword = new int[4]; 

		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 4; i++) {
			DNA_COUNT[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = 0; i < PART_LENGTH; i++) { //초기 비교값 넣어주기
			CheckPassword[convert(DNA_LIST[i])]++;
		}
		
//		System.out.println(Arrays.toString(CheckPassword));
		
		if(confirmPassword(CheckPassword)) {
			answer++;
		}
		
		for (int p = 0; p < (DNA_LENGTH - PART_LENGTH); p++) {
			CheckPassword[convert(DNA_LIST[p])]--;
			CheckPassword[convert(DNA_LIST[p+PART_LENGTH])]++;
			
			if(confirmPassword(CheckPassword)) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}
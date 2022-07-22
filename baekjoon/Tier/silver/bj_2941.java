package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2941 {
		
	static String[] croatia_list = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String value = br.readLine();
		
		int count = 0;
		
		while(!value.isEmpty()) {
			boolean hasCroatian = false;
			for (String croatian : croatia_list) {
				if(value.startsWith(croatian)) {
					value = value.replaceFirst(croatian, "");
					count++;
					hasCroatian = true;
					break;
				}
			}
			
			if (!hasCroatian) {
				value = value.substring(1);
				count++;
			}
		}

		System.out.println(count);
	}
}

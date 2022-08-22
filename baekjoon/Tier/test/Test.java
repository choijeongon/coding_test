package test;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
	
	public static void main(String[] args) {
		ABS[] list = new ABS[3];
		
		list[0] = new ABS(10);
		list[1] = new ABS(5);
		list[2] = new ABS(13);
		
		
		
		System.out.println(Arrays.toString(list));
	}
	
	static class ABS implements Comparator<ABS>{
		int value;

		public ABS(int value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return Integer.toString(value);
		}

		@Override
		public int compare(ABS o1, ABS o2) {
			return o1.value - o2.value;
		}

//		@Override
//		public int compareTo(ABS o) {
//			return this.value - o.value;
//		}
	}
}

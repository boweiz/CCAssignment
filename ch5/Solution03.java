package cc555;

public class Solution03 {
	
	
	// print
	static void print(int result) {
		
		for ( int k=0; k<32; k++) {
			System.out.print(((result & 0x80000000) >> 31));
			result = result << 1;
		}
		System.out.println("");
			
	}

	static int maxLength = 32;
	
	// main function, to find the longest sequence
	static int longest(int n) {
		
		int max = 0;
		
		// flip bit at every position
		for (int i=0; i<maxLength; i++) {
			
			max = Math.max(max, flipMax(n, i));
		}
		
		return max;
		
	}

	// flip the bit at the index position and count the longest sequence
	static int flipMax(int n, int index) {
		int max = 0;
		int count = 0;
		
		for (int k=0; k<maxLength; k++) {
			// we count either k=index or this bit value equals to 1
			if (k == index || getBit(n, k)) {
				count++;
				// store max value
				max = Math.max(max, count);
				
			} else {
				count = 0;
			}
			
		}
	
		return max;
				
	}
	
	// to determine if the bit value is 1.
	static boolean getBit(int n, int index) {
		
		return (n & (1 << index)) != 0;
		
	}

	
	public static void main(String[] args) {
		int in = 5;
		int result = longest(in);
		print(in);
		System.out.println("longest sequence: "+result);	

	}

}

package cc555;

public class Solution04 {
	
	/* the way I use to find the next smallest number is that
	 * first, we find the first 0 digit from the back, and then find the first 1 digit
	 * ahead of 0 digit we find before, and change it to 0, and << the n
	 * then we just put proper number of 1 just after the 0 digit we have fliped.
	 */
	
	
	static int nextSmallest (int n) {
		
		int count1 = 0;
		int count0 = 0;
		
		
		
		
		for (; (n & 1) != 0 && count0 < 32; n = n >> 1, count0++);
		
		count1 = count0;
		for (; (n & 1) != 1 && count1 < 32; n = n >> 1, count1++);
		
		if (count1 == 31) return -1;   //can not find

		n = n >> 1;
		n = n << (count1 + 1);
		
		// d stands for how many 1 need to add just after the 0
		int d = count0 + 1;
		int c = 1 << (count1 - 1);
		
		for (int k=0; k<d; k++) {
			
			n = n | c;
			c = c >> 1;		
		}
		
		return n;	
		
	}
	
	/* the way I use to find the next largest number is that
	 * first, we find the first 1 digit from the back, and then find the first 0 digit
	 * ahead of 1 digit we find before, and change it to 1, and << the n
	 * then we just put proper number of 1 from the back of the n.
	 */
	
	static int nextLargest (int n) {
		
		int count1 = 0;
		int count0 = 0;
		
		for (; (n & 1) != 1 && count1 < 32; n = n >> 1, count1++);
		
		count0 = count1;
		for (; (n & 1) != 0 && count0 < 32; n = n >> 1, count0++);
		
		if (count0 == 31) return -1;   //can not find

		n |= 1;
		n = n << count0;

		// d stands for how many 1 need to add to the bottom
		int d = count0 - count1 - 1;
		int c = 1;
		for (int k=0; k<d; k++) {
			n = n | c;
			c = c << 1;		
		}
		
		return n;	
		
	}
	
	// print
	static void print(int result) {
		
		for ( int k=0; k<32; k++) {
			System.out.print(((result & 0x80000000) >> 31));
			result = result << 1;
		}
		System.out.println("");
			
	}
	
	public static void main(String[] args) {
		int n = 0x6E;
		int result1 = nextLargest(n);
		int result2 = nextSmallest(n);
		System.out.println("the original one:");
		print(n);
		System.out.println("the next largest:");
		print(result1);
		System.out.println("the next smallest:");
		print(result2);
	}

}

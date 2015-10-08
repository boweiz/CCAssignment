package cc555;

public class Solution06 {

	static int conversion(int a, int b) {
		
		// to get the different digits between a and b.
		int c = a ^ b;
		int count = 0;
		
		// use n & (n-1) == 0 to check how many n is power of 2, which is the number of bits we need to flip
		while (c > 0) {
			c = c & (c & (c - 1));
			count++;			
		}
		
		return count;
	}
	
	
	public static void main(String[] args) {
		int a = 29;
		int b = 15;
		int c = conversion(a, b);
		System.out.println(c);

	}

}

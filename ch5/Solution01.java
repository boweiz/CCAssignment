package cc555;

public class Solution01 {
	
	
	static int insertion(int n, int m, int j, int i) {
		
		// create mask
		int allOnes = ~0;
		int left = allOnes << (j + 1);
		int right = ((1 << i) - 1);
		
		int mask = left | right;
		
		// clear n
		n = mask & n;
		m = m << i;
		// merge m into n
		n = n | m;
	
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
		
		int n = 0x400;
		int m = 0x13;
		
		System.out.println(n+" binary representation:");
		print(n);
		
		System.out.println(m+" binary representation:");
		print(m);
		int i = 2;
		int j = 6;
		
		int result = insertion(n, m, j, i);
		

		System.out.println("merge result: "+result+" binary representation:");		
		print(result);
		//System.out.println(result);
	}

}

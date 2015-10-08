package cc555;

public class Solution07 {

	
	// print
	static void print(int result) {
		
		for ( int k=0; k<32; k++) {
			System.out.print(((result & 0x80000000) >> 31));
			result = result << 1;
		}
		System.out.println("");
			
	}
	
	static int pairwiseSwap(int a) {
		// we get the odd bits by using a & 0xaaaaaaaa
		// and get the even bits by using a & 0x55555555
		// and >>>, << them separatively 
		return ((a & 0xaaaaaaaa) >>> 1 | (a & 0x55555555) << 1);
	
	}
	public static void main(String[] args) {
		int a = 7;
		int result = pairwiseSwap(a);
		print(a);
		print(result);
		System.out.println(result);
		
	}
	
	
	
	
	

}

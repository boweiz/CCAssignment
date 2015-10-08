package cc555;

public class Solution05 {

	
	public static void main(String[] args) {
		
		/*
		n & (n-1) == 0 means n and (n-1) never share a 1,
		if     n = abcde1000
		then n-1 = abcde0111
		n & (n-1) == 0 only if abcde = 00000
		so n must looks like :000001000, etc.
		so n is therefore a power of two.
		
		thus, ((n & (n-1)) == 0) is to check if n is a power of 2 (or if n is 0)
		*/
		
		int n = 0;
		
		System.out.println(n-1);
		System.out.println((n & (n-1)) == 0);

	}
}

package ccc10;

public class Solution11 {

	static void peakValley(int[] input) {
		
		int i = 1;
		
		// when input.length is less than 2, return
		if (input.length < 2) return;
		
		for (; i<input.length-1; i = i + 2) {
			if (input[i-1] < input[i] || input[i] > input[i+1]) {
				
				if (input[i-1] < input[i+1]) swap(input, i-1, i);
				else swap(input, i+1, i);
				
			}		
		}
		
		// if there are even numbers of elements
		if (i < input.length) {
			if (input[i-1] < input[i]) swap(input, i-1, i);
		}
		
	}
	
	
	// swap method
	public static void swap(int[] input, int a, int b) {
		
		int tmp = input[a];
		
		input[a] = input[b];
		input[b] = tmp;
		
	}
	
	public static void main(String[] args) {
		int[] input = {3, 7, 8, 5};
		peakValley(input);
		
		for (int i=0; i<input.length; i++) {
			System.out.print(input[i]);
			System.out.print("  ");		
		}

	}

}

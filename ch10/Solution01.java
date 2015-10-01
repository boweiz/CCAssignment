package ccc10;

public class Solution01 {
	
	static int[] sortedMerge(int[] A, int[] B) {
		
		int length1 = A.length;
		int length2 = B.length;
		int i = length1 - 1;
		int j = length2 - 1;
		
		// get the last element in A
		for (; i >= 0; i--) {
			if (A[i] != 0) {
				break;		
			}
		}
		
		// merge B into A from the back		
		for (int k = length2 + i; k >= 0 && j >= 0; k--) {
			if (A[i] > B[j]) {
				A[k] = A[i];
				i--;
			} else {
				A[k] = B[j];
				j--;
			}				
		}
		
		return A;
				
	}

	public static void main(String[] args) {
		
		int[] A = {1, 3, 4, 8, 0, 0, 0};
		int[] B = {2, 5, 7};
		
		int[] C = sortedMerge(A, B);
		for(int i = 0; i < C.length; i++) {
			System.out.print(C[i]+" ");	
			
		}
		
	}

}

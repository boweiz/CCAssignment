package ccc10;

public class Solution09 {

	
	static int[] sortedMatrixSearch(int[][] matrix, int key) {
		
		int m = matrix.length;
		int n = matrix[0].length;
		int row = 0;
		int column = n - 1;
		
		int[] result = new int[2];
		
		while (row <= m - 1 && column >= 0) {
			
			if (matrix[row][column] == key) {
				
				result[0] = row;
				result[1] = column;
				return result;
			}
			
			if (matrix[row][column] > key) {
				column--;
			} else {
				row++;
			}
			
		}
		
		// -1 means can not locate
		result[0] = -1;
		result[1] = -1;
		
		// if the element can be found in matrix, then return the row and column of that element
		return result;
		
	}
	
	public static void main(String args[] ) {
		
		int[][] table = {{1, 2, 5}, {3, 6, 7}, {4, 8, 9}};
		int key = 9;
		int[] result = sortedMatrixSearch(table, key);
		System.out.println("row: "+result[0]+"   column: "+result[1]);
		
	}
}

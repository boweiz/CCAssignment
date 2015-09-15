
public class Solution08 {
	
	public static void setZeros(int[][] matrix) {
		
		int m = matrix.length;     // get rows
		int n = matrix[0].length;  // get columns
		
		// since for matrix[0][0] there are two storage situation
		// we use tr to determine whether 0 exists in the first row, use tc to determine whether 0 exists in the first column
		boolean tr = false;
		boolean tc = false;
		
		// once matrix[r][c] == 0, we set the corresponding first row and first column as 0
		for(int r=0; r<m; r++) {
			for(int c=0; c<n; c++) {
				if(matrix[r][c] == 0) {
					matrix[r][0] = 0;
					matrix[0][c] = 0;
					if(r == 0) tr = true;
					if(c == 0) tc = true;
				}
				
			}
			
		}
		
		// set 0
		for(int i=1; i<n; i++) {
			for(int k=1; k<m; k++) {			
				if(matrix[0][i] == 0 || matrix[k][0] == 0) {
					matrix[k][i] = 0;			
				}
			}
			
		}
		
		if(tr == true) {
			for(int i=0; i<n; i++) matrix[0][i] = 0;		
		}
		
		if(tc == true) {
			for(int i=0; i<m; i++) matrix[i][0] = 0;			
		}
			
	}
	
	public static void main(String args[]) {
		int[][] matrix = {{1,9,3},{2,0,4},{0,5,6}};
		setZeros(matrix);
		
		for(int i=0; i<matrix.length; i++) {
			for(int k=0; k<matrix[0].length; k++) 
				System.out.print(matrix[i][k]);	
			System.out.println("");
			
		}
			
	}
	
}
	
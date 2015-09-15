
public class Solution07 {
	
	public static void rotate(int[][] matrix) {
        // we assume rotating the matrix in clockwise, counterclockwise follows the same principle
        int n = matrix.length;
        
        // we rotate the matrix layer by layer, layer from 0 -> n/2;
        for(int layer = 0; layer < n/2; ++layer) {  
           
            int first = layer;     
            int last = n - 1 - layer; 
            
            // rotate each layer
            for(int i = first; i < last; ++i) {   
            	// t determine the rotate offset
                int t = i - first;    
                // save top
                int tmp = matrix[first][i]; 
                // left->top
                matrix[first][i] = matrix[last-t][first];                
                //bottom->left
                matrix[last-t][first] = matrix[last][last-t];                 
                //right->bottom
                matrix[last][last-t] = matrix[i][last];                
                //right <- saved top
                matrix[i][last] = tmp;
                
            }
            
        }
	}
	
	public static void main(String args[]) {
		
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		for(int i=0; i<matrix.length; i++) {
			for(int k=0; k<matrix[0].length; k++) {
				System.out.print(matrix[i][k]);
			}
			System.out.println("");
		}
		
		System.out.println("after rotation: ");
		
		rotate(matrix);
		for(int i=0; i<matrix.length; i++) {
			for(int k=0; k<matrix[0].length; k++) {
				System.out.print(matrix[i][k]);
			}
			System.out.println("");
		}
        
        
    }
}

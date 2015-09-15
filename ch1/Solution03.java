
public class Solution03 {
		
	public static void replaceSpaces(char[] str, int length) {
		//use count to store how many space
		//use newLength to store the new length after adding %20
		int count = 0;
		int newLength = 0;
		
		for(int i=0; i<length; i++) {
			if(str[i] == ' ') count++;
		}
				
		//since a space already take one place, so *2
		newLength = length + count * 2;  
		//end str at newLength in order to print it efficiently
		str[newLength] = '\0';          
				
		//edit the string in reverse order  
		for(int k=length-1; k>=0; k--) {
			
			//when there is a space, copy %20 into the array
			if(str[k]==' ') {            
				str[newLength-1] = '0';
				str[newLength-2] = '2';
				str[newLength-3] = '%';
				newLength = newLength - 3;
				
			//if there is no space, copy the original character
			} else {                   
				str[newLength-1] = str[k];
				newLength = newLength - 1;
			}
					
		}
		
	}

	public static void main(String[] args) {
		
		char str[] = {'s',' ', 'g', 'k', ' ', 'p', ' ', ' ', ' ', ' ', ' ', ' '};
				
		replaceSpaces(str, 6);
		
		for(int k=0; k<str.length; k++) {
			System.out.print(str[k]);
			
		}

	}

}

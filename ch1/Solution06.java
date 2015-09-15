import java.util.HashMap;

public class Solution06 {

	public static String StrCompression(String s) {
		 
		String compression = new String();
		
		compression = "";
		char[] content = s.toCharArray();
		
		int k = 0;
		while(k<content.length-1) {
			
			int count = 1;
			// count the repeated characters
			while(k<content.length-1 && content[k+1] == content[k]) {
				count++;
				k++;
			}
			// use compression to store new string
			compression = compression + String.valueOf(content[k]) + count;
			
			k = k + 1;			
		}
		
		// study the last char separately
		if(content[content.length-1] != content[content.length-2]) {
			compression = compression + String.valueOf(content[content.length-1]) + 1;
		}
		
		// if new string's length larger than original one, return original one.
		if(compression.length() > s.length()) return s;
		return compression;
		
	}
	
	public static void main(String[] args) {
		String s = "adfdddddddb";
		String newS = StrCompression(s);
		System.out.print(newS);

	}

}

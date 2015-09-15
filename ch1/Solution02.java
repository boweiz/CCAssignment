import java.util.Arrays;

public class Solution02 {

	public static boolean checkPermutation (String a, String b) {
		
		if(a.length() != b.length()) return false;
	
		// change String to Char[] to use the Arrays.sort function for each char	
		char[] content1 = a.toCharArray();
		char[] content2 = b.toCharArray();
		
		// sort each char[] in order for later compare
		Arrays.sort(content1);
		Arrays.sort(content2);
		
		// compare
		return Arrays.equals(content1, content2);	
		
	}
	
	
	public static void main(String[] args) {
		String a = "nihao";
		String b = "hniao";
		
		boolean k = checkPermutation(a, b);
		System.out.println(k);
		
	}

}

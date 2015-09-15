
public class Solution09 {
	
	public static boolean isRotation(String s1, String s2) {
		// if s1 and s2 do not have equal length, or they are null, return false
		if(s1.length() != s2.length() || s1.length() == 0) return false;
		
		String s3; 
		s3 = s1 + s1;
		// use isSubstring function to check
		return isSubstring(s3,s2);  
		
	}

	public static void main(String args[]) {
		String s1 = "abc";
		String s2 = "bca";
		boolean k = isRotation(s1,s2);
		System.out.println(k);
		
	}

}

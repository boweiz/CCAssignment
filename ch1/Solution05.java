
public class Solution05 {
	
	public static boolean checkOneAway(String s1, String s2) {
		// if their lengths differ than 1, they can not one away
		if(Math.abs(s1.length() - s2.length()) > 1) return false;
		
		// always restore the shorter one in "first", removal is inverse of insertion
		String first = s1.length() < s2.length() ? s1 : s2;
		String second = s1.length() < s2.length() ? s2 : s1;
		
		boolean deter = false;
		int index1 = 0;
		int index2 = 0;
		
		while(index1 < first.length() && index2 < second.length()) {
			if(first.charAt(index1) != second.charAt(index2)) {
				// the second time of insertion return false
				if(index1 != index2) return false;   
				// the second time of replacement return false
				if(deter) return false;              
				deter = true;
				index2++;
			} else {
				index1++;
				index2++;
			}
			
		}
		
		return true;
		
	}
		
	public static void main(String[] args) {
		String s1 = "abd";
		String s2 = "ad";
		System.out.println(checkOneAway(s1,s2));

	}

}

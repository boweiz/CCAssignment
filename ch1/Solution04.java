import java.util.HashMap;

public class Solution04 {
	// we can also use int[256] method like question 1.1
	public static boolean palindromePermutation(String s) {
		
		HashMap<Character, Integer> map = new HashMap<>();
	
		boolean deter = false;
		for(int i=0; i<s.length(); i++) {
			char a = s.charAt(i);
			// change all uppercase to lowercase
			if(a>'A' && a<'Z') a = (char)(a + 'a' - 'A');		
			if(!map.containsKey(a)) map.put(a, 1);
			else map.put(a, map.get(a)+1);
			
		}
		
		// there only can be <= 1 time for char which appears odd times, otherwise return false
		for(Character key : map.keySet()) {
			
			if((map.get(key) % 2) != 0) {
				if(deter) return false;
				deter = true;
			}		
		}
	
		return true;		
	}
	
	public static void main(String[] args) {
		String k = "BCcd";
		boolean j = palindromePermutation(k);
		System.out.println(j);
				
	}

}

package ccc10;

public class Solution05 {
	
	
	static int sparseSearch(String[] s, String key) {
		
		int low = 0;
		int high = s.length - 1;		
		int result = sparseSearchH(s, key, low, high);
		return result;
		
	}
	
	// help function
	static int sparseSearchH(String[] s, String key, int low, int high) {
		
		if (low > high) return -1;
		
		int mid = (low + high) / 2;
		
		if (s[mid] == key) return mid;
		int result = 0;
		
		// when s[mid] equals "", we should locate the position of non-null
		if (s[mid] == "") {
			
			int right = mid + 1;
			int left = mid - 1;
			
			while (right <= high && s[right] == "") {
				right++;
			}
			
			while (left >= low && s[left] == "") {
				left++;
			}
		
			if (right <= high) {
				mid = right;
			} else if (left >= low) { // when the right is all null
				mid = left;
			} else return -1;    // when right and left are all null
			
		}
			
		if (s[mid] == key) {
			return mid;
		} else if (s[mid].compareTo(key) > 0) {  // search the left side
			result = sparseSearchH(s, key, low, mid - 1);
		} else if (s[mid].compareTo(key) < 0) {  // search the right side
			result = sparseSearchH(s, key, mid + 1, high);
		} 
						
		return result;
							
	}
	
	public static void main(String[] args) {
		
		String[] s = {"at", "", "", "ball", "", "", "car", "", ""};
		String key = "car";
		int result = sparseSearch(s, key);
		
		System.out.println(result);

	}
}
	
	
	
	
	
	
	
	
	
	/*
	static int sparseSearchH(String[] s, String key, int low, int high) {
		
		if (low > high) return -1;
		
		int mid = (low + high) / 2;
		
		if (key.equals(s[mid])) return mid;
		
		boolean flag = true;
		
		while (low < high) {
			
			if (s[mid] == "") {
				
				int left = mid - 1;
				int right = mid + 1;
						
				while(flag) {
					System.out.println("test");
					// corner case
					if (left < low && right > high) {
						return -1;
						flag = false;
						break;
					} else if (s[right] != "") {
						mid = right;
						flag = false;
						System.out.println(s[mid]);
						break;
					} else if (s[left] != "") {
						mid = left;
						flag = false;
						break;
						
					} else {
					
					System.out.println(right);
					System.out.println(left);
					System.out.println(flag+"ppp");
					right++;
					left--;		
					}
				}
				
			}
				else break;
			}
				
			System.out.println("ppp");
			if (key.equals(s[mid])) return mid;
				
			else if (key.compareTo(s[mid]) > 0) sparseSearchH(s, key, mid+1, high);
			else if (key.compareTo(s[mid]) < 0) sparseSearchH(s, key, low, mid-1);				
				
		}
	
		return -1;
	}
		


}
*/
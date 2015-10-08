package cc666;

public class Solution08 {
	
	static int count = 0;
	
	// check whether break or not and count the drop number
	static boolean drop(int floor, int breakPoint) {
		count++;
		return (floor >= breakPoint);	

	}
	
	static int findBreakPoint(int totalFloor, int breakPoint) {
		
		int inteval = 14;
		int egg1 = inteval;
	
		// until egg1 breaks
		while (!drop(egg1, breakPoint)) {
			inteval--;
			egg1 = egg1 + inteval;
			
		}
		
		int egg2 = egg1 - inteval + 1;

		// until egg2 breaks
		while (egg2 < egg1 && egg2 <= totalFloor && !drop(egg2, breakPoint)) {
			egg2++;		
		}

		if (egg2 > totalFloor) {
			return -1;
		} else {
			return egg2;
		}		
		
	}
	
	public static void main(String[] args) {
		
		int totalFloor = 100;
		int breakPoint = 98;
		int result = findBreakPoint(totalFloor, breakPoint);
		
		System.out.println("break point : "+result);
		
		System.out.println("count : "+count);
	}

}

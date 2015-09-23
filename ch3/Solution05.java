package cc333;

import java.util.Stack;

public class Solution05 {
	
	public static Stack<Integer> sortStack(Stack<Integer> origin) {
		
		if(origin.size() == 0) return origin;
		Stack<Integer> help = new Stack<>();

		while(!origin.isEmpty()) {
			
			// we use a temporary buffer to hold an element's value each time to compare
			int hold = origin.pop();
			
			// we put the element in help stack until it's value > help.peek(), so that elements in help is in ascending order 
			while(help.size() != 0 && hold < help.peek()) {
				origin.push(help.pop());
			}
			help.push(hold);
			
		}
		
		while(!help.isEmpty()) {
			origin.push(help.pop());		
		}
		return origin;
			
	}
	
	public static void main(String[] args)  {
		
		Stack<Integer> test = new Stack<Integer>();
		test.push(1);
		test.push(35);
		test.push(5);
		test.push(-1);
		Stack<Integer> result = sortStack(test);
		
		while(!result.isEmpty()) {
			System.out.println(result.pop());
		}

		
	}
}
	
	
	


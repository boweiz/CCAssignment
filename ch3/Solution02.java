package cc333;

import java.util.Stack;

import cc333.Solution01.array3Stack;

public class Solution02 {
	
	public static class stackMin extends Stack<Integer> {
		Stack<Integer> s = new Stack<Integer>();
		 
		/*public stackMin() {
			s = new Stack<Integer>();
		}
		*/
		public void push(int val) {
			if(val < min()) s.push(val);
			super.push(val);		
		}
		
		public Integer pop() {
			int val = super.pop();
			// if val equals to super.pop(), then we should update the value in stack s
			if(val == min()) s.pop();
			return val;
				
		}
				
		public int min() {
			if(s.isEmpty()) return Integer.MAX_VALUE; // Integer.MAX_VALUE means stack is empty
			else return s.peek();
		}
		
	}
	
	public static void main(String[] args)  {
		
		stackMin test = new stackMin();
		test.push(1);
		test.push(6);
		test.push(5);
		test.push(-1);
		System.out.println(test.min());
		
	}
		

}

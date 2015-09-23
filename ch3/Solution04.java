package cc333;

import java.util.Stack;

import cc333.Solution02.stackMin;

public class Solution04 {

	public static class MyQueue {
		
		Stack<Integer> left = new Stack<>();
		Stack<Integer> right = new Stack<>();
		
		// let left stack always store the reverse order as a queue
		public void push(int val) {
			
			while(!right.isEmpty()) {
				left.push(right.pop());
			}
			
			left.push(val);
		}
	
		// let right stack always store the right order as a queue
		public int pop() {
			
			while(!left.isEmpty()) {
				right.push(left.pop());
			}
			
			return right.pop();
		}
		
		
		public int peek() {
			
			while(!left.isEmpty()) {
				right.push(left.pop());
			}
			
			return right.peek();
		}
	
		
		public boolean isEmpty() {
			return (left.isEmpty() && right.isEmpty());
		}
	
	}
	
	
	public static void main(String[] args)  {
		
		MyQueue test = new MyQueue();
		test.push(1);
		test.push(6);
		test.push(5);
		test.push(-1);
		System.out.println(test.pop());
		System.out.println(test.pop());
		test.pop();
		System.out.println(test.peek());
		
	}
	

}

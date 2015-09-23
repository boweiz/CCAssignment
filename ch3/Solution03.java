package cc333;

import java.util.ArrayList;
import java.util.Stack;

// the following codes can implement SetOfStacks, however, it can only remove the last empty one, 
// as for the empty stacks in the middle, it can not remove, which need to be improved in the future

class SetOfStacks {
	
	ArrayList<Stack> stacks = new ArrayList<>();
	
	int capacity;
	
	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}
	
	private Stack getLastS() {
		if(stacks.size() == 0) return null;
		return (stacks.get(stacks.size()-1));		
		
	}
	
	// to determine if a stack is full
	public boolean isFull() {
		Stack last = getLastS();
		if(last.size() == capacity) return true;
		else return false;
				
	}
	
	// to determine if a stack is empty
	public boolean isEmpty() {
		Stack last = getLastS();
		return (last == null || last.isEmpty());
		
	}
	
	// push a number at the end of last stack
	public void push(int a) {
		Stack last = getLastS();
		
		if(last != null && !isFull()) {
			last.push(a);
		} else {
			Stack tmp = new Stack();
			tmp.push(a);
			stacks.add(tmp);			
		}
				
	}
	
	// pop a number from the last stack
	public int pop() {
		Stack<Integer> last = getLastS();
		int r = last.pop();
		if(last.size() == 0) {
			stacks.remove(stacks.size()-1);
		}
		return r;			
	}
	
	// pop a number from a certain stack
	public int pop(int index) {
		// when index is larger than stacks number, return int.max to show incorrect
		if(index > stacks.size()-1) return Integer.MAX_VALUE;
		Stack<Integer> cur = stacks.get(index);
		int r = cur.pop();
		return r;
		
	}

}


public class Solution03 {
		
	public static void main(String[] args)  {
		
		SetOfStacks test = new SetOfStacks(2);
		
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(4);
		System.out.println(test.pop(0));
		System.out.println(test.pop());
		test.push(5);
		test.push(6);
		System.out.println(test.pop(3));
		
	}
		
}
	
	
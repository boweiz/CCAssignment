package cc222;

import java.util.Stack;

public class Solution06 {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static boolean isPalindrome(ListNode head) {
		//use stack to store the fist half value of list
		Stack<Integer> stack = new Stack<>();
		if(head == null) return true;
		
		ListNode fast = head;
		ListNode slow = head;
		
		// let slow point to the start point of the second half part of list
		while(fast != null && fast.next != null) {
			stack.push(slow.val);
			fast = fast.next.next;
			slow = slow.next;						
		}
		
		// there are odd number of nodes, we should skip the middle one
		if(fast != null) slow = slow.next;  
		
		// compare the second half part with the former half part one by one.
		while(slow != null) {
			if(stack.pop() != slow.val) return false;
			slow = slow.next;
			
		}		
		return true;
	}
	
	public static void main(String args[]) {
		
		ListNode list = new ListNode(7);
		list.next =new ListNode(2);
		list.next.next =new ListNode(2);
		list.next.next.next =new ListNode(7);
		list.next.next.next.next =new ListNode(7);
		
		System.out.println(isPalindrome(list));
		
	}
		
}

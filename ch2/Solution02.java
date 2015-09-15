package cc222;

public class Solution02 {
		
	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}

	public static ListNode kth2last(ListNode head, int k) {
		
		if(head == null) return null;
		
		// use two point, let k-1 elements between them
		ListNode left = head;
		ListNode right = head;
		
		// we define that the last node is the 1th element to the last element
		for(int i=0; i<k; i++) {
			if(right == null) return null;
			right = right.next;
		}
	
		// when right point reach the last element, the left point reach the kth to last element
		while(right != null) {
			right = right.next;
			left = left.next;
		}
		
		return left;
		
	}
	
	public static void main(String[] args) {
		ListNode list = new ListNode(0);
		list.next =new ListNode(2);
		list.next.next =new ListNode(0);
		list.next.next.next =new ListNode(1);
	
		ListNode newnode = kth2last(list, 1);
	
		while(newnode != null) {
			System.out.println(newnode.val);
			newnode = newnode.next;
		}
			
	}

}
	
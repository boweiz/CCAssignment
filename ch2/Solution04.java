package cc222;

public class Solution04 {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static ListNode partition(ListNode head, int val) {
		
		if(head == null) return null;
		
		//use smaller to store the node whose value < val
		//use bigger to store the node whose value >= val
		ListNode smaller = new ListNode(0);
		ListNode bigger = new ListNode(0);
		ListNode newhead1 = smaller;
		ListNode newhead2 = bigger;
		
		while(head != null) {
			if(head.val < val) {
				smaller.val = head.val;
				smaller.next = new ListNode(0);
				smaller = smaller.next;
				
			} else {
				bigger.next = new ListNode(0);
				bigger = bigger.next;
				bigger.val = head.val;
				
			}
			head = head.next;
			
		}
		
		// merge smaller with bigger
		smaller.val = newhead2.next.val;
		smaller.next = newhead2.next.next;
		
		return newhead1;		
	}
	
	public static void main(String[] args) {
		
		ListNode list = new ListNode(7);
		list.next =new ListNode(2);
		list.next.next =new ListNode(5);
		list.next.next.next =new ListNode(1);
		list.next.next.next.next =new ListNode(3);
		
		ListNode newnode = partition(list, 3);
		
		while(newnode != null) {
			System.out.print(newnode.val);
			newnode = newnode.next;
		}
		
	}

}

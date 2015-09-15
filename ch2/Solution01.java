package cc222;

public class Solution01 {

	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	
	
	public static void deleteDups(ListNode head) {
		// do not use buffer, we use two points instead 
		
		if(head == null) return; 
		
		// point cur iterates through the LinkedList
		ListNode cur = head;
	
		while(cur != null) {
			// point run checks all subsequent nodes to see if there are any duplicates.
			ListNode run = cur;
		
			while(run.next != null) {
				if(cur.val == run.next.val) run.next = run.next.next;
				else run = run.next;
			}
			cur = cur.next;
		}
				
	}
	
	// test
	public static void main(String[] args) {
		
		ListNode list = new ListNode(0);
		list.next =new ListNode(2);
		list.next.next =new ListNode(0);
		list.next.next.next =new ListNode(0);
		list.next.next.next.next =new ListNode(3);
		list.next.next.next.next.next =new ListNode(3);
		
		deleteDups(list);
		
		while(list != null) {
			System.out.println(list.val);
			list = list.next;
		}
		
	}	
	
}

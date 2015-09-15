package cc222;

public class Solution07 {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static ListNode getIntersection(ListNode head1, ListNode head2) {
		// besides the method below, we can also solve it by determine whether the last nodes
		// of the first and second listnode are equal
		
		if(head1 == null || head2 == null) return null;
		
		ListNode still = head1;
		ListNode move = head1;
		
		while(move.next != null) move = move.next;
		
		// make list head1 as a cycle
		move.next = still;
		
		ListNode fast = head2;
		ListNode slow = head2;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;		
			if(fast == slow) break;
		}
		
		// point fast to head2, and iterate again, when fast == slow, fast is the intersection
		fast = head2;
		while(fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return fast;		
		
	}
	
	public static void main(String args[]) {
		
		ListNode list1 = new ListNode(7);
		list1.next =new ListNode(2);
		list1.next.next =new ListNode(2);
		list1.next.next.next =new ListNode(7);
		list1.next.next.next.next =new ListNode(7);
		
		ListNode list2 = new ListNode(9);
		list2.next =new ListNode(10);
		list2.next.next =list1.next;

		System.out.println(getIntersection(list1, list2).val);
		
	}
}
	

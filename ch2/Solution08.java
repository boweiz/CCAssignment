package cc222;

public class Solution08 {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static ListNode detectCycle(ListNode head) {
		
		if(head == null) return null;
		
		ListNode fast = head;
		ListNode slow = head;
		
		// we use a fast speed point and a slow speed point, if there is a cycle, they will meet
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow= slow.next;
			if(fast == slow) break;
		}
		
		// check if there is a cycle 
		if(fast == null || fast.next == null) return null;
		
		// there is a cycle, then we find the beginning of the loop
		fast = head;
		
		// based on the mathematical analysis, we can find the beginning by doing following process
		while(fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return fast;
	}
		
	public static void main(String args[]) {
			
		ListNode list1 = new ListNode(7);
		list1.next =new ListNode(2);
		list1.next.next =new ListNode(3);
		list1.next.next.next =new ListNode(7);
		
		list1.next.next.next.next = list1.next.next;
			
		ListNode k = detectCycle(list1);
		System.out.println(k.val);
			
	}
    
}

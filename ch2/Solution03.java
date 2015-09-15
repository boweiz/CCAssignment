package cc222;

public class Solution03 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static void deleteNode(ListNode node) { 
	    	
	    // node is in the middle of the list
	    if(node != null && node.next != null) {
	    	node.val = node.next.val;
		    node.next = node.next.next;
	   
	    }
	}
	    
	public static void main(String[] args) {
		
		ListNode list = new ListNode(0);
		list.next =new ListNode(2);
		list.next.next =new ListNode(0);
		list.next.next.next =new ListNode(1);
					
		ListNode del = list.next.next;
		deleteNode(del);
		
		while(list != null) {
			System.out.println(list.val);
			list = list.next;
		}		
	}
}

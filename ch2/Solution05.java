package cc222;

import java.util.Stack;

public class Solution05 {
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public static ListNode sumList(ListNode s1, ListNode s2, int carry) {
		
		//recursive method
		if(s1 == null && s2 == null && carry == 0) return null;
		
		ListNode result = new ListNode(0);
		
		// value is the sum of two nodes' val and carry
		int val = carry;
		if(s1 != null) val = val + s1.val;
		if(s2 != null) val = val + s2.val;
		
		carry = val / 10;
		
		result.val = val % 10;
		
		// recursive
		result.next = sumList(s1 == null? null:s1.next, s2 == null? null:s2.next, carry);
		
		return result;
			
	}
	
	// follow up question
	public static ListNode followUp(ListNode head1, ListNode head2) {
		
		// a new way to solve it by using buffer
		if(head1 == null && head2 == null) return null;
		
		int sum1 = 0;
		int sum2 = 0;
		
		while(head1 != null) {
			sum1 = head1.val + sum1 * 10;
			head1 = head1.next;
		}
		
		while(head2 != null) {
			sum2 = head2.val + sum2 * 10;
			head2 = head2.next;
		}
		
		int sum = sum1 + sum2;
		
		if(sum == 0) return (new ListNode(0));
		
		ListNode head = new ListNode(0);
		
		// use a head point to store every digits in a listnode
		head.next = new ListNode(sum % 10);
		sum = sum / 10;
		
		while(sum != 0) {
			ListNode tmp = new ListNode(sum % 10);
			tmp.next = head.next;
			head.next = tmp;
			sum = sum / 10;
		}
		return head.next;
		
	}
	
	public static void main(String[] args) {
		
		ListNode list1 = new ListNode(7);
		list1.next =new ListNode(2);
		list1.next.next =new ListNode(1);
		
		ListNode list2 = new ListNode(9);
		list2.next =new ListNode(2);
		list2.next.next =new ListNode(5);
		
		ListNode newnode1 = sumList(list1, list2, 0);
		ListNode newnode2 = followUp(list1, list2);
		
		// first question test
		System.out.println("first.val is the one's place digit:   ");
		if(newnode1 == null) System.out.println("null");
			else { 
				while(newnode1.next != null) {

					System.out.print(newnode1.val+"->");
					newnode1 = newnode1.next;
				}
				System.out.print(newnode1.val);
			}
		
		System.out.println("   ");
	
		// follow up question test
		System.out.println("last.val is the one's place digit:   ");
		if(newnode2 == null) System.out.println("null");
			else { 
				while(newnode2.next != null) {

					System.out.print(newnode2.val+"->");
					newnode2 = newnode2.next;
				}
				System.out.print(newnode2.val);
			}
	}

}

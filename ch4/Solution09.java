package cc444;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution09 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		TreeNode(int x) { 
			val = x; 
		}
	}
		
	static ArrayList<LinkedList<Integer>> bstSequences(TreeNode node) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
			
		if (node == null) {
			result.add(new LinkedList<Integer>());
			return result;	
		}
			
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.val);
			
		ArrayList<LinkedList<Integer>> leftSeq = bstSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = bstSequences(node.right);
			
		for (LinkedList<Integer> left : leftSeq) {
			for (LinkedList<Integer> right : rightSeq){
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveLists(left, right, weaved, prefix);
				result.addAll(weaved);							
			}
				
		}
		
		return result;
		
	}
		
	static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
		ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
			
		if (first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;			
		}			
		
		// there are two conditions when we are weaving
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
	 	}
		
	public static void main(String[] args) {
			
		TreeNode root = new TreeNode(7);
			
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(3);
		//root.right = new TreeNode(9);
		root.left.right = new TreeNode(6);	
		//root.right.right = new TreeNode(11);	
		//root.right.left = new TreeNode(8);
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		result = bstSequences(root);
			
		for (int i=0; i<result.size(); i++) {
				
			for(int k=0; k<result.get(i).size(); k++) {
				System.out.print(result.get(i).get(k)+"  ");
					
			}
			System.out.println("");			
		}
				
	}
		
}
// most of the answer is referring to the solution of cc150 

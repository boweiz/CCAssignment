package cc444;

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Solution02 {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	public static TreeNode createminBST(int[] array) {
		
		return createminBST(array, 0, array.length - 1);
	}
	
	public static TreeNode createminBST(int[] array, int low, int high) {
		
		if(low > high) return null;
	
		TreeNode root = new TreeNode(0);
		int mid = (low + high) / 2;
			
		root.val = array[mid];
		
		// create BST
		root.left = createminBST(array, low, mid-1);
		root.right = createminBST(array, mid+1, high);
		return root;
		
	}
		
	public static void main(String[] args) {
			
		int low = 0;
		int[] array = {1,2,3,4,5};
		int high = array.length-1;
		TreeNode result = createminBST(array);
		
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(result);
		
		// print tree
		while(!que.isEmpty()) {
			TreeNode tmp = que.remove();
			System.out.println(tmp.val);
			if(tmp.left != null) que.add(tmp.left);
			if(tmp.right != null) que.add(tmp.right);
			
		}		
		
	}

}

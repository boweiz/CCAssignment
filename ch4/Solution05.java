package cc444;

import cc444.Solution04.TreeNode;

public class Solution05 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	public static boolean isBinarySearch(TreeNode root) {
		
		if(root == null) return true;
	
		if(root.left != null && root.left.val > root.val)  return false;
		if(root.right != null && root.right.val < root.val) return false;
		
		return (isBinarySearch(root.left) && isBinarySearch(root.right));
				
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.right = new TreeNode(5);	
		
		System.out.println(isBinarySearch(root));

	}

}

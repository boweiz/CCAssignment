package cc444;

import cc444.Solution05.TreeNode;

public class Solution06 {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	// in-order 
	public static TreeNode nextNode(TreeNode node) {
		
		if (node == null) return null;
		
		// if node has right child, return right child directly
		if (node.right != null) return node.right;
		
		// if node is its parent's right child, find the node that is its parent's left child
		
		while (node.parent != null && node == node.parent.right) {
			node = node.parent;		
		}
		
		if (node.parent == null) return null;
		
		return node.parent;
	}
	

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		root.parent = null;
		root.left = new TreeNode(2);
		root.left.parent = root;
		root.right = new TreeNode(4);
		root.right.parent = root;
		root.left.right = new TreeNode(5);	
		root.left.right.parent = root.left;
		
		TreeNode result = nextNode(root.right);
		if(result == null) System.out.println("null");
		else System.out.println(result.val);

	}
}

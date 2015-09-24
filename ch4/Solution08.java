package cc444;

import java.util.Stack;

import cc444.Solution06.TreeNode;

public class Solution08 {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	public static TreeNode firstComAnce(TreeNode root, TreeNode n1, TreeNode n2) {
		
		if ((root == n1 && contain(root, n2)) || (root == n2 && contain(root, n2))) return root;
		
		if ((contain(root.left, n1) && contain(root.right, n2)) || (contain(root.left, n2) && contain(root.right, n1))) 
			return root;
		else if (contain(root.left, n1) && contain(root.left, n2)) 
			return firstComAnce(root.left, n1, n2);
		else if (contain(root.right, n1) && contain(root.right, n2)) 
			return firstComAnce(root.left, n1, n2);
		
		return null;
				
	}
	
	// determine if the first node contain the second node
	public static boolean contain(TreeNode root, TreeNode n) {
		if (root == null) return false;
		if (root == n) return true;
		Stack<TreeNode> stack = new Stack<>();
		
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode tmp = stack.pop();
			if (tmp == n) return true;
			if (tmp.left != null) stack.push(tmp.left);
			if (tmp.right != null) stack.push(tmp.right);
		}
		
		return false;	
	}
	
	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(7);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(5);	
		root.left.right.left = new TreeNode(10);	

		TreeNode result = firstComAnce(root, root.left.left, root.left.right.left);
		
		if (result == null) System.out.println("null");
		else System.out.println(result.val);
		

	}

}

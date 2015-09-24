package cc444;

public class Solution04 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	public static boolean isBinaryTree(TreeNode root) {
		
		if(root == null) return true;
		
		// subset of any node should never differ than 1, otherwise return false
		if(Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) return false;
		
		else {
			return (isBinaryTree(root.left) && isBinaryTree(root.right));
		}
		
		
	}
	
	// return each node's maxDepth
	public static int maxDepth(TreeNode root) {
		
		if(root == null) return 0;
		return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
		
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);	
		
		System.out.println(isBinaryTree(root));
		

	}

}

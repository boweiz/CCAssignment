package cc444;


public class Solution12 {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	public static int countPaths(TreeNode node, int sum) {
	
		int depth = depth(node);
		int[] path = new int[depth];
		
		// use array to store count
		int[] count = new int[1];
		count[0] = 0;
		countPaths(node, sum, path, count, 0);
		return count[0];
	
	}
	
	// find the maxdepth of a node
	public static int depth(TreeNode node) {
		
		if(node == null) return 0;
		
		return Math.max(depth(node.left),depth(node.right)) + 1;
		
	}
	
	public static void countPaths(TreeNode node, int sum, int[] path, int[] count, int level) {
		
		if(node == null) return;
				
		path[level] = node.val;
		
		int tmp = 0;
		for(int i = level; i>= 0; i--) {
			// look for paths with a sum that ends at this node
			tmp += path[i];
			if (tmp == sum) {
				count[0] ++;	
			}
		}
		// recursively going through every node
		countPaths(node.left, sum, path, count, level+1);
		countPaths(node.right, sum, path, count, level+1);
			
		
	}
	

	public static void main(String[] args) {
	
		TreeNode root = new TreeNode(3);
			
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(7);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(5);	
		root.left.right.left = new TreeNode(10);
		int sum1 = 7;
		int k = countPaths(root.left.left, sum1);
		System.out.println(k);

	}
}

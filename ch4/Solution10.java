package cc444;


public class Solution10 {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	public static boolean isSub(TreeNode t1, TreeNode t2) {
		// empty tree is always subtree.
		if (t2 == null) return true;
		
		return sub(t1, t2);
		
	}
	
	// first find the start point in t1.
	public static boolean sub(TreeNode h1, TreeNode h2) {
		
		// to avoid nullpointerexception 
		if (h1 == null) return false;
		
		// first find out if their values are the same, then do the match, which can save running time 
		if (h1.val == h2.val) {
			if (match(h1,h2)) return true;
		}
		
		return (sub(h1.left, h2) || sub(h1.right, h2));
		
	}
	
	// to see if t1 match t2
	public static boolean match(TreeNode h1, TreeNode h2) {
				
		if (h1 == null && h2 == null) return true;
		
		if (h1 == null || h2 == null) return false;
		
		if (h1.val != h2.val) return false;

		return (match(h1.left, h2.left) && match(h1.right, h2.right));
				
		
	}
	
	
	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(7);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(5);	
		root.left.right.left = new TreeNode(10);
		
		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(7);
		root2.right = new TreeNode(5);
		root2.right.left = new TreeNode(10);

		boolean result = isSub(root, root2);

		System.out.println(result);

	}

}

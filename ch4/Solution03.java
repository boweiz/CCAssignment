package cc444;

import java.util.ArrayList;
import java.util.LinkedList;

import cc444.Solution02.TreeNode;

public class Solution03 {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		TreeNode(int x) { 
			val = x; 
		}
	}

	
	public static ArrayList<LinkedList<TreeNode>> createLevLin(TreeNode root) {
		
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		
		LinkedList<TreeNode> tmp = new LinkedList<>();
		
		if(root == null) return result;
		
		tmp.add(root);
		
		// use iterative method
		
		while(tmp.size() > 0) {
			
			// add previous level
			result.add(tmp);
			LinkedList<TreeNode> parents = tmp;
			tmp = new LinkedList<TreeNode>();
			
			// iterate the previous level, and add their child in the linkedlist
			for(TreeNode parent : parents) {
				if(parent.left != null) {
					tmp.add(parent.left);
				}
				if(parent.right != null) {
					tmp.add(parent.right);
				}						
			}
			
		}
		
		return result;
	}
	
		
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(7);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(5);	
		root.left.right.left = new TreeNode(10);
		
		ArrayList<LinkedList<TreeNode>> r = new ArrayList<LinkedList<TreeNode>>();
		r = createLevLin(root);
		
		// print
		for(int i=0; i<r.size(); i++) {
			for(int k=0; k<r.get(i).size(); k++)
				System.out.println(r.get(i).get(k).val);
			
		}
		

	}

}

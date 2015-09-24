package cc444;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
		
	class TreeNode {
		
		HashMap<Integer, TreeNode> map = new HashMap<>();
		ArrayList<TreeNode> arrList = new ArrayList<>();
		
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) { 
			
			val = x; 
			map.put(val, this);
			arrList.add(this);
		}	
	
		
		// insert a node
		TreeNode insert(int k) {
		
			TreeNode tmp = this;
			return insertHelper(k, tmp);
		}
	
		TreeNode insertHelper(int k, TreeNode tmp) {
		
			if (tmp == null) {		
				
				tmp = new TreeNode(0);
				tmp.val = k;
				map.put(k, tmp);
				arrList.add(tmp);

				return tmp;
			}			
		
			if(k > tmp.val)  tmp.right = insertHelper(k, tmp.right);
			if(k < tmp.val)  tmp.left = insertHelper(k, tmp.left);	
			
			return tmp;
		}
		
		// find a node
		TreeNode find(int k) {
			if(map.containsKey(k))
				return map.get(k);
			else return null;
		
		}
	
		// find a random node
		TreeNode findRandom() {
			int i = this.arrList.size();
			int random = (int) (Math.random() * i);
			return arrList.get(random);
		} 
		
		// print the tree in in-order
		void print() {
	
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.add(this);
			while(!stack.isEmpty()) {
				TreeNode tmp = stack.pop();
				if(tmp.right != null) stack.push(tmp.right);	
				
				System.out.println(tmp.val);
				
				if(tmp.left != null) stack.push(tmp.left);
			}
		
		}
	}
	
	public class Solution11 {
			
		public static void main(String[] args) {
			
			TreeNode root = new TreeNode(3);
		
			root.insert(1);
			root.insert(2);
			root.insert(7);
		
			System.out.println("print the tree in in-order:");
			root.print();
			
			System.out.println("find(3):  "+root.find(3).val);
			
			System.out.println("findRandom:  "+root.findRandom().val);
			
		}
	}
	
// as for the delete function, since we already store every TreeNode k in a 
// map, we can get the node with map.get(k.val) to locate that node, and then delete that node from
// the map and arraylist, and use node.val = node.next.val, node.next = node.next.next to bring th 
// later one up.	



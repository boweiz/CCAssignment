package ccc10;

import java.util.Scanner;

// construct a class
class RankNode {
	
	// left_size matters most
	public int left_size = 0;
	public RankNode left, right;
	public int data = 0;
	public RankNode(int d) {
		data = d;
	}

	public void insert(int d) {
		
		if (d <= data) {
			if (left != null) left.insert(d);
			else left = new RankNode(d);
			left_size++;			
		} else {
			if (right != null) right.insert(d);
			else right = new RankNode(d);
					
		}		
	}
	
	public int getRank(int d) {
		
		if (d == data) {
			return left_size;
		} else if (d < data) {
			if (left == null) return -1;
			else return left.getRank(d);  //recursive
		} else {
			int right_rank = right == null ? -1: right.getRank(d);
			
			if (right_rank == -1) return -1;
			else return left_size + 1 + right_rank;
		}		
	}
	
	
}

 
 public class Solution10 {
		
		public static void main(String[] args) {
			
			boolean flag = true;
			Scanner scanner=new Scanner(System.in);
						
			System.out.println("how many numbers do you have");
			int number = scanner.nextInt();
			
			System.out.println("please type an integer: ");
			int input = scanner.nextInt();
			RankNode root = new RankNode(input);
			
			for (int i=0; i<number - 1; i++) {
				
				System.out.println("please type an integer: ");
				input = scanner.nextInt();
				root.insert(input);
				
			}
			
			while(flag) {
				
				System.out.println("please type the number you hope to get rank from, press -1 to quit");
				scanner = new Scanner(System.in);
				input = scanner.nextInt();
				
				if (input == -1) {
					flag = false;
					continue;
				}
				
				int result = root.getRank(input);
				
				System.out.println("the rank of " + input + " is "+ result);
				
			}
			
		}
	
 }

 // refer to the solution of CC150
 
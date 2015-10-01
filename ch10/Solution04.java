package ccc10;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution04 {
	
	int index = 1;
	
	int search (Listy list, int key) {	
		
		int result;
		
		while (list.elementAt(index) != -1 && list.elementAt(index) < key) {
			index = index * 2;  // log(n) 
		}
				
		// key must exist between index/2 and index
		result = binarySearch(list, index / 2, index, key);
		
		return result;
	}
	
	
	// do binary search
	int binarySearch (Listy list, int low, int high, int key) {
	
		int mid = (low + high) / 2;
		int middle = list.elementAt(mid);
		if (middle == key) return mid;
		
		while (low <= high) {
			
			if (middle == -1 || middle > key) {
				binarySearch(list, low, mid - 1, key);
			} else if (middle < key) {
				binarySearch(list, mid + 1, high, key);
			} 
			
		}
		
		// -1 means can not find the key
		return -1;
		
	}
	
	public static void main(String[] args) {
		
		Listy list = new Listy();
		int key = 8;
		int result = search(list, key);
		
		System.out.println(result);
		

	}

}

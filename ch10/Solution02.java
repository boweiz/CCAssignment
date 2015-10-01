package ccc10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution02 {
	
	static void groupAnagrams(String[] s) {
			
		HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		
		
		for (int i=0; i<s.length; i++) {
		
			char[] newArray = s[i].toCharArray();
			// sort newArray
			Arrays.sort(newArray);	

			// char[] -> String
			String key = new String(newArray);

			// if a certain key is contained in hashmap, new a LinkedList
			if (!map.containsKey(key)) {
				map.put(key, new LinkedList<String>());
			}
			
			LinkedList<String> anagram = map.get(key);
			anagram.add(s[i]);
			
		}
		
		int j = 0;
		
		// rearrange s[]
		for (String key : map.keySet()) {
			for(int n=0; n<map.get(key).size(); n++) {
				s[j] = map.get(key).get(n);
				j++;					
			}		
		}
		
	}

	public static void main(String[] args) {
		String[] s = {"abc", "cba", "tu", "po", "ut", "opt", "op"};
		groupAnagrams(s);
		
		for (int i=0; i<s.length; i++) {
			
			System.out.print(s[i]+" ");
		}		
	}

}

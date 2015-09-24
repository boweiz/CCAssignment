package cc444;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
	
List<directedGraph> buildOrder(directedGraph g) {
		
		int a, b, count;
		List<GraphNode> order = new ArrayList<E>();
		
		count = 0;
			
		while(count < g.size()) {
			
			for(a=0; a<g.size(); a++) {
				// find the nodes, which do not depend on any other nodes
				if(g.get(a) != null && g.get(a).isEmpty())
					break;			
			}
			
			if(a < g.size()) {
				count++;
				order.add(g.vertices.get(a));
				g.set(a, null);
				
				for(int k=0; k<g2.size(); k++) {
					if(g.get(k) != null)
						g.get(k).remove((Object) a);	
				}				
				
			} else break;
		}
		// if count is less than g2.size(), which means g2 is not cleaned enough, can not hold a valid order
		if(count < g2.size()) return null;
		
		return order;
}	

public class Solution07 {
	
	public static void main(String[] args) {

		DirectedGraph<String> g = new DirectedGraph<String>();
		
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		
		g.addEdges("a", "b");
		g.addEdges("b", "c");
		g.addEdges("d", "e");
		g.addEdges("c", "e");
		
		List<directedGraph> result = new ArrayList<>();
		result = buildOrder(g);
		
		for(String r : result)
			System.out.println(r + " ");
	}
}

// discussed with Jiang Yi.

package cc444;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


class DirectedGraph<E> {
	
	List<E> vertices;
	List<List<Integer>> edges;

	DirectedGraph() {	
		this.vertices = new ArrayList<E>();
		this.edges = new ArrayList<List<Integer>>();		
	}
	
	// add vertex
	boolean addVertex(E u) {
		if (this.vertices.indexOf(u) < 0) {
			this.vertices.add(u);
			this.edges.add(new ArrayList<Integer>());
			return true;		
		}
		return false;	
	}
	
	// add edges
	boolean addEdges(E u, E v) {
		int a, b;
		if ((a = this.vertices.indexOf(u)) >= 0 && (b = this.vertices.indexOf(v)) >= 0 
				&& this.edges.get(a).indexOf(b) < 0) {
			this.edges.get(a).add(b);
			return true;
		}
		return false;	
	}
	
	// get neighbor of a vertex
	List<Integer> getNeighbor(int i) {
		
		if (i >= this.edges.size() || i < 0) return null;
		return this.edges.get(i);	
		
	}	
	
	// to determine if there is a route from vertex u to vertex v
	boolean hasRoute(E u, E v) {
		int a, b;
		boolean visited[] = new boolean[this.vertices.size()];
		
		if ((a = this.vertices.indexOf(u)) < 0 || (b = this.vertices.indexOf(v)) < 0) return false;
			
		Stack<Integer> tmp = new Stack<>();
	    tmp.push(a);
	    
	    while(!tmp.isEmpty()) {
	    	int k = tmp.pop();
	    	if(!visited[k]) {
	    		visited[k] = true;
	    		for (Integer i: this.edges.get(k))
		    		tmp.push(i);
	    	}
        	
	    }
		
	    return visited[b];
	}
}

public class Solution01 {
	
	public static void main(String[] args) {
		DirectedGraph<Integer> g = new DirectedGraph<Integer>();
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addVertex(6);
		
		g.addEdges(1, 2);
		g.addEdges(2, 4);
		g.addEdges(4, 1);
		g.addEdges(3, 5);
		
		System.out.println(g.hasRoute(3,5));
		
	}
	
}
	
// discussed with Jiang yi.


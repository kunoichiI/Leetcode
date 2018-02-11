package gfg;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	private int V;
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public int getVertices() {
		return this.V;
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	public LinkedList<Integer>[] getAdjList() {
		return this.adj;
	}
	
	/*
	 * exclusively for alien dictionary's topological sort
	 */
	public LinkedList<Character> topologialSort() {
		LinkedList<Character> list = new LinkedList<>();
		boolean[] visited = new boolean[V];
		Stack<Integer> s = new Stack<>();
		
		for (int i = 0; i < V; i++) {
			if (!visited[i])
				helper(i, visited, s);
		}
		
		while(!s.isEmpty()) {
			int j = s.pop();
			list.add((char)j);
		}
		return list;
	}
	
	public void helper(int i, boolean[] visited, Stack<Integer> s) {
		visited[i] = true;
		Iterator<Integer> it = adj[i].iterator();
		while (it.hasNext()) {
			Integer j = it.next();
			if (!visited[j])
				helper(j, visited, s);
		}
		s.push(i);
	}
	
}

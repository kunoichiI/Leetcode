package gfg;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

// DFS + Stack
// Graph is the same as this one ~ https://www.geeksforgeeks.org/topological-sorting/ 
// This is a solution providing a DFS traverse on this graph
public class DepthFirstSearch {
	private Graph graph;
	public DepthFirstSearch() {
		setGraph(new Graph(6));
		graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(3, 2);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
	}
	
	public void dfs() {
		/*
		 * print out a list of node value after a DFS traversal
		 */
		int V = graph.getVertices();
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i])
				dfs_helper(i, visited, stack);
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
	
	public void dfs_helper(int i, boolean[] visited, Stack<Integer> stack) {
		visited[i] = true;
		LinkedList<Integer>[] adj = graph.getAdjList();
		Iterator<Integer> it = adj[i].iterator();
		while(it.hasNext()) {
			Integer child = it.next();
			if (!visited[child])
				dfs_helper(child, visited, stack);
		}
		stack.push(i);
	}
	
	public static void main(String[] args) {
		DepthFirstSearch solution = new DepthFirstSearch();
		System.out.println("Following is Depth First Traversal :");
		
		solution.dfs();
	}
	
	public Graph getGraph() {
		return graph;
	}
	public void setGraph(Graph graph) {
		this.graph = graph;
	}

}

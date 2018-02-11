package gfg;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
// BFS + queue

//Graph is the same as this one ~ https://www.geeksforgeeks.org/topological-sorting/ 
//This is a solution providing a DFS traverse on this graph
public class BreadthFirstSearch {
	private Graph graph;
	public BreadthFirstSearch() {
		setGraph(new Graph(6));
		graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(1, 2);
        graph.addEdge(3, 2);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
	}
	public void bfs_helper(int u, boolean[] visited) {
		// create a queue for bfs
		Queue<Integer> queue = new LinkedList<>();
		LinkedList<Integer>[] adj = graph.getAdjList();
		// Mark the current node as visited
		queue.offer(u);
		visited[u] = true;
		
		while(!queue.isEmpty()) {
			Integer s = queue.poll();
			System.out.print(s + " ");
			
			// Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
			Iterator<Integer> it = adj[s].iterator();
			while (it.hasNext()) {
				Integer next = it.next();
				if (!visited[next]) {
					visited[next] = true;
					queue.offer(next);
				}	
			}
		}
	}
	
	void bfs() {
		int V = graph.getVertices();
		boolean[] visited = new boolean[V];
		for (int u = 0; u < V; u++) {
			if (!visited[u])
				bfs_helper(u, visited);
		}
	}
	public static void main(String[] args) {
		BreadthFirstSearch g = new BreadthFirstSearch();
		
		System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 0)");
 
        g.bfs();

	}
	public Graph getGraph() {
		return graph;
	}
	public void setGraph(Graph graph) {
		this.graph = graph;
	}

}

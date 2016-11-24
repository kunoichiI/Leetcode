package leetcode;
import java.util.*;

public class DFS {
	private int V;
	
	private LinkedList<Integer> list[];
	
	public DFS(int v) {
		this.V = v;
		this.list = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			list[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int u, int v) {
		list[u].add(v);
	}
	
	public void depthFirstSearch() {
		boolean[] visited = new boolean[V];
		
		for (int i = 0; i < V; i++) {
			if (!visited[i])
				dfsHelper(i, visited);
		}
	}
	
	public void dfsHelper(int v, boolean[] visited) {
		visited[v] = true;
		Integer i;
		System.out.print(v + " ");
		
		Iterator<Integer> it = list[v].iterator();
		while(it.hasNext()) {
			i = it.next();
			if (!visited[i])
				//System.out.println(i);
				dfsHelper(i, visited);
		}
	}
	
	public static void main(String[] args) {
		DFS ts = new DFS(6);
		ts.addEdge(5, 2);
		ts.addEdge(5, 0);
		ts.addEdge(4, 0);
		ts.addEdge(4, 1);
		ts.addEdge(2, 3);
		ts.addEdge(3, 1);
//		for (int i = 0; i < 6; i++) {
//			System.out.println(ts.list[i].toString());
//		}
		ts.depthFirstSearch();

	}

}

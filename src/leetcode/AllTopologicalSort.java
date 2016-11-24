package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

//Given a DAG, print all topological sorts of the graph.

public class AllTopologicalSort {
	int v;
	LinkedList<Integer> adj[];
	int[] indegree;
	
	@SuppressWarnings("unchecked")
	public AllTopologicalSort(int v) {
		this.v = v;
		adj = new LinkedList[v];
		this.indegree = new int[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
		indegree[v]++;
	}
	
	public void allTopoSort() {
		boolean[] visited = new boolean[v];
		LinkedList<Integer> res = new LinkedList<>();
		int i = 0;
		allTopoSortHelper(visited, res);
	}
	public void allTopoSortHelper(boolean[] visited, LinkedList<Integer> res) {
		int i = 0;
		int j;
		boolean flag = false;
		for (i = 0; i < v; i++) {
			if (indegree[i] == 0 && !visited[i]) {
				visited[i] = true;
				// remove this edge
				Iterator<Integer> it = adj[i].iterator();
				while(it.hasNext()) {
					j = it.next();
					indegree[j]--;
				}
				res.add(i);
				allTopoSortHelper(visited, res);
				visited[i] = false;
				it = adj[i].iterator();
				res.removeLast();
				while(it.hasNext()) {
					j = it.next();
					indegree[j]++;
				}
				flag = true;
			}
		}
		if (!flag) {
			ListIterator<Integer> it = res.listIterator();
			while (it.hasNext()) {
				System.out.print(it.next() + " ");
			}
			System.out.println(" ");
		}
	}
	
	
	public static void main(String[] args) {
		AllTopologicalSort ats = new AllTopologicalSort(6);
		ats.addEdge(5, 2);
		ats.addEdge(5, 0);
		ats.addEdge(4, 0);
		ats.addEdge(4, 1);
		ats.addEdge(2, 3);
		ats.addEdge(3, 1);
		
		System.out.println("All Topological sorts\n");
		ats.allTopoSort();
	}

}

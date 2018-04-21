package leetcodeAbove300;
/* 323 Number of connected components in an undirected graph
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to find the number of connected components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class NumberOfConnectComponentsInUndirectedGraph {

	// Use Union Find to figure out the number of connected components
	public int countComponents(int n, int[][] edges) {
		int count = n;
		int[] parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		for (int[] edge: edges) {
			int xParent = find(parent, edge[0]);
			int yParent = find(parent, edge[1]);
			
			if (xParent != yParent) {
				// vertices not in same subsets, merge them here
				// decrement count
				count--;
				parent[xParent] = yParent;
			}
		}
		return count;
	}
	
	/* iterative style to write find function */
//	private int find(int[] parent, int i) {
//		while (parent[i] != i) {
//			parent[i] = parent[parent[i]];
//			i = parent[i];
//		}
//		return i;
//	}
	
	/* I prefer recursive style here :) */
	private int find(int[] parent, int i) {
		if (parent[i] == i)
			return i;
		return find(parent, parent[i]);
	}
	

	public static void main(String[] args) {
		NumberOfConnectComponentsInUndirectedGraph noOfCC = new NumberOfConnectComponentsInUndirectedGraph();
		int[][] arrays = {{0,1}, {1,2}, {3,4}};
		System.out.println(noOfCC.countComponents(5, arrays)); // 2
		int[][] arrays_1 = {{0,1}, {1,2}, {2,3}, {3,4}};
		System.out.println(noOfCC.countComponents(5, arrays_1)); // 1
	}

}

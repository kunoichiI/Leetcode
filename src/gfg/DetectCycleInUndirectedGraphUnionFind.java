package gfg;

import java.util.Arrays;

/*
 * Java program for union-find algorithm to detect cycle in a graph
 * ref: https://www.geeksforgeeks.org/union-find/
 */
public class DetectCycleInUndirectedGraphUnionFind {
	static class Graph {
		int V, E; // V -> no. of vertices, E -> no. of edges
		Edge edge[];
		
		class Edge {
			int src, dest;
		}
		
		Graph(int v, int e) {
			V = v;
			E = e;
			edge = new Edge[E];
			for (int i = 0; i < E; i++) {
				edge[i] = new Edge();
			}
		}
		
		/*
		 * a utility function to find the subset of element i
		 */
		int find(int[] parent, int i) {
			if (parent[i] == -1)
				return i;
			return find(parent, parent[i]);
		}
		
		/*
		 * a utility function to union two subsets
		 */
		void union(int[] parent, int i, int j) {
			int iParent = find(parent, i);
			int jParent = find(parent, j);
			parent[iParent] = jParent;
		}
		
		/*
		 * This function check whether a given graph contains
		 * cycle or not
		 */
		boolean hasCycle(Graph g) {
			int[] parent = new int[g.V];
			// initialize parent array with -1
			for (int i = 0; i < g.V; i++) {
				parent[i] = -1;
			}
			// Iterate thought all edges of graph, find subset of both
			// vertices of every edge, if both subsets are same, then there
			// is cycle in graph
			for (int i = 0; i < g.E; i++) {
				int x = g.find(parent, g.edge[i].src);
				int y = g.find(parent, g.edge[i].dest);
				if (x == y) {
					// output parent array before return true
					System.out.println(Arrays.toString(parent));
					return true;
				}	
				g.union(parent, x, y);
			}
			return false;
		}
	}
	public static void main(String[] args) {
//		0
//		|  \
//		1 - 2
		int V = 3, E = 3;
		Graph g = new Graph(V, E);
		g.edge[0].src = 0;
		g.edge[0].dest = 1;
		g.edge[1].src = 1;
		g.edge[1].dest = 2;
		g.edge[2].src = 2;
		g.edge[2].dest = 0;
		
		System.out.println(g.hasCycle(g)); // true
	}

}

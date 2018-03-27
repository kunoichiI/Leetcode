package leetcodeAbove700;
/* 785 isBipartite
 * 	Given an undirected graph, return true if and only if it is bipartite.

	Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.
	
	The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
	
	Example 1:
	Input: [[1,3], [0,2], [1,3], [0,2]]
	Output: true
	Explanation: 
	The graph looks like this:
	0----1
	|    |
	|    |
	3----2
	We can divide the vertices into two groups: {0, 2} and {1, 3}.
	Example 2:
	Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
	Output: false
	Explanation: 
	The graph looks like this:
	0----1
	| \  |
	|  \ |
	3----2
	We cannot find a way to divide the set of nodes into two independent subsets.
	 
	
	Note:
	
	graph will have length in range [1, 100].
	graph[i] will contain integers in range [0, graph.length - 1].
	graph[i] will not contain i or duplicate values.
	The graph is undirected: if any element j is in graph[i], then i will be in graph[j].

 * */

import java.util.ArrayDeque;
import java.util.Queue;

public class IsGraphBipartite {
	public static boolean isBipartite(int[][] graph) {
		int[] colors = new int[graph.length];
        
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] != 0) continue;
            colors[i] = 1; // color this to red
            
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(i);
            
            while (!q.isEmpty()) {
                int val = q.poll();
                for (int neighbor: graph[val]) {
                    if (colors[neighbor] == 0) {
                        colors[neighbor] = -1 * colors[val];
                        q.offer(neighbor);
                    }
                    else {
                        if (colors[neighbor] == colors[val])
                            return false;
                    }
                }
            }
        }
        return true;
    }
	public static void main(String[] args) {
		int[][] graph = {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
		System.out.println("is Bipartite: " + isBipartite(graph)); // false
	}
	/*
	 * 解题思路：用color法，起点用一个颜色，然后neighbors用另一个颜色，如果遇到了相同颜色的neighbor，说明这个图不是Bipartite
	 */
}

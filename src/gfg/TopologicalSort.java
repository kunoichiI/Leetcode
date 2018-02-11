package gfg;
// GFG link: https://www.geeksforgeeks.org/topological-sorting/
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

//Topological Sorting (DFS + Stack)
//Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. 
//Topological Sorting for a graph is not possible if the graph is not a DAG.

public class TopologicalSort {
	
	public static void main(String[] args) {
		TopologicalSort ts = new TopologicalSort(6);
		ts.addEdge(5, 2);
		ts.addEdge(5, 0);
		ts.addEdge(4, 0);
		ts.addEdge(4, 1);
		ts.addEdge(2, 3);
		ts.addEdge(3, 1);
		
		System.out.println("Following is a Topological " + "sort of the given graph");
		ts.topologicalSort();
		System.out.println();
		
		// change order of nodes
		TopologicalSort ts1 = new TopologicalSort(6);
		ts1.addEdge(0, 5);
		ts1.addEdge(0, 1);
		ts1.addEdge(1, 2);
		ts1.addEdge(3, 2);
		ts1.addEdge(4, 3);
		ts1.addEdge(4, 5);
		
		System.out.println("Following is a Topological 1" + "sort of the given graph");
		ts1.topologicalSort();
		
		// Examples on runtime class initialization between array and list. They're different!
		// at runtime, array knows its element type while list doesn't care what element it has!
		
		// the parametrized type T does not exist at run-time, 
		// the compiler cannot assign a run-time  type to the array created.
		/*
		Double[] doubles = new Double[3];
		System.out.println("Class name of double array: " + doubles.getClass()); // class [Ljava.lang.Double
		
		String[] strings = new String[]{"hello", "world", "cruel"};
		System.out.println("Class name of string array: " + strings.getClass()); // => class [Ljava.lang.String
		
		ArrayList<Double> doubless = new ArrayList<>();
		doubless.add(1.00);
		doubless.add(3.45);
		doubless.add(4.56);
		System.out.println("class name of doubless list : " + doubless.getClass()); // => class java.util.ArrayList
		
		ArrayList<String> stringss = new ArrayList<>();
		stringss.add("hello");
		stringss.add("world");
		stringss.add("cruel");
		System.out.println("class name of stringss list : " + stringss.getClass()); // => class java.util.ArrayList
		*/
	}

	private int V; //No. of vertices
	
	// Array of list for adjacency list representation
	private LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	public TopologicalSort(int v) {
		V = v;
		adj = new LinkedList[v];
		//System.out.println("class name is : " + adj.getClass());
		for (int i = 0; i < v; i++) {  // can reach every vertex 
			adj[i] = new LinkedList<Integer>();
			//System.out.println(adj[i]);
		}
	}
	
	// Function to add an edge to graph
	public void addEdge(int u, int w) {
		adj[u].add(w);
	}
	
	void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
		visited[v] = true;
		Integer i;
		
		// Recur for all vertices adjacent to this vertex
		Iterator<Integer> it = adj[v].iterator();
		while (it.hasNext()) {
			i = it.next();
			if (!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}
		stack.push(v);
	}
	
	void topologicalSort() {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[V];
		
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	
	
	}
}

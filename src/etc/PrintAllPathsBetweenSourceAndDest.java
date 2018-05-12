package etc;
// ref: https://algorithms.tutorialhorizon.com/graph-print-all-paths-between-source-and-destination/
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * Objective: Given a graph, source vertex and destination vertex. 
 * Write an algorithm to print all possible paths between source and destination.

   This problem also known as “Print all paths between two nodes”
 */
public class PrintAllPathsBetweenSourceAndDest {
	/* time complexity: depends on connectivity between two nodes
	 * for a fully connected graph, the time can be O((v-2)!) */
	public static void printAllPaths(HashMap<Integer, List<Integer>> graph, boolean[] visited, int start, int end) {
		dfs(graph, start, end, visited, "");
	}
	
	public static void dfs(HashMap<Integer, List<Integer>> graph, int start, int end, boolean[] visited, String path) {
		visited[start] = true;
		String newPath = path + "->" + start;
		List<Integer> neighbors = graph.get(start);
		
		
		for (int i = 0; i < neighbors.size(); i++) {
			int node = neighbors.get(i);
			if (!visited[node] && node != end) {
				dfs(graph, node, end, visited, newPath);
			}
			else if (node == end) {
				System.out.println(newPath + "->" + end);
			}
		}
		
		visited[start] = false; // backtracking
	}
	
	public static void main(String[] args) {
		HashMap<Integer, List<Integer>> graph = new HashMap<>();
		graph.put(0, Arrays.asList(new Integer[]{1, 2}));
		graph.put(1, Arrays.asList(new Integer[]{2, 3}));
		graph.put(2, Arrays.asList(new Integer[]{3}));
		graph.put(3, Arrays.asList(new Integer[]{4}));
		graph.put(4, Arrays.asList(new Integer[]{0, 1, 5}));
		boolean[] visited = new boolean[6];
		printAllPaths(graph, visited, 0, 5);
		System.out.println("---------");
		printAllPaths(graph, visited, 2, 5);
	}

}

package leetcodeAbove300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumOfConnectedComponentsInUndirectedGraphDFS {
	public static int countComponents(int n, int[][] edges) {
		boolean[] visited = new boolean[n];
		Map<Integer, List<Integer>> map = new HashMap<>();
		// generate adjacency lists
		for (int[] edge: edges) {
			if (!map.containsKey((edge[0])))
					map.put(edge[0], new ArrayList<Integer>());
			map.get(edge[0]).add(edge[1]);
			if (!map.containsKey((edge[1])))
				map.put(edge[1], new ArrayList<Integer>());
			map.get(edge[1]).add(edge[0]);
		}
		
		int cnt = 0;
		for (int v = 0; v < n; v++) {
			if (!visited[v])
				cnt++;
			List<Integer> l = map.get(v);
			for (int i : l)
				visited[i] = true;
		}
		return cnt;
	}
	public static void main(String[] args) {
		int[][] arrays = {{0,1}, {1,2}, {3,4}};
		System.out.println(countComponents(5, arrays)); // 2
		int[][] arrays_1 = {{0,1}, {1,2}, {2,3}, {3,4}};
		System.out.println(countComponents(5, arrays_1)); // 1
		int[][] arrays_2 = {{0, 1}, {2,3}, {4,5}};
		System.out.println(countComponents(6, arrays_2)); // 3
	}
}

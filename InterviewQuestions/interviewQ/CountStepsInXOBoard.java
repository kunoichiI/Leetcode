package interviewQ;
// FB interview:
// given a board of 'X' & 'O' characters, from left to right, 'X' cannot pass, 'O' can pass,
// what is the minimum step to get to right? 

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// Follow up: the minimum step's path(shortest path, use map to track each index in the board)
public class CountStepsInXOBoard{
	static LinkedList<List<Integer>> res = new LinkedList<>();
	public static int countSteps(char[][] board) {
		int step = 0;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[board.length][board[0].length];
		Map<List<Integer>, List<Integer>> route = new HashMap<>();
		
		for (int i = 0; i < board.length; i++) { // start from left, any row in the left could be start point
			if (board[i][0] == 'O') {
				q.offer(new int[] {i, 0});
				visited[i][0] = true;
			}
		}
		int[][] walk = {{ -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }};
		while (!q.isEmpty()) {
			step++;
			int size = q.size();
			while (size > 0) {
				int[] cur = q.poll();
				//System.out.println("current coord is: " + cur[0] + " " + cur[1]);
				for (int i = 0; i < 4; i++) {
					int row = cur[0] + walk[i][0];
					int col = cur[1] + walk[i][1];
					if (col == board[0].length){ 
						//System.out.println("current row col is : " + row + " " + col);
						findRoute(res, route, cur[0], cur[1]);
						return step;
					}
					if (col < 0 || row < 0 || row >= board.length || col >= board[0].length || board[row][col] == 'X' || visited[row][col])
						continue;
					visited[row][col] = true;
					//System.out.println("row is " + row + " col is " + col);
					q.offer(new int[]{row, col});
					route.put(Arrays.asList(row, col), Arrays.asList(cur[0], cur[1])); // record previous coord
				}
				size--;
			}
		}
		return 0;
	}
	
	private static void findRoute(LinkedList<List<Integer>> res, Map<List<Integer>, List<Integer>> route, int row, int col) {
		res.add(Arrays.asList(row, col));
		while (route.containsKey(Arrays.asList(row, col))) {
			List<Integer> prev = route.get(Arrays.asList(row, col));
			res.addFirst(prev);
			row = prev.get(0);
			col = prev.get(1);
		}
		
	}

	// Followup: output the shortest path (use map to store each coord -> coord)
	public static void main(String[] args) {
		char[][] board ={ { 'X', 'X', 'O', 'O', 'O'},
						  {	'O', 'X', 'O', 'O', 'O'},
						  { 'O', 'O', 'O', 'O', 'O' },
						  { 'O', 'O', 'O', 'O', 'O' },
						  { 'O', 'O', 'O', 'O', 'O' }};
		
		System.out.println("Count the shortest path steps: " + countSteps(board));
		res.stream().forEach(System.out::println);
		}
	
}



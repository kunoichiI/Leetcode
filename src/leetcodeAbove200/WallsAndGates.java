package leetcodeAbove200;

//286. Walls and Gates
//You are given a m x n 2D grid initialized with these three possible values.
//
//-1 - A wall or an obstacle.
//0 - A gate.
//INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
//Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
//
//For example, given the 2D grid:
//INF  -1  0  INF
//INF INF INF  -1
//INF  -1 INF  -1
//  0  -1 INF INF
//
//After running your function, the 2D grid should be:
//  3  -1   0   1
//  2   2   1  -1
//  1  -1   2  -1
//  0  -1   3   4

public class WallsAndGates {
	public void wallsAndGates(int[][] rooms) {
		if (rooms.length == 0 || rooms == null) {
			return;
		}
		int m = rooms.length;
		int n = rooms[0].length;
		boolean[][] visited = new boolean[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rooms[i][j] == 0) {
					dfs(i, j, 0, visited, rooms);
				}
			}
		}
	}
	
	private void dfs(int i, int j, int distance, boolean[][] visited, int[][] rooms) {
		if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length || rooms[i][j] == -1) return;
		
		if (rooms[i][j] < distance) return; // meet walls
		
		visited[i][j] = true;
		rooms[i][j] = distance;
		
		// visit neighbors around rooms[i][j]
		dfs(i+1, j, distance+1, visited, rooms);
		dfs(i-1, j, distance+1, visited, rooms);
		dfs(i, j+1, distance+1, visited, rooms);
		dfs(i, j-1, distance+1, visited, rooms);
		
		visited[i][j] = false; //backtracking
		return;
		
	}
}

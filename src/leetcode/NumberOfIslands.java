package leetcode;

import java.util.*;
//200. Number of Islands  
//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
//Example 1:
//
//11110
//11010
//11000
//00000
//Answer: 1
//
//Example 2:
//
//11000
//11000
//00100
//00011
//Answer: 3

public class NumberOfIslands {
	
	// DFS solution
//	public int numIslands(char[][] grid) {
//        if (grid == null || grid.length == 0) {
//            return 0;
//        }
//        int result = 0;
//        boolean[][] visited = new boolean[grid.length][grid[0].length];
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (!visited[i][j] && grid[i][j] == '1') {
//                    dfs(grid, visited, i, j);
//                    result++;
//                }
//            }
//        }
//        return result;
//    }
//    
//    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
//        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == '0') {
//            return;
//        }
//        visited[i][j] = true;
//        dfs(grid, visited, i - 1, j);
//        dfs(grid, visited, i + 1, j);
//        dfs(grid, visited, i, j - 1);
//        dfs(grid, visited, i, j + 1);
//    }
	
	// BFS solution
	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					bfs(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}
	
	private void bfs(char[][] grid, int x, int y) { // fill neighbor which has '1's to '0'
		grid[x][y] = '0';
		int n = grid.length;
		int m = grid[0].length;
		LinkedList<Integer> queue = new LinkedList<>();
		int code = x * m + y;
		queue.offer(code);
		while(!queue.isEmpty()) {
			code = queue.poll();
			int i = code / m;
			int j = code % m;
			if (i > 0 && grid[i-1][j] == '1') { // Search upward and mark adjacent '1's as '0'
				queue.offer((i-1)*m + j);
				grid[i-1][j] = '0';
			}
			if (i < n-1 && grid[i+1][j]=='1') { // down
				queue.offer((i+1)*m + j);
				grid[i+1][j] = '0';
			}
			if (j > 0 && grid[i][j-1] =='1') { //left
				queue.offer(i*m + j -1);
				grid[i][j-1] = '0';
			}
			if (j < m-1 && grid[i][j+1] == '1') { //right
				queue.offer(i*m + j+1);
				grid[i][j+1] = '0';
			}
		}
	}
}

package leetcodeAbove400;

import java.util.ArrayList;
import java.util.List;

/*
 * 417. Pacific Atlantic Water Flow
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, 
 * the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

	Water can only flow in four directions (up, down, left, or right) from a cell 
	to another one with height equal or lower.
	
	Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
	
	Note:
	The order of returned grid coordinates does not matter.
	Both m and n are less than 150.
	Example:
	
	Given the following 5x5 matrix:
	
	  Pacific ~   ~   ~   ~   ~ 
	       ~  1   2   2   3  (5) *
	       ~  3   2   3  (4) (4) *
	       ~  2   4  (5)  3   1  *
	       ~ (6) (7)  1   4   5  *
	       ~ (5)  1   1   2   4  *
	          *   *   *   *   * Atlantic
	
	Return:
	
	[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */
public class PacificAtlanticWaterFlow {
	 int[] dx = { 0, 0, 1, -1 };
	 int[] dy = { 1, -1, 0, 0 };
	    
    public void flow(boolean[][] visited, int[][] matrix, int x, int y, int m, int n) {
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx <m && ny < n && !visited[nx][ny] && matrix[nx][ny] >= matrix[x][y]) {
                flow(visited, matrix, nx, ny, m, n);
            }     
        }
    }
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return ans;
        
        int m = matrix.length;
        int n = matrix[0].length; 
        
        boolean[][] pv = new boolean[m][n];
        boolean[][] av = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            flow(pv, matrix, i, 0, m, n); // left side pacific
            flow(av, matrix, i, n - 1, m, n); // right side atlantic
        }
        
        for (int i = 0; i < n; i++) {
            flow(pv, matrix, 0, i, m, n); // top side pacific
            flow(av, matrix, m - 1, i, m, n); // bottom side atlantic
        }
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (pv[row][col] && av[row][col])
                    ans.add(new int[]{row, col});
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * 经典的num of islands 解法，但是用的是两个visited 数组
	 * ，dfs找每一个可以flow的点，然后取两个visited的交集。
	 * 从Pacific和atlantic每条边所有点开始dfs，这道题也可以用BFS 和Union Find 做
	 */
}

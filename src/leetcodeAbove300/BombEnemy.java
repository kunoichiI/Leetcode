package leetcodeAbove300;
/* ref： http://www.cnblogs.com/grandyang/p/5599289.html
 * [LeetCode] Bomb Enemy 炸弹人
 	Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), 
	return the maximum enemies you can kill using one bomb.
	The bomb kills all the enemies in the same row and column from the planted point until it hits the wall 
	since the wall is too strong to be destroyed.
	Note that you can only put the bomb at an empty cell.
	
	Example:
	For the given grid
	
	0 E 0 0
	E 0 W E
	0 E 0 0
	
	return 3. (Placing a bomb at (1,1) kills 3 enemies)
 */
public class BombEnemy {
	public static int maxKilledEnemies(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int m = grid.length, n = grid[0].length;
		int res = 0, rowCnt = 0;
		int[] colCnt = new int[n];
		
		for (int row = 0; row < m; row++) {
			for (int col = 0; col < n; col++) {
				if (col == 0 || grid[row][col - 1] == 'W') {
					rowCnt = 0;
					for (int k = col; k < n && grid[row][k] != 'W'; k++) {
						if(grid[row][k] == 'E') rowCnt++;
					}
				}
				
				if (row == 0 || grid[row - 1][col] == 'W') {
					colCnt[col] = 0;
					for (int k = row; k < m && grid[k][col] != 'W'; k++) {
						if (grid[k][col] == 'E') colCnt[col]++;
					}
				}
				if (grid[row][col] == '0') {
					res = Math.max(res, rowCnt + colCnt[col]);
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		char[][] grid = {
				{ '0', 'E', '0', '0'},
				{ 'E', '0', 'W', 'E'},
				{ '0', 'E', '0', '0'}
		};
		System.out.println(maxKilledEnemies(grid)); // 3
	}

}

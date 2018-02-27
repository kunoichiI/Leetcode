package leetcodeAbove200;

public class NumberOfIslandsDFS { // My own solution with DFS, O(MxN) time, O(MxN) space
	public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int h = grid.length;
        int w = grid[0].length;
        int cnt = 0;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
            		System.out.println("we are at: " + grid[i][j]);
                if (visited[i][j] || grid[i][j] == '0') continue;
                cnt++;
                visit(grid, i, j, visited);

            }
        }
        return cnt;
    }
    
    public static void visit(char[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == '0')
            return;
        //if (!visited[i][j] && grid[i][j] == '1') {
        visited[i][j] = true;
        visit(grid, i - 1, j, visited);
        visit(grid, i + 1, j, visited);
        visit(grid, i, j - 1, visited);
        visit(grid, i, j + 1, visited);
        //}
    }
	public static void main(String[] args) {
//		11110
//		11010
//		11000
//		00000
		char[][] grid1 = { {'1', '1', '1', '1', '0'},
						   {'1', '1', '0', '1', '0'},
						   {'1', '1', '0', '0', '0'},
						   {'0', '0', '0', '0', '0'}};
//		11000
//		11000
//		00100
//		00011
		char[][] grid2 = { {'1', '1', '0', '0', '0'},
				   		   {'1', '1', '0', '0', '0'},
				           {'0', '0', '1', '0', '0'},
				           {'0', '0', '0', '1', '1'}};
		System.out.println("The number of islands for grid1 is: " + numIslands(grid1)); // => 1
		System.out.println("The number of islands for grid2 is: " + numIslands(grid2)); // => 3
	}

}

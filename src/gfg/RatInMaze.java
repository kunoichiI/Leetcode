package gfg;

//Backtracking | Set 2 (Rat in a Maze)
//We have discussed Backtracking and Knight’s tour problem in Set 1. 
//Let us discuss Rat in a Maze as another example problem that can be solved using Backtracking.
//
//A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., 
//maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to reach destination. 
//The rat can move only in two directions: forward and down.
//In the maze matrix, 0 means the block is dead end and 1 means the block can be used in the path from source to destination. 
//Note that this is a simple version of the typical Maze problem. For example, a more complex version can be that the rat can move in 4 directions and 
//a more complex version can be with limited number of moves.

public class RatInMaze {
	final int N = 4;
	public void printSolution(int[][] sol) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(" " + sol[i][j] + " ");
			}
			System.out.println();
		}
	}
	public boolean solveMaze(int[][] maze) {
		int[][] sol = {{0, 0, 0, 0},
	            {0, 0, 0, 0},
	            {0, 0, 0, 0},
	            {0, 0, 0, 0}
	        };
		if (solveMazeHelper(maze, 0, 0, sol) == false) {
			System.out.print("Solution doesn't exist");
            return false;
		}
		
		printSolution(sol);
		return true;
	}
	
	public boolean isSafe(int[][] maze, int x, int y) {
		// if (x,y outside maze) return false
		if (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1) {
			return true;
		}
		return false;
	}
	
	public boolean solveMazeHelper(int[][] maze, int x, int y, int[][] sol) {
		if (x == N-1 && y == N-1 && maze[x][y] == 1) {
			sol[x][y] = 1;
			return true;
		}
		
		if (isSafe(maze, x, y)) {
			sol[x][y] = 1;
			
			/* Move forward in x direction */
			if (solveMazeHelper(maze, x + 1, y, sol))
				return true;
			/* If moving in x direction doesn't give
               solution then Move down in y direction */
			if (solveMazeHelper(maze, x, y+1, sol))
				return true;
			/* If none of the above movements work then
            BACKTRACK: unmark x,y as part of solution
            path */
			sol[x][y] = 0;
			return false;
		}
		return false;
	}
	public static void main(String[] args) {
		RatInMaze rim = new RatInMaze();
		int maze[][] = {{1, 0, 0, 0},
	            {1, 1, 0, 1},
	            {0, 1, 0, 0},
	            {1, 1, 1, 1}
	        };
		rim.solveMaze(maze);

	}

}

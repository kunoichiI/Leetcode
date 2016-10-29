package leetcode;

//329. Longest Increasing Path in a Matrix  
//Given an integer matrix, find the length of the longest increasing path.
//
//From each cell, you can either move to four directions: left, right, up or down. 
//You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
//
//Example 1:
//
//nums = [
//  [9,9,4],
//  [6,6,8],
//  [2,1,1]
//]
//Return 4
//The longest increasing path is [1, 2, 6, 9].
//
//Example 2:
//
//nums = [
//  [3,4,5],
//  [3,2,6],
//  [2,2,1]
//]
//Return 4
//The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

public class LongestPathMatrix {
	 private int[] dx = new int[]{0, 0, -1, 1};
	    private int[] dy = new int[]{1, -1, 0, 0};
	    public int longestIncreasingPath(int[][] matrix) {
	        if (matrix == null || matrix.length == 0) {
	            return 0;
	        }
	         
	        int m = matrix.length;
	        int n = matrix[0].length;
	         
	        int max = 0;
	        int[][] dp = new int[m][n];
	         
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                max = Math.max(max, helper(i, j, matrix, dp));
	            }
	        }
	         
	        return max;
	    }
	     
	    private int helper(int row, int col, int[][] matrix, int[][] dp) {
	 
	        if (dp[row][col] > 0) {
	            return dp[row][col];
	        }
	         
	        int m = matrix.length;
	        int n = matrix[0].length;
	         
	        int curMax = 0;
	         
	        for (int i = 0; i < 4; i++) {
	            int x = dx[i] + row;
	            int y = dy[i] + col;
	             
	            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[row][col]) {
	                curMax = Math.max(curMax, helper(x, y, matrix, dp));
	            }
	        }
	         
	        dp[row][col] = curMax + 1;
	         
	        return curMax + 1;
	    }
}

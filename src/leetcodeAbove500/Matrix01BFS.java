package leetcodeAbove500;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 542. 01 Matrix
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

	The distance between two adjacent cells is 1.
	Example 1: 
	Input:
	
	0 0 0
	0 1 0
	0 0 0
	Output:
	0 0 0
	0 1 0
	0 0 0
	Example 2: 
	Input:
	
	0 0 0
	0 1 0
	1 1 1
	Output:
	0 0 0
	0 1 0
	1 2 1
	Note:
	The number of elements of the given matrix will not exceed 10,000.
	There are at least one 0 in the given matrix.
	The cells are adjacent in only four directions: up, down, left and right.
 */
public class Matrix01BFS {
	/* time: O(row x col), space: O(row x col) */
	public static int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;
        
        int w = matrix.length;
        int h = matrix[0].length;
        int[][] dist = new int[w][h];
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < w; row++) {
            for (int col = 0; col < h; col++) {
                if (matrix[row][col] == 1) dist[row][col] = Integer.MAX_VALUE;
                if (matrix[row][col] == 0) q.add(new int[]{row, col}); // add all 0s to queue
            }
        }
        
        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // all directions from one cell
        while (!q.isEmpty()) {
            int[] pair = q.poll();
            for (int i = 0; i < 4; i++) {
                int new_r = pair[0] + dir[i][0], new_c = pair[1] + dir[i][1];
                if (new_r >=0 && new_r < w && new_c >=0 && new_c < h) {
                    if (dist[new_r][new_c] > dist[pair[0]][pair[1]] + 1) {
                        dist[new_r][new_c] = dist[pair[0]][pair[1]] + 1;
                        q.add(new int[]{new_r, new_c});
                    }
                }
            }
        }
        return dist;
    }
	public static void main(String[] args) {

	}
	/*
	 * 解题思路： 用一个辅助矩阵，扫第一遍，把所有在matrix为0的坐标加入queue
	 * 进行BFS dequeue， 对每一个pop元素，搜索其邻居，如果邻居的distance是INT_MAX， 则说明matrix 中它为1
	 * 更新此点的distance，并把这个坐标加入queue。
	 */
}

package leetcode;

//Given a 2D array, print it in spiral form. See the following examples.
//
//Input:
//        1    2   3   4
//        5    6   7   8
//        9   10  11  12
//        13  14  15  16
//Output: 
//1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
//
//
//Input:
//        1   2   3   4  5   6
//        7   8   9  10  11  12
//        13  14  15 16  17  18
//Output: 
//1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11

public class SpiralPrint {
	public void spiralPrint(int[][] matrix) {
		int i, k = 0, l = 0; //k: start row index, l:start col index
		int m = matrix.length;  //m: row
		int n = matrix[0].length; //n: col
		
		while (k < m && l < n) {
			// Print the first row from remaining rows
			for (i = l; i < n; i++) {
				System.out.print(matrix[l][i] + " ");
			}
			k++; // After printing one row, increase k by 1
			
			// Print the last column from remaining columns
			for (i = k; i < m; i++) {
				System.out.print(matrix[i][n-1] + " ");
			}
			n--; // After printing one column, subtract n by 1
			
			// Print the last row from remaining rows
			if (k < m) {
				for (i = n-1; i >= l; i--) {
					System.out.print(matrix[m-1][i] + " ");
				}
				m--; // After printing one row, subtract m by 1;
			}
			
			// Print the first column from remaining column
			if (l < n) {
				for (i = m-1; i >= k; i--) {
					System.out.print(matrix[i][l] + " ");
				}
				l++; // After printing one column, increase l by 1;
			}
		}
	}
	public static void main(String[] args) {
		int[][] matrix = {
				           {1, 2, 3, 4},
				           {5, 6, 7, 8},
				           {9, 10, 11, 12},
				           {13, 14, 15, 16}
				           					};
		SpiralPrint sp = new SpiralPrint();
		sp.spiralPrint(matrix);

	}

}

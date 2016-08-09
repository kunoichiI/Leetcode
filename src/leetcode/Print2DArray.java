package leetcode;

import java.util.ArrayList;
import java.util.List;

//给一个二维数组，对角线打印
//
//例子：
//1 2 3 4
//5 6 7 8
//9 10 11 12
//
//打印出
//1
//2 5
//3 6 9
//4 7 10
//8 11
//12

public class Print2DArray {

	public List<List<Integer>> print2dArr(int[][] matrix) {
		List<List<Integer>> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
		int m = matrix.length;
		int n = matrix[0].length;
		int totalRow = m + n - 1;
		int sumOfRaC = 0;
		for (int i = 0; i < totalRow; i++) {
			for (int row = 0; row < m; row++) {
				for (int col = 0; col < n; col++) {
					if (col + row == sumOfRaC) {
						ArrayList<Integer> list = new ArrayList<>();
						list.add(matrix[row][col]);
						System.out.print(matrix[row][col] + " ");

					}
				}
			}
			System.out.println();
			sumOfRaC++;
		}
		return res;
	}
	
	
	
	public static void main(String[] args) {
		Print2DArray Arr = new Print2DArray();
		int[][] matrix = {
							{1, 2, 3, 4},
							{5, 6, 7, 8},
							{9, 10, 11, 12}
						 };
		List<List<Integer>> arr = Arr.print2dArr(matrix);
		}
		
		

}



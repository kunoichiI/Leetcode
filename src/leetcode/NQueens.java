package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (n < 0) {
			return res;
		}
		
		int[] columnVal = new int[n];
		DFS_helper(n, res, 0, columnVal);
		return res;
	}
	
	private static void DFS_helper(int nQueens, List<List<String>> res, int row,
			int[] columnVal) {
		if (row == nQueens) { // N queens have been put to board
			ArrayList<String> unit = new ArrayList<String>();
			for (int i = 0; i < nQueens; i++) {
				StringBuilder s = new StringBuilder();
				for (int j = 0; j < nQueens; j++) {
					if (j == columnVal[i]) {
						s.append("Q");   // if the column val of row i equals to its column, then Queen is placed there:)
					}else {
						s.append(".");
					}
				}
				unit.add(s.toString());  // after finishing one line, put into an ArrayList
			}
			res.add(unit);   // collect all lines for this solution
		}else {  // Still in the process of placing queens
			for (int i = 0; i < nQueens; i++) {
				columnVal[row] = i; // (row, columnVal[row]) ==> (row, i)
				
				if (isValid(row, columnVal)) {
					DFS_helper(nQueens, res, row + 1, columnVal);
				}
			}
			
		}
		
	}

	private static boolean isValid(int row, int[] columnVal) {
		for (int i = 0; i < row; i++) {
			if (columnVal[row] == columnVal[i] || Math.abs(columnVal[row] - columnVal[i]) == row -i) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int nQueens = Integer.parseInt(args[0]);
		List<List<String>> res = solveNQueens(nQueens);
		System.out.println("[");
		for (List<String> solution : res) {
			System.out.print("[");
			for (int i = 0; i < solution.size(); i++) {
				if (i < solution.size() - 1) {
					System.out.println(solution.get(i) + ",");
				}
				System.out.println(solution.get(i));
				
			}
			System.out.print("]" + ",");
			System.out.println();
		}
		System.out.print("]");
	}

}

package leetcode;

public class Search2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		int start = 0, end = m * n - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int midX = mid / n;
			int midY = mid % m;
			
			if (matrix[midX][midY] == target)
				return true;
			else if (matrix[midX][midY] < target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

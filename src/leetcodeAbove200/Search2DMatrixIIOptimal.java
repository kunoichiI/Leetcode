package leetcodeAbove200;

public class Search2DMatrixIIOptimal {
	public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int x = m - 1, y = 0;
        while (true) {
            if (matrix[x][y] > target) --x;
            else if (matrix[x][y] < target) ++y;
            else 
                return true;
            if (x < 0 || y >= n) break;
        }
        return false;
    }
	public static void main(String[] args) {
		int[][] matrix = {{1,   4,  7, 11, 15},
		                  {2,   5,  8, 12, 19},
		                  {3,   6,  9, 16, 22},
		                  {10, 13, 14, 17, 24},
		                  {18, 21, 23, 26, 30}};
		System.out.println(searchMatrix(matrix, 5)); // true
		System.out.println(searchMatrix(matrix, 20)); // false
	}

}

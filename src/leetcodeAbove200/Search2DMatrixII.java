package leetcodeAbove200;

public class Search2DMatrixII { // my solution, very slow but pass AC..
	// time complaxity: O(n ^2), space complexity: O(1)
	public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int startRow = 0, startCol = 0;
        
        while (startRow < m && startCol < n) {
            if (search(matrix, startRow, startCol, target)) return true;
            else {
                startRow++;
                startCol++;
            }
        }
        return false;
    }
    
    private static boolean search(int[][] matrix, int row, int col, int target) {
        // search row and search col
        if (target < matrix[row][col]) return false;
        for (int i = col; i < matrix[0].length; i++) {
            if (matrix[row][i] == target)
                return true;
        }
        for (int j = row; j < matrix.length; j++) {
            if (matrix[j][col] == target)
                return true;
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

package leetcode;

//Given a 2D array, find the maximum sum subarray in it. For example, in the following 2D array, 
//the maximum sum subarray is highlighted with blue rectangle and sum of this subarray is 29.


// 1   2  -1  -4 20
// -8 -3   4   2 1
// 3   8  10  1   3
// -4 -1   1  7  -6

// Top left( 1, 1)
// Bottom right(3, 3)
// Max Sum: 29

public class MaximumSumRectangle2DMatrix {
	
	public static int[] kadane(int[] arr) {
		// resule[0] = max_so_far, result[1] = start, result[1] = end --- find the maximum sum subarray
		int[] result = new int[] {Integer.MIN_VALUE, 0, -1};
		int max_end_here = 0;
		int local_start = 0; // record start point 
		for (int i = 0; i < arr.length; i++) {
			max_end_here += arr[i];
			if (max_end_here < 0) {
				max_end_here = 0;
				local_start = i + 1;
			}else if (max_end_here > result[0]) {
				result[0] = max_end_here;
				result[1] = local_start;
				result[2] = i;
			}
			
			// all numbers in array are negative
			if (result[2] == -1) { // so after call the first if block, we never enter the else if loop...
				result[0] = arr[0];
				for (int k = 1; k < arr.length; k++) {
					if (arr[i] > result[0]) {
						result[0] = arr[k];
						result[1] = k;
						result[2] = k;
					}
				}
			}
		}
		return result;
		
	}
	public static void findMaxMatrix(int[][] matrix) {
		int cols = matrix[0].length;
		int rows = matrix.length;
		int[] curRes = new int[3];
		int maxSum = Integer.MIN_VALUE;
		int left = 0;
		int top = 0;
		int right = 0;
		int bottom = 0;
		
		// find the maxSum of rectangle
		for (int leftCol = 0; leftCol < cols; leftCol++) {
			int[] tmp = new int[rows];
			for (int rightCol = leftCol; rightCol < cols; rightCol++) {
				for (int i = 0; i < rows; i++) {
					tmp[i] += matrix[i][rightCol];
				}
				curRes = kadane(tmp);
				if (curRes[0] > maxSum) {
					maxSum = curRes[0];
					left = leftCol;
					right = rightCol;
					top = curRes[1];
					bottom = curRes[2];
				}
			}
		}
		
		System.out.print("MaxSum: " + maxSum + ", range: [(" + left + ", " + top + ")(" + right + ", " + bottom + ")]");
	}
	
	
	public static void main(String[] args) {
//		int[] arr = {-2, -3, -1, -2, -1, -5, -3};
//		int[] res = kadane(arr);
//		for (int i : res) {
//			System.out.print(i + " ");
//		}

		findMaxMatrix(new int[][] {
            {1, 2, -1, -4, -20},
            {-8, -3, 4, 2, 1},
            {3, 8, 10, 1, 3},
            {-4, -1, 1, 7, -6}
            });
	}

}

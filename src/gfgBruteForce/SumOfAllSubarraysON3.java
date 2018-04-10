package gfgBruteForce;

/*
 * Time complexity: O(N ^ 3), Space : O(1)
 */
public class SumOfAllSubarraysON3 {
	public static int sumOfSubarrays(int[] arr) {
		int sum = 0;
		if (arr == null || arr.length == 0) return sum;
		for (int i = 0; i < arr.length; i++) { // i is the start index
			for (int j = i; j < arr.length; j++) { // j end index
				for (int k = i; k <= j; k++) { // collect all elements in the subarray
					sum += arr[k];
				}
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		System.out.print(sumOfSubarrays(arr)); // 20
		/* [1], [1,2], [1, 2, 3], [2], [2, 3], [3]
		 *  1 + 3 + 6 + 2 + 5 + 3 = 20
		 * */
	}

}

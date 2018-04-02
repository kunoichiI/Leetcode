package gfgBruteForce;
/* 
 * Given two sorted arrays of size m and n respectively, 
 * you are tasked with finding the element that would be at the k’th position of the final sorted array.

	Examples:
	
	Input : Array 1 - 2 3 6 7 9
	        Array 2 - 1 4 8 10
	        k = 5
	Output : 6
	Explanation: The final sorted array would be -
	1, 2, 3, 4, 6, 7, 8, 9, 10
	The 5th element of this array is 6.
	Input : Array 1 - 100 112 256 349 770
	        Array 2 - 72 86 113 119 265 445 892
	        k = 7
	Output : 256
	Explanation: Final sorted array is -
	72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
	7th element of this array is 256.
 */
public class KthElementInTwoSortedArrays {
	public static int kthElement(int[] arr1, int[] arr2, int k) {
		if (k < 0 || k >= arr1.length + arr2.length) return -1;
		if (arr1 == null || arr1.length == 0) return arr2[k - 1];
		if (arr2 == null || arr2.length == 0) return arr1[k - 1];
		
		int m = arr1.length, n = arr2.length;
		int[] merged = new int[m + n];
		int i = 0, j = 0, index = 0;
		while (i < m && j < n) {
			if (arr1[i] >= arr2[j]) {
				merged[index++] = arr2[j++];
			}
			else
				merged[index++] = arr1[i++];
		}
		while (i < m) {
			merged[index++] = arr1[i++];
		}
		while (j < n) {
			merged[index++] = arr2[j++];
		}
		return merged[k - 1];
	}
	public static void main(String[] args) {
		int[] arr1 = { 2, 3, 6, 7, 9};
		int[] arr2 = { 1, 4, 8, 10 };
		System.out.println(kthElement(arr1, arr2, 5)); // 6
	}

}

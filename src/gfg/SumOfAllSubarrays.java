package gfg;
/*
 * Sum of all Subarrays | Set 1
	Given an integer array ‘arr[]’ of size n, find sum of all sub-arrays of given array.
	
	Examples:
	
	Input   : arr[] = {1, 2, 3}
	Output  : 20
	Explanation : {1} + {2} + {3} + {2 + 3} + 
	              {1 + 2} + {1 + 2 + 3} = 20
	
	Input  : arr[] = {1, 2, 3, 4}
	Output : 50
	
	ref: https://www.geeksforgeeks.org/sum-of-all-subarrays/
 */
public class SumOfAllSubarrays {
	public static int sumOfSubarrays(int[] arr) {
		int sum = 0;
		if (arr == null || arr.length == 0) return sum;
		int n = arr.length;
        for (int i = 0; i < n; i++) {
            sum = (sum + arr[i] * (n - i) * (i + 1)) % 1000000007; // in case sum gets overflow, use modulo
        }
        return sum;
	}
	public static void main(String[] args) {
		int[] arr1 = { 935, 200, 141, 771, 73, 328, 452, 197, 883, 611, 495, 99, 393, 583, 954, 54, 803, 848 };
		int[] arr2 = { 617 };
		System.out.println(sumOfSubarrays(arr1)); // 522854
		System.out.println(sumOfSubarrays(arr2)); // 617
	}
	/*
	 * arr[] = [1, 2, 3], n = 3
	 * All subarrays: [1], [1,2], [1,2,3], [2], [2,3], [3]
	 * here first element 'arr[0]' appears 3 times
	 * second element 'arr[1]' appears 4 times
	 * third element 'arr[2]' appears 3 times.
	 * 
	 * Every element arr[i] appears in two types of subarrays:
	 * i) In subarrays beginning with arr[i], there are (n - i) such subarrays. For example arr[1] (2) appears
	 * in [2] and [2, 3]
	 * ii) In (n - i) * i subarrays where this element is not first element. For example arr[1] (2) appears
	 * in [1, 2] and [1, 2, 3]
	 * Total of above (i) and (ii) = (n - i) + (n - i) * i = (n - i) * (i + 1)
	 * 
	 * For arr[] = [1, 2, 3], sum of subarrays is:
	 * arr[0] * (n - 0) * (0 + 1) + arr[1] * (n - 1) * (1 + 1) + arr[2] * (n - 2) * (2 + 1) = 20
	 * 
	 */

}

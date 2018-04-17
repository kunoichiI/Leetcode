package gfg;
/*
 * Maximum subarray size, such that all subarrays of that size have sum less than k
Given an array of n positive integers and a positive integer k, 
the task is to find the maximum subarray size such that all subarrays of that size have sum of elements less than k.

	Examples:
	
	Input :  arr[] = {1, 2, 3, 4} and k = 8.
	Output : 2
	Sum of subarrays of size 1: 1, 2, 3, 4.
	Sum of subarrays of size 2: 3, 5, 7.
	Sum of subarrays of size 3: 6, 9.
	Sum of subarrays of size 4: 10.
	So, maximum subarray size such that all subarrays
	of that size have sum of elements less than 8 is 2.
	
	Input :  arr[] = {1, 2, 10, 4} and k = 8.
	Output : -1
	There is an array element with value greater than k,
	so subarray sum cannot be less than k.
	
	Input :  arr[] = {1, 2, 10, 4} and K = 14
	Output : 1
	ref: https://www.geeksforgeeks.org/maximum-subarray-size-subarrays-size-sum-less-k/
 */
public class MaximumSubarraySumLessThanK {
	public static int bsearch(int[] arr, int n, int k) {
		int ans = 0;
		// Do binary search for largest subarray size
		int left = 1, right = n;
		while (left <= right) {
			int mid = (left + right) / 2;
			// check for all subarrays after mid
			int i = 0;
			for (i = mid; i <= n; i++) {
				// Check if all the subarray of a size is less than k
				if (arr[i] - arr[i - mid] >= k)
					break;
			}
			// all subarrays of size mid have sum less than k
			if (i == n + 1) {
				left = mid + 1;
				ans = mid;
			}
			else {
				right = mid - 1;
			}
		}
		return ans;
	}
	
	public static int maxSize(int[] arr, int n, int k) {
		// Initialize prefix sum array 
		int[] prefixSum = new int[n + 1];
		for (int i = 0; i < n; i++) {
			prefixSum[i + 1] = prefixSum[i] + arr[i];
		}
		return bsearch(prefixSum, n, k);
	}
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4 }; 
		System.out.println(maxSize(arr1, 4, 8)); // 2
		int[] arr2 = { 1, 2, 10, 4 };
		System.out.println(maxSize(arr2, 4, 8)); // 0
		int[] arr3 = { 1, 2, 10, 4 };
		System.out.println(maxSize(arr3, 4, 14)); // 1
	}

}

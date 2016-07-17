package leetcode;

public class FindMaximumRepeatingNum {
	//Given an array of size n, the array contains numbers in range from 0 to k-1 where k is a positive integer and k <= n. Find the maximum repeating number in this array. 
	//For example, let k be 10 the given array be arr[] = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3}, the maximum repeating number would be 2. Expected time complexity is O(n) and extra space allowed is O(1). Modifications to array are allowed.
	static int maxRepeating(int[] arr, int n, int k) {
		// Iterate through input array, for every element arr[i], increment arr[arr[i]%k] by k
		for(int i = 0; i < arr.length; i++) {
			arr[arr[i]%k] += k;
		}
		// Find index of the maximum repeating element
		int max = arr[0], result = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
				result = i;
			}
		}
		return result;
		
	}
	public static void main(String[] args) {
		int arr[] = {2, 3, 3, 5, 3, 4, 1, 7};
        int n = arr.length;
        int k=8;
        System.out.println("Maximum repeating element is: " +  maxRepeating(arr,n,k));

	}

}

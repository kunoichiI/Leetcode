package leetcode;

import java.util.Arrays;

public class RotateArray {

	public void rotate(int[] nums, int k) {
		int length = nums.length;
		if (k > length) {
			k = k % length;
		}
		
		int nonRotatePart = length - k;
		reversal(nums, 0, nonRotatePart-1);
		reversal(nums, nonRotatePart, length - 1);
		reversal(nums, 0, length - 1);
		
	}
	
	public static void reversal(int[] arr, int left, int right) {
		if (arr == null || arr.length == 1) {
			return;
		}
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
	public static void main(String[] args) {
		int arr[] = {1, 9, 8, 4, 6, 0, 9};
		RotateArray ra = new RotateArray();
		ra.rotate(arr, 3);
		System.out.print(Arrays.toString(arr));

	}

}

package leetcode;

import java.util.Arrays;

//31. Next Permutation
//Implement next permutation, which rearranges numbers into the lexicographically 
//next greater permutation of numbers.
//
//If such arrangement is not possible, it must rearrange it as the lowest possible order 
//(ie, sorted in ascending order).
//
//The replacement must be in-place, do not allocate extra memory.
//
//Here are some examples. Inputs are in the left-hand column and 
//its corresponding outputs are in the right-hand column.
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
public class NextPermutation { // o(n) time, o(1) space
	public static void nextPermutation(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		// 从后往前，找到第一个下降的点
	    int i = nums.length - 2;
	    while (i >= 0 && nums[i] >= nums[i+1]) {
	       i--; 
	    }
	    
	    // 如果i >= 0, 说明这个数在数列内，找到一个稍微比这个大的数，进行调换
	    if (i >= 0) {
	        int j = nums.length - 1;
	        while (j >= 0 && nums[j] <= nums[i]) {
	            j--; // 151, 跳过倒数第一个j，所以是nums at j 小于等于 nums at i
	        }
	        System.out.println("i is: " + i + " j is : " + j);
	        swap(nums, i, j);        
	    }
	    // 不然说明整个序列都是升序的，输出一个reverse array
	    reverse(nums, i + 1, nums.length - 1);
	        
	}
	public static void reverse(int[] nums, int i , int j) {
	    while (i < j) {
	        swap(nums, i, j);
	        i++;
	        j--;
	    }
	}
	

	public static void swap(int[] nums, int i, int j) {
	    int tmp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = tmp;
	}
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3};
		System.out.println(Arrays.toString(arr));
		nextPermutation(arr);
		System.out.println(Arrays.toString(arr));
		
		int[] nums = { 1, 1 };
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}

}

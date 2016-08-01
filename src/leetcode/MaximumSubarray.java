package leetcode;

//53. Maximum Subarray 
//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//
//For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
//the contiguous subarray [4,−1,2,1] has the largest sum = 6.


// Solution 1: DAC Max(left max subarray, right max subarray, max cross subarray)
public class MaximumSubarray {

	public int maxSubArray(int[] nums) {
        return divide(nums, 0, nums.length-1);
    }
    
    public int divide(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }
        int mi = lo + (hi - lo)/2;
        return max(divide(nums, lo, mi), divide(nums, mi+1, hi), maxCrossArray(nums,lo, mi, hi));
    }
    
    public int maxCrossArray(int[] nums, int lo, int mi, int hi) {
        int sum = 0, left_sum = Integer.MIN_VALUE;
        for (int i = mi; i >= lo; i--) {
            sum += nums[i];
            if (sum > left_sum) {
                left_sum = sum;
            }
        }
        
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = mi+1; i <= hi; i++) {
            sum += nums[i];
            if (sum > right_sum) {
                right_sum = sum;
            }
        }
        return left_sum + right_sum;
    }
    
    public int max(int a, int b, int c) {
        return Math.max(Math.max(a, b),c);
    }
	public static void main(String[] args) {
		MaximumSubarray ms = new MaximumSubarray();
		int[] nums = {-2, 1, -3, 4, -1,2, 1, -5, 4};
		System.out.print(ms.maxSubArray(nums));

	}

}

// Solution 2: Kadane algorithm(1977)
//public class Solution {
//    public int maxSubArray(int[] nums) {
//        int max_end_here = 0, max_so_far = Integer.MIN_VALUE;
//        
//        for (int i = 0; i < nums.length; i++) {
//            if (max_end_here < 0) max_end_here = 0;
//            max_end_here += nums[i];
//            
//            max_so_far = Math.max(max_end_here, max_so_far);
//        }
//        return max_so_far;
//    }
//    
//}

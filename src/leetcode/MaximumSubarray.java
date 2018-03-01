package leetcode;

//53. Maximum Subarray 
//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//
//For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
//the contiguous subarray [4,−1,2,1] has the largest sum = 6.


// Solution 1: DAC Max(left max subarray, right max subarray, max cross subarray)
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
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
		int[] nums = {-2, -3, -1, -2, -1, -5, -3};
		int[] array1 = { -2, -1, -4, -168 };
		int[] array2 = { -2, -1, -4, 168 };
		int[] array3 = { 2, 1, 4, 168 };
		int[] array4 = {};
		int[] array5 = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int[] array6 = null;
		System.out.print(ms.maxSubArray(nums));
		
		System.out.println(ms.maxSubArray(array1)); // output 0, error! because Kadane algorithm doesn't take
		// an array of all negative numbers
		System.out.println(ms.maxSubArray(array2)); // output 168, correct!
		System.out.println(ms.maxSubArray(array3)); // output 175, correct!
		System.out.println(ms.maxSubArray(array4)); // output 0, correct!
		System.out.println(ms.maxSubArray(array5)); // output 7, correct!
		System.out.println(ms.maxSubArray(array6)); // output , correct!

	}

}



package leetcodeAbove100;

//167. Two Sum II - Input array is sorted
//
//Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
//
//The function twoSum should return indices of the two numbers such that they add up to the target, 
// where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
//
//You may assume that each input would have exactly one solution.
//
//Input: numbers={2, 7, 11, 15}, target=9
//Output: index1=1, index2=2

public class TwoSumII {
	public int[] twoSumII(int[] nums, int target) {
		int[] res = new int[2];
		
		int left = 0;
		int right = nums.length -1;
		while (left < right) {
			int tmp = nums[left] + nums[right];
			if (tmp == target) {
				res[0] = left + 1;
				res[1] = right + 1;
				return res;
			}else if (tmp < target) {
				//make tmp larger
				left++;
			}else {
				// make tmp smaller
				right--;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		int[] arr = {2, 7, 11, 15};
		int target = 9;
		TwoSumII tsi = new TwoSumII();
		int[] res = tsi.twoSumII(arr, target);
		if (res != null) {
			for (int i: res) {
				System.out.print(i + " ");
			}
		}else {
			System.out.print("No such two numbers exist");
		}
	}

}

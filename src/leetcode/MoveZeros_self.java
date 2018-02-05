package leetcode;
//283. Move Zeroes
//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
//
//Note:
//You must do this in-place without making a copy of the array.
//Minimize the total number of operations.
public class MoveZeros_self {
	public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int i = 0;
        for (; i< nums.length; i++) {
            if (nums[i] != 0)
                continue;
            int num1 = i;
            int num2 = findNonZero(nums, num1);
            
            if (num2 != -1) {
                swap(nums, num1, num2);
            }
        }
    }
    
    private int findNonZero(int[] nums, int i) {
        for (int k = i + 1; k < nums.length; k++) {
            if (nums[k] != 0)
                return k;
        }
        return -1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

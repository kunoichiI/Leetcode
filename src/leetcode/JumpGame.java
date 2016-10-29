package leetcode;
// 55. Jump game
// Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
// Each element in the array represents your maximum jump length at that position.
//
// Determine if you are able to reach the last index.
//
// For example:
// A = [2,3,1,1,4], return true.
//
// A = [3,2,1,0,4], return false.


public class JumpGame {
    public boolean canJump(int[] nums) {
        int size = nums.length;
        if (size <= 1) return true;
        int max = nums[0];

        for (int i = 0; i < size; i++) {
            if (max <= i && nums[i] == 0) return false;
            if (i + nums[i] > max){
                max = i + nums[i];
            }
            if (max >= size - 1) {
                return true;
            }
        }
        return false;
    }
}

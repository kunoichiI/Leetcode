package leetcode;

//75. Sort Colors  QuestionEditorial Solution  My Submissions
//Total Accepted: 107837
//Total Submissions: 304673
//Difficulty: Medium
//Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
//Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
//Note:
//You are not suppose to use the library's sort function for this problem.

public class SortColors {
	public void sortColors(int[] nums) {
        int n = nums.length;
        int redSt = 0, blueSt = n-1;
        int i = 0;
        while (i < blueSt + 1) {
            if (nums[i] == 0) {
                swap(nums, i, redSt);
                redSt++;
                i++;
                continue;
            }
            if (nums[i] == 2) {
                swap(nums, i, blueSt);
                blueSt--;
                continue;
            }
            i++;
        }
    }
    public static void swap(int[] A, int i, int j) {
       int tmp = A[i];
          A[i]=A[j];
          A[j]=tmp;
    }
}

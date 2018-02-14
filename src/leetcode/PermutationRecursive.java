package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//46. Permutations
//Given a collection of distinct numbers, return all possible permutations.
//
//For example,
//[1,2,3] have the following permutations:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
public class PermutationRecursive { // O(n!) time, O(n) space
	public static List<List<Integer>> permute(int[] nums) {
		 List<List<Integer>> res = new ArrayList<>();
	        if (nums == null || nums.length == 0)
	            return res;
        permute_helper(nums, 0, res);
        return res;
	}
	
	public static void permute_helper(int[] nums, int i, List<List<Integer>> res) {
		if (i == nums.length - 1) {
            List<Integer> lst = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                lst.add(nums[j]);
            }
            res.add(lst);
        }
        else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                permute_helper(nums, i + 1, res);
                swap(nums, i, j);
            }
        }	
	}
	
	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> res = permute(nums);
		res.stream().forEach(System.out::println);
	}

}

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
public class PermutationRecursive {
	public static List<List<Integer>> permute(int[] nums) {
		 List<List<Integer>> res = new ArrayList<>();
	        if (nums == null || nums.length == 0)
	            return res;
        permute_helper(nums, 0, res);
        System.out.println("After permutation, the original nums is: " + Arrays.toString(nums));
        return res;
	}
	
	public static void permute_helper(int[] nums, int i, List<List<Integer>> res) {
		if (i == nums.length - 1) {
            List<Integer> lst = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                lst.add(nums[j]);
            }
            res.add(lst);
            System.out.println("after adding list, the original array is: " + Arrays.toString(nums));
        }
        else {
            for (int j = i; j < nums.length; j++) {
            		System.out.println("Beginning swap, i is : " + i + " j is : " + j);
                swap(nums, i, j);
                permute_helper(nums, i + 1, res);
                swap(nums, i, j);
                System.out.println("end swap, i is : " + i + " j is : " + j);
                System.out.println("end swap, nums is : " + Arrays.toString(nums));
            }
        }	
	}
	
	private static void swap(int[] nums, int i, int j) {
		//System.out.println("before swap, i is: " + i + " j is: " + j);
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
		//System.out.println("after swap, i is: " + i + " j is: " + j);
	}
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		//System.out.println("nums is : " + nums.getClass());
		List<List<Integer>> res = permute(nums);
		res.stream().forEach(System.out::println);
	}

}

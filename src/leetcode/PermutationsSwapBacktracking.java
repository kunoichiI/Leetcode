package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationsSwapBacktracking {
	/*
	 * time complexity: This approach start from scratch, swap current index with its ahead element
	 * then backtracking to previous recursion level to swap the current with next elemet.
	 * The permute will reach n! base cases, the tree can have no more than n nodes per branch.
	 * swap method takes O(1) in each iteration.
	 * so the time complexity will be O(n * n!)
	 * space complexity will also be O(n * n!)
	 * Leetcode AC 5ms, among top 1%
	 */
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        permute(nums, 0, ans);
        return ans;
    }
    
    public static void permute(int[] nums, int i, List<List<Integer>> ans) {
        if (i == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int n: nums) {
                tmp.add(n);
            }
            ans.add(tmp);
            return;
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            permute(nums, i + 1, ans);
            swap(nums, i, j);
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4};
		int[] arr2 = {5, 100, 45 };
		List<List<Integer>> res1 = permute(arr1);
		res1.stream().forEach(System.out::println);
		System.out.println();
		List<List<Integer>> res2 = permute(arr2);
		res2.stream().forEach(System.out::println);

	}

}

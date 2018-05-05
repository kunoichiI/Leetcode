package leetcode;

import java.util.ArrayList;
import java.util.List;

// question same as Permutations
public class PermutationsDFS {  /* 这个方法也不错，但是貌似时间并没有优化。。*/
	/* time complexity: O(n * n!) space: O(n * n!) 
	 * Leetcode AC 6ms among top 15% I guess because array operations are faster than dynamic arrays ones*/
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		List<Integer> tmp = new ArrayList<>();
		permute_helper(nums, tmp, res, used);
		return res;
	}
	
	public static void permute_helper(int[] nums, List<Integer> tmp, List<List<Integer>> res, boolean[] used) {
		if (tmp.size() == nums.length) {
			List<Integer> lst = new ArrayList<>(tmp);
			System.out.println(lst);
			res.add(lst);
		}
		else { /* DFS, only add unvisited numbers */
			for (int i = 0; i < nums.length; i++) {
				if (used[i])
					continue;
				// if not used, make it true in used array first
				used[i] = true;
				tmp.add(nums[i]);
				permute_helper(nums, tmp, res, used);
				tmp.remove(tmp.size() - 1); /* Remove the last one, backtracking */
				used[i] = false;
			}
		}
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

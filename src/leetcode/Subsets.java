package leetcode;
import java.util.*;
//78. Subsets  
//Given a set of distinct integers, nums, return all possible subsets.
//
//Note: The solution set must not contain duplicate subsets.
//
//For example,
//If nums = [1,2,3], a solution is:
//
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]

public class Subsets {
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        Arrays.sort(nums);
        
        dfs(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
    
    public static void dfs(int[] nums, int start, ArrayList<Integer> tmp, List<List<Integer>> ans) {
        ans.add(new ArrayList<Integer>(tmp));
        for (int index = start; index < nums.length; index++) {
            tmp.add(nums[index]);
            dfs(nums, index + 1, tmp, ans);
            tmp.remove(tmp.size() - 1);
        }    
    }
    
    public static void main(String[] args) {
    		int[] arr = { 1, 2, 3 };
    		List<List<Integer>> res = subsets(arr);
    		System.out.print(res); // [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
    }
    /*
     * 解题思路： recursion + backtracking
     */
}

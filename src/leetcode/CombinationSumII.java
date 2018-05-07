package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 40. Combination Sum II
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

	Each number in candidates may only be used once in the combination.
	
	Note:
	
	All numbers (including target) will be positive integers.
	The solution set must not contain duplicate combinations.
	Example 1:
	
	Input: candidates = [10,1,2,7,6,1,5], target = 8,
	A solution set is:
	[
	  [1, 7],
	  [1, 2, 5],
	  [2, 6],
	  [1, 1, 6]
	]
	Example 2:
	
	Input: candidates = [2,5,2,1,2], target = 5,
	A solution set is:
	[
	  [1,2,2],
	  [5]
	]

 */
public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ans;
        Arrays.sort(candidates);
        //System.out.println("candidates are: " + Arrays.toString(candidates));
        dfs(candidates, target, 0, ans, new ArrayList<Integer>());
        return ans;
    }
    
    public void dfs(int[] candidates, int target, int startIdx, List<List<Integer>> ans, List<Integer> item) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = startIdx; i < candidates.length && target - candidates[i] >= 0; i++) {
            if (i > startIdx && candidates[i] == candidates[i - 1]) continue; // skip duplicates
            if (candidates[i] <= target) {
                item.add(candidates[i]);
                dfs(candidates, target - candidates[i], i + 1, ans, item);
                item.remove(item.size() - 1);
            }
        }
    }
}

package leetcode;

import java.util.*;
//39. Combination Sum  
//Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//The same repeated number may be chosen from C unlimited number of times.
//
//Note:
//All numbers (including target) will be positive integers.
//The solution set must not contain duplicate combinations.
//For example, given candidate set [2, 3, 6, 7] and target 7, 
//A solution set is: 
//[
//  [7],
//  [2, 2, 3]
//]

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        
        Arrays.sort(candidates);
        helper(candidates, target, res, item, 0);
        return res;
        
    }
    
    public void helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> item, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList(item));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i-1]) {
                continue; // skip duplicate elements
            }
            item.add(candidates[i]);
            int newtarget = target - candidates[i];
            helper(candidates, newtarget, res, item, i); // starting at i because same element can be reused unlimited times
            item.remove(item.size()-1);
        }
    }
}

package leetcode;

import java.util.*;
//39. Combination Sum  
//Given a set of candidate numbers (C) and a target number (T), 
//find all unique combinations in C where the candidate numbers sums to T.
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
	/* time complexity: because target is affecting the time of getting all answers,
	 * but in each array, we can have no more than 2^n answers, generally it takes n in helper method to get an anser
	 * therefore time complexity is approxiamately O(n * 2^n) */
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
            res.add(new ArrayList<Integer>(item));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
        		if (candidates[i] <= target) { // this if check will greatly improve time!
        			item.add(candidates[i]);
                int newtarget = target - candidates[i];
                helper(candidates, newtarget, res, item, i); // starting at i because same element can be reused unlimited times
                item.remove(item.size()-1);
        		}
        }
    }
    
    public static void main(String[] args) {
    	int[] candidates = {2, 3 , 6, 7};
    	int target = 7;
    	CombinationSum cs = new CombinationSum();
    	List<List<Integer>> res = cs.combinationSum(candidates, target);
    	System.out.print("[");
    	System.out.println();
    	for (List<Integer> list: res) {
    		System.out.println(list.toString());
    	}
    	System.out.println("]");
    }
}

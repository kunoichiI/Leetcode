package leetcodeAbove200;

import java.util.ArrayList;
import java.util.List;

/*
 * 216. Combination Sum III
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

	Note:
	
	All numbers will be positive integers.
	The solution set must not contain duplicate combinations.
	Example 1:
	
	Input: k = 3, n = 7
	Output: [[1,2,4]]
	Example 2:
	
	Input: k = 3, n = 9
	Output: [[1,2,6], [1,3,5], [2,3,4]]

 */
public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        //if (n > 45 || k > 9) return ans; // I do think this line should work on corner cases..
        dfs(k, n, ans, new ArrayList<Integer>(), 0);
        return ans;
    }
    
    public void dfs(int k, int n, List<List<Integer>> ans, List<Integer> item, int num) {
        if (k < 0 || n < 0) return;
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(item));
            return;
        }
        for (int i = num + 1; i <= 9 && n - i >= 0; i++) {
            item.add(i);
            dfs(k - 1, n - i, ans, item, i);
            item.remove(item.size() - 1);
        }
    }
}

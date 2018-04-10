package leetcode;

import java.util.ArrayList;
import java.util.List;
// leetcode AC 3ms Time complexity: ? Space complexity: ?
public class LetterCombinationsOfphoneNumberRecursion {
	public List<String> letterCombinations(String digits) {
        String[] map = new String[]{ "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        if (digits == null) return null;
        
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans; 
        }
        helper(digits, "", 0, ans, map);
        return ans;
    }
    
    public void helper(String s, String prefix, int idx, List<String> ans, String[] map) {
        if (s.length() == prefix.length()) {
            ans.add(prefix);
            return; // base case: prefix become same length as input string!
        }
        else {
            for(char c: map[s.charAt(idx) - '0'].toCharArray()) {
                helper(s, prefix + c, idx + 1, ans, map);
            }
        }
    }
    /*
     * 解题思路：从 n-1开始build， 比如“23”， 先把2 对应的“abc”逐一放入prefix中，然后递归call helper（prefix + c， idx + 1）
     * 直到prefix长度和digits相同，这时代表已有一个结果，加入到ans里。 这个灵感来自CTCI 第八章 Recursion and DP 以及
     * 递归时间复杂度分析。
     */
}

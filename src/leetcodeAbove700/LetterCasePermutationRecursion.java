package leetcodeAbove700;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutationRecursion {
	public static List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        if (S == null) return ans;
        
        dfs(S.toCharArray(), 0, ans);
        return ans;
    }
    
    public static void dfs(char[] s, int i, List<String> ans) {
        if (i == s.length) {
            ans.add(new String(s));
            return;
        }
        dfs(s, i + 1, ans);
        if (!Character.isLetter(s[i])) return;
        s[i] ^= 1 << 5;
        dfs(s, i + 1, ans);
        s[i] ^= 1 << 5;
    }
	public static void main(String[] args) {
		System.out.println(letterCasePermutation("a1b2")); // [ "a1b2", "A1b2", "a1B2", "A1B2"]
		System.out.println(letterCasePermutation("3z4")); // ["3z4", "3Z4"]
		System.out.println(letterCasePermutation("12345"));  // [ "12345" ]
	}
	/*
	 * 解题思路： 这实在是tricky！用Bit Manipulation 实现a 和A 自由转换 'a' ^= (1 << 5)  => 'A'
	 * 'A' ^= (1 << 5)  => 'a'
	 * 之所以在dfs method里call 两次dfs是因为 当前字符用小写和大写分别dfs一次。。。
	 */
}

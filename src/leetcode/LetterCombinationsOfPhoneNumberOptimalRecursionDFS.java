package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumberOptimalRecursionDFS {
	public static List<String> letterCombinations(String digits) {
        String[] dict = new String[]{ "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        StringBuilder sb = new StringBuilder();
        dfs(digits, dict, 0, res, sb);
        return res;
    }
    
    public static void dfs(String digits, String[] dict, int idx, List<String> res, StringBuilder temp) {
        if (idx == digits.length()) {
            res.add(temp.toString());
            return;
        }
        else {
            for (int i = 0; i < dict[digits.charAt(idx) - '0'].length(); i++) {
                temp.append(dict[digits.charAt(idx) - '0'].charAt(i));
                dfs(digits, dict, idx + 1, res,  temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
	public static void main(String[] args) {
		List<String> l = letterCombinations("3456");
		l.forEach(s -> System.out.print(s + " "));
	}

}

package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumberIterative {
	private static String[] map = new String[]{ "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	public static List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits.length() == 0) return res;
		res.add("");
		for (int i = 0; i < digits.length(); i++) {
			res = combine(map[digits.charAt(i) - '0'], res);
		}
		return res;
	}
	
	public static List<String> combine(String str, List<String> l) {
		List<String> res = new ArrayList<>();
		
		for (int i = 0; i < str.length(); i++) {
			for (String x : l) {
				res.add(x + str.charAt(i));
			}
		}
		return res;
	}
	public static void main(String[] args) {
		List<String> l = letterCombinations("34");
		l.forEach(s -> System.out.print(s + " "));
	}

}

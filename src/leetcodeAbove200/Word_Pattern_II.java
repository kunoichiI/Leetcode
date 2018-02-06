package leetcodeAbove200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//291. Word Pattern II
//Given a pattern and a string str, find if str follows the same pattern.
//
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
//
//Examples: pattern = "abab", str = "redblueredblue" should return true. pattern = "aaaa", str = "asdasdasdasd" should return true. pattern = "aabb", str = "xyzabcxzyabc" should return false. Notes: You may assume both pattern and str contains only lowercase letters.

public class Word_Pattern_II {
	Map<Character, String> map;
	Set<String> set;
	boolean res;
	
	public boolean wordPatternMatch(String pattern, String str) {
		map = new HashMap<Character, String>();  // Store pattern character and its mapping string
		set = new HashSet<String>();  // Store strings which are in bijection
		res = false;
		helper(pattern, str, 0, 0);
		return res;
	}
	
	public void helper(String pattern, String str, int i, int j) {
		if (i == pattern.length() && j == str.length()) {
			res = true;
			return;
		}
		if (i == pattern.length() || j == str.length()) return;
		
		// try every possible mapping relation between pattern and str
		char c = pattern.charAt(i);
		for (int cut = j + 1; cut <= str.length(); cut++) {
			String substr = str.substring(j, cut);
			if (!set.contains(substr) && !map.containsKey(c)) {
				map.put(c, substr);
				set.add(substr);
				helper(pattern, str, i+1, cut);
				map.remove(c);
				set.remove(substr);
			}else if (map.containsKey(c) && set.contains(substr)) {
				helper(pattern, str, i+1, cut);
			}
		}
	}
	
	public static void main(String[] args) {
		String pattern = "aba";
		String str = "aaaa";
		Word_Pattern_II wpi = new Word_Pattern_II();
		System.out.print(wpi.wordPatternMatch(pattern, str));
	}
}

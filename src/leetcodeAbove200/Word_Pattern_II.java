package leetcodeAbove200;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//291. Word Pattern II
//Given a pattern and a string str, find if str follows the same pattern.
//Here follow means a full match, such that there is a bijection 
// between a letter in pattern and a non-empty substring in str.
//
//Examples: pattern = "abab", str = "redblueredblue" should return true. 
//pattern = "aaaa", str = "asdasdasdasd" should return true. 
//pattern = "aabb", str = "xyzabcxzyabc" should return false. 
//Notes: You may assume both pattern and str contains only lowercase letters.

public class Word_Pattern_II {
	/*
	 * time complexity: The helper function get called at most O(2 ^ (lenOfPattern)
	 * in each node, the helper function runs O(lenOfStr) check
	 * so the total time is O(lenOfStr * 2 ^ (lenOfPattern))
	 * 
	 * space complexity is: O(lenOfStr * 2 ^ (lenOfPattern))
	 */
	public static boolean wordPatternMatch(String pattern, String str) {
		if (pattern == null && str == null) return true;
		if (pattern == null || str == null) return false;
		HashMap<Character, String> map = new HashMap<Character, String>();  // Store pattern character and its mapping string
		HashSet<String> set = new HashSet<String>();  // Store strings which are in bijection
		return helper(pattern, str, 0, 0, map, set);
	}
	
	public static boolean helper(String pattern, String str, int i, int j, HashMap<Character, String> map, HashSet<String> set) {
		if (i == pattern.length() && j == str.length()) return true;
		if (i >= pattern.length() || j >= str.length()) return false;
		
		// try every possible mapping relation between pattern and str
		char c = pattern.charAt(i);
		for (int cut = j + 1; cut <= str.length(); cut++) {
			String substr = str.substring(j, cut);
			if (!map.containsKey(c) && !set.contains(substr)) {
				map.put(c, substr);
				set.add(substr);
				if (helper(pattern, str, i+1, cut, map, set)) 
					return true;
				map.remove(c); // backtracking to get to previous recursion level
				set.remove(substr);
			}else if (map.containsKey(c) && map.get(c).equals(substr)) {
				if (helper(pattern, str, i+1, cut, map, set)) return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(wordPatternMatch("abab", "redblueredblue")); // true
		System.out.println(wordPatternMatch("aaaa", "xyzxzyxyzxyz")); // false
	}
}

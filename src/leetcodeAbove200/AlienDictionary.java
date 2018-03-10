package leetcodeAbove200;

import java.util.*;

//269 [Leetcode] Alien Dictionary
//There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
//Example 1:
//Given the following words in dictionary,
//[
//  "wrt",
//  "wrf",
//  "er",
//  "ett",
//  "rftt"
//]
//The correct order is: "wertf".
//Example 2:
//Given the following words in dictionary,
//[
//  "z",
//  "x"
//]
//The correct order is: "zx".
//Example 3:
//Given the following words in dictionary,
//[
//  "z",
//  "x",
//  "z"
//]
//The order is invalid, so return "".
//Note:
//You may assume all letters are in lowercase.
//You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
//If the order is invalid, return an empty string.
//There may be multiple valid order of letters, return any one of them is fine.
public class AlienDictionary { // O(n) time, O(n) space
	// reference link: http://fisherlei.blogspot.com/2017/07/leetcode-alien-dictionary-solution.html
	/* This solution is much shorter than the regular building graph then do topological sort solution! */
	public static String alienOrder(String[] words) {
		Map<Character, Set<Character>> inbounds = new HashMap<>();
		Map<Character, Set<Character>> outbounds = new HashMap<>();
		Set<Character> no_pre = new HashSet<>();
		
		String s = "";
		for (int i = 0; i < words.length; i++) {
			String t = words[i];
			for (char ch : t.toCharArray()) no_pre.add(ch);
			for (int idx = 0; idx < Math.min(s.length(), t.length()); idx++){
				char si = s.charAt(idx);
				char ti = t.charAt(idx);
				if (si != ti) {
					if (!inbounds.containsKey(ti))
						inbounds.put(ti, new HashSet<Character>());
					inbounds.get(ti).add(si);
					if (!outbounds.containsKey(si))
						outbounds.put(si, new HashSet<Character>());
					outbounds.get(si).add(ti);
					break;
				}
			}
			s = t;
		}
		
		int vertices = no_pre.size();
		// Remove all nodes from no_pre which has in-degree larger than 0
		for (char key: inbounds.keySet()) {
			if (no_pre.contains(key)) no_pre.remove(key);
		}
		
//		System.out.println("inbounds looks like: " + inbounds);
//		System.out.println("outbounds looks like: " + outbounds);
//		System.out.println("no_pre looks like: " + no_pre);
		
		String result = "";
		// start adding nodes which has in-degree equals to 0
		while (no_pre.size() > 0) {
			for (char ch: no_pre) {
				no_pre.remove(ch);
				result += ch;
//				System.out.println("result looks like: " + result);
//				System.out.println("ch is: " + ch);
//				System.out.println("outbounds has ch: " + outbounds.get(ch));
				if (outbounds.get(ch) != null) { // this is important, outbounds may not have this vertex!
					for (char a: outbounds.get(ch)) {
						inbounds.get(a).remove(ch);
						if (inbounds.get(a).size() == 0)
							no_pre.add(a);
					}
				}
			}
		}
		
		return result.length() == vertices ? result : "";
	}
	public static void main(String[] args) {
		String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
		System.out.println("result is: " + alienOrder(words)); // wertf
		
		String[] words1 = { "z", "x", "z" };
		System.out.println("result is: " + alienOrder(words1)); // ""
		
		String[] words2 = { "z", "x" };
		System.out.println("result is: " + alienOrder(words2)); // "zx"
	}

}
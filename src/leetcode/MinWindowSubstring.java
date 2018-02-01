package leetcode;

import java.util.Arrays;
import java.util.HashMap;

// 76 Question 和pramp的题目smallest substring of all unique characters 一摸一样，可以用hashmap加headIdx，tailIndex解决此问题。
//Given a string source and a string target, 
// find the minimum window in source which will contain all the characters in target.
//Notice If there is no such window in source that covers all characters in target, return the empty string "".
//If there are multiple such windows, you are guaranteed that there 
// will always be only one unique minimum window in source.
//Clarification Should the characters in minimum window has the same order in target?
//Not necessary.
//Example
//For source = "ADOBECODEBANC", target = "ABC", the minimum window is "BANC"
//Challenge
//Can you do it in time complexity O(n) ?

public class MinWindowSubstring { // Currently I only know pramp solution: use hashmap to record unique characters in target, then count how many times they show in source
	public static String minWindow(String source, String target) {
		String res = "";
		if (source == null || source.length() == 0 || target == null || target.length() == 0) {
			return res;
		}
		
		HashMap<Character, Integer> map = new HashMap<>();
		int headIdx = 0, tailIdx = 0, count = 0;
		// asume target has no duplicate characters
		for (int i = 0; i < target.length(); i++) {
			map.put(target.charAt(i), 0);
		}
		
		for (; tailIdx < source.length(); tailIdx++) {
			char ch = source.charAt(tailIdx);
			if (!map.containsKey(ch))
				continue;
			int tailCount = map.get(ch);
			if (tailCount == 0)
				count++;
			map.put(ch, tailCount + 1);
			
			while (count == target.length()) {
				int tempLength = tailIdx - headIdx + 1;
				if (tempLength == target.length())
					return source.substring(headIdx, tailIdx + 1);
				if (res == "" || tempLength < res.length())
					res = source.substring(headIdx, tailIdx + 1);
				
				// push headIdx forward to get minium substring
				char headChar = source.charAt(headIdx);
				if (map.containsKey(headChar)) {
					int headCount = map.get(headChar);
					headCount--;
					if (headCount == 0)
						count--;
					map.put(headChar, headCount);
				}
				headIdx++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		String source = "ADOBECODEBANC";
		String target = "ABC";
		System.out.print(minWindow(source, target));
		
		// so actually true is stored in stringbuilder as 't''r''u''e', and false too.. occupying 5 indices
//		StringBuilder sb = new StringBuilder(16);
//		sb.append(true);
//		printStringBuilder(sb);
//		
//		sb.append(" ");
//		sb.append(false);
//		printStringBuilder(sb);	
		// stream API to print odd numbers
//		Arrays.stream(new int[] {1, 2, 3})
//			  .filter(it -> it % 2 != 0)
//			  .forEach(System.out::println);
	}

}

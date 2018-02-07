package leetcode;

// Leetcode 3. Longest Substring Without Repeating Characters 
//Given a string, find the length of the longest substring without repeating characters.
//
//Examples:
//
//Given "abcabcbb", the answer is "abc", which the length is 3.
//
//Given "bbbbb", the answer is "b", with the length of 1.
//
//Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

public class LongestSubstringWithoutRepeating {
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) return 0;
        if (s.length() <= 1)
            return s.length();
        int prev = 0;
        boolean[] letter = new boolean[256];
        int max = 0;
        
        for (int i = 0; i < s.length(); i ++) {
            if (!letter[s.charAt(i)]) {
                letter[s.charAt(i)] = true;
            }else {
                while(s.charAt(prev) != s.charAt(i)) {
                    letter[s.charAt(prev)] = false;
                    prev++;
                }
                prev++;
            }
            max = Math.max(max, i + 1 - prev);
        }
        return max;
     }
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("bbbbb")); // => "b" (1)
		System.out.println(lengthOfLongestSubstring(null)); // => 0
		System.out.println(lengthOfLongestSubstring("pwwkew")); // => "kew" (3)
	}
}

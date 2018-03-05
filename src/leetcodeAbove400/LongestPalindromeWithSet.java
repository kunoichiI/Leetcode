package leetcodeAbove400;

import java.util.HashSet;

public class LongestPalindromeWithSet {
	public static int longestPalindrome(String s) {
		HashSet<Character> set = new HashSet<>();
		for (Character c : s.toCharArray()) {
			if (!set.contains(c))
				set.add(c);
			else 
				set.remove(c);
		} // after for loop, set has all elements which appear odd times in string s
		return s.length() - Math.max(0, set.size() - 1);
	}
	public static void main(String[] args) {
		String s = "abccccdd";
		System.out.println(longestPalindrome(s)); // 7
	}
	/*
	 * 解题思路： hashset用来添加字符，遇到重复的就移除，这样最后set里剩下的都是出现次数为奇数的字符。
	 * 如果set size为0， 则s.length（）是最大的回文字符串，如果不为0， 则s.length（） - set.size（）+1
	 * 是最大的回文字符串。
	 */
}

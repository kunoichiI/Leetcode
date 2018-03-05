package leetcodeAbove400;

import java.util.HashMap;
import java.util.Map;

//409. Longest Palindrome
//Given a string which consists of lowercase or uppercase letters, 
//find the length of the longest palindromes that can be built with those letters.
//
//This is case sensitive, for example "Aa" is not considered a palindrome here.
//Note:
//Assume the length of given string will not exceed 1,010.
//Example:
//
//Input:
//"abccccdd"
//
//Output:
//7
//Explanation:
//One longest palindrome that can be built is "dccaccd", whose length is 7.
public class LongestPalindrome { // O(n) time, O(n) space， 可以用 int arr代替hashmap，a-z, A-Z
	public static int longestPalindrome(String s) {
		if (s == null) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c))
                map.put(c, 1);
            else
                map.put(c, map.get(c) + 1);
        }
        int res = 0;
        boolean flag = false;
        for (Character c : map.keySet()) {
            res += map.get(c);
            if (map.get(c) % 2 == 1) {
                res -= 1;
                flag = true; 
            }
                
        }
        
        return flag ? res + 1 : res;
	}
	public static void main(String[] args) {
		String s = "abccccdd";
		System.out.println(longestPalindrome(s)); // 7
	}
	/*
	 * 解题思路：用哈希表记录每个字符出现次数，对于偶数个数的字符，直接添加次数到res
	 * 奇数的字符，记录次数 - 1，并且用一个boolean代表此表里含有奇数的value
	 * 最后用boolean值判断结果+ 1 还是直接输出res
	 */
}

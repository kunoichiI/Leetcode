package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
 * 3. Longest Substring Without Repeating Characters
 * 	Given a string, find the length of the longest substring without repeating characters.

	Examples:
	
	Given "abcabcbb", the answer is "abc", which the length is 3.
	
	Given "bbbbb", the answer is "b", with the length of 1.
	
	Given "pwwkew", the answer is "wke", with the length of 3. 
	Note that the answer must be a substring, 
	"pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepearingCharacters {
	public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        
        int max = 0;
        int start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!set.contains(ch))
                set.add(ch);
            else {
                max = Math.max(max, set.size());
                
                while (start < i && s.charAt(start) != ch) {
                    set.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
        }
        max = Math.max(set.size(), max);
        return max;
    }
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("z")); // 1
		System.out.println(lengthOfLongestSubstring("abccab")); // 3
	}
	/*
	 * 解题思路：另外一种解法用了布尔数列存每一位的出现与否：true or false，第一次出现设为true，第二次出现设为false并清空start之前所有的true
	 * 这种解法使用hashset做一样的事情，hashset可以自动求出当前非重复的size！然后移除所有除dup之外的字符，更新start到i
	 * 继续循环到i抵达数列尾部。记得最后一次也要比较set size和max数值，取较大的那一个为最后结果！
	 */

}

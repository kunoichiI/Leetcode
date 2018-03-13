package lintCode;
/*
 * 384. Longest Substring Without Repeating Characters (Leetcode 3)
 * 	Given a string, find the length of the longest substring without repeating characters.
 * Example
	For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
	which the length is 3.
	
	For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingCharacters { // o(n) time, o(1) space
	public static int lengthOfLongestSubstring(String s) {
	        if (s == null) return 0;
	        
	        boolean[] arr = new boolean[256];
	        int result = 0;
	        int start = 0;
	        
	        for (int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            if (arr[c]) {
	                result = Math.max(result, i - start);
	                for (int k = start; k < i; k++) {
	                    if (s.charAt(k) == c) {
	                        start = k + 1;
	                        break;
	                    }
	                    arr[k] = false;
	                }
	            }
	            else 
	                arr[c] = true;
	        }
	        result = Math.max(s.length() - start, result);
	        return result;
    }
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("z")); // 1
		System.out.println(lengthOfLongestSubstring("abccab")); // 3
	}
	/*
	 * 解题思路： 用256位布尔数列记录当前字符是否出现，如果布尔值为false，设为true
	 * 如果布尔值为true，则说明当前位字符是duplicate重复值，所以在这一位更新start起点，把起点前的所有布尔值重新
	 * 设置为false。计算从start到这一点的长度，与res进行对比。直到循环结束，最后比较一次计算长度和result的值，取较大的那一个
	 */
}

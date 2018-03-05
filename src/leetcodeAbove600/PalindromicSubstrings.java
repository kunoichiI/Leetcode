package leetcodeAbove600;
//647. Palindromic Substrings
//Given a string, your task is to count how many palindromic substrings in this string.
//
//The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
//
//Example 1:
//Input: "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
//Example 2:
//Input: "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
public class PalindromicSubstrings {
	public static int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            count += countPalindrome(s, i, i); // palindrom length is odd and i in the middle  
            count += countPalindrome(s, i - 1, i); // palindrom length is even and (i-1, i) in themiddle  
        }
        return count;
    }
	
	private static int countPalindrome(String str, int start, int end) {
        int count = 0;
        while (start >= 0 && end < str.length()) {
            if (str.charAt(start) != str.charAt(end)) break;
            count++;
            start--;
            end++;
        }
        return count;
    }
    
	public static void main(String[] args) {
		String s = "abc";
		System.out.println(countSubstrings(s)); // => 3
		
		String s1 = "aaa";
		System.out.println(countSubstrings(s1)); // => 6
	}

	/*
	 * 
	 */
}

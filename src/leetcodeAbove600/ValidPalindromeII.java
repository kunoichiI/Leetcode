package leetcodeAbove600;
//680. Valid Palindrome II
//Given a non-empty string s, you may delete at most one character. 
//Judge whether you can make it a palindrome.
//
//Example 1:
//Input: "aba"
//Output: True
//Example 2:
//Input: "abca"
//Output: True
//Explanation: You could delete the character 'c'.
//Note:
//The string will only contain lowercase characters a-z. 
//The maximum length of the string is 50000.

public class ValidPalindromeII {
	public static boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        if (isPalindrome(s, 0, s.length() - 1)) return true;
        // dealing with non palindrom case
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            left++;
            right--;
        }
        return true;
    }
    
    public static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
	public static void main(String[] args) {
		String s = "abca";
		System.out.println("is Palindrome: " + validPalindrome(s)); // true
	}

}

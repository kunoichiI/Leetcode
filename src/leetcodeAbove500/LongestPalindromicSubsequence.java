package leetcodeAbove500;
//516. Longest Palindromic Subsequence
//Given a string s, find the longest palindromic subsequence's 
//length in s. You may assume that the maximum length of s is 1000.
//
//Example 1:
//Input:
//
//"bbbab"
//Output:
//4
//One possible longest palindromic subsequence is "bbbb".
//Example 2:
//Input:
//
//"cbbd"
//Output:
//2
//One possible longest palindromic subsequence is "bb".
public class LongestPalindromicSubsequence { // Dynamic Programming wih a 2D array to store subproblems results
	public static int longestPalindromeSubseq(String s) {
        // dynamic programming 
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[][] dp = new int[len][len];
        
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else 
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][len - 1];
    }
	public static void main(String[] args) {
		System.out.println(longestPalindromeSubseq("bbbab")); // 4
		System.out.println(longestPalindromeSubseq("cbbd")); // 2
	}
	/*
	 * 解题思路： 搞清楚optimal substructure，比如bbbab， 最左b和最右b相同，所以bba的最大回文subsequence
	 * 加上2 就是bbbab的最大回文。 cbba，c和a不一样，所以cbb或者bba的最大回文是cbba的最大回文
	 * if (str.charAt(0) == str.charAt(n - 1)  L(0, n - 1) = L(1, n - 2) + 2
	 * else L(0, n - 1) = max(L(1, n - 1), L(0, n - 2))
	 */

}

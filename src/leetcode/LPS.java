package leetcode;

// Given a sequence, find the length of the longest palindromic subsequence in it.
// For example, if the given sequence is “BBABCBCAB”, then the output should be 7
// as “BABCBAB” is the longest palindromic subseuqnce in it. “BBBBB” and “BBCBB”
// are also palindromic subsequences of the given sequence, but not the longest ones.

// naive solution
// int lps(char[] arr, int i, int j) {
// Base case 1: only one character
// if (i == j) return 1;
// Base case 2: only two same characters
// if (arr[i] == arr[j] && i+1 = j) return 2;
// if (arr[i] == arr[j]) return lps(arr, i+1, j-1) + 2;
// return max(lps(arr, i+1, j), lps(arr, i, j-1));

public class LPS {
	// Dynamic Programming, cut unnecessary overlapping subproblems computing
	
}

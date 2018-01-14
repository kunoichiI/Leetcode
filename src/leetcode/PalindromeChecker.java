package leetcode;

public class PalindromeChecker {
	// two pointers + recursive solution
	public static boolean isPalindrome(String str, int lo, int hi) {
		// If there's only one character
		if (lo == hi) return true;
		
		// If first and last did not match
		if (str.charAt(lo) != str.charAt(hi)) return false;
		
		// else use recursion on substring
		if (lo + 1 < hi) {
			return isPalindrome(str, lo + 1, hi - 1);
		}
		return true;
	}
	
	public static boolean isPalin(String str) {
		if (str == null) return false;
		int n = str.length();
		if (n == 0) return true;
		
		return isPalindrome(str, 0, n - 1); 
	}
	public static void main(String[] args) {
		String s1 = "";
		String s2 = "malayalam";
		String s3 = "Toyota";
		String s4 = "LmaoYoamL";
		
		System.out.println(isPalin(s1));
		System.out.println(isPalin(s2));
		System.out.println(isPalin(s3));
		System.out.println(isPalin(s4));
	}

}

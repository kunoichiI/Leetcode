package etc;
//Dynamic Programming
//Examples:
//LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
//LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
public class LCS {
	public static int lcs(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) return 0;
		return helper(s1, s2, s1.length(), s2.length());	
	}
	
	private static int helper(String s1, String s2, int idx1, int idx2) {
		if (idx1 == 0 || idx2 == 0) return 0;
		if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1))
			return 1 + helper(s1, s2, idx1 - 1, idx2 - 1);
		else 
			return Math.max(helper(s1, s2, idx1 - 1, idx2), helper(s1, s2, idx1, idx2 - 1));
	}
	public static void main(String[] args) {
		String s1 = "ABCDGH";
		String s2 = "AEDFHR";
		System.out.println(lcs(s1, s2)); // 3
		
		String s3 = "AGGTAB";
		String s4 = "GXTXAYB";
		System.out.println(lcs(s3, s4)); // 4
		
	}

}

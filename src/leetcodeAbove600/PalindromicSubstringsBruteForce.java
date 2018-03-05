package leetcodeAbove600;
// This solution has errors, don't use. Optimize it later...
public class PalindromicSubstringsBruteForce {
	public static int countSubstrings(String s) {
		int res = 0;
        if (s == null || s.length() == 0) return res;
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (!isPalindrome(s.substring(i, j)))
                    break;
                res++;
            }
        }
        return res;
	}
	
	public static boolean isPalindrome(String str) {
		int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
        }
        return true;
	}
	public static void main(String[] args) {
		String s = "abc";
		System.out.println(countSubstrings(s)); // => 3
		
		String s1 = "aaa";
		System.out.println(countSubstrings(s1)); // => TLE error...
	}

}

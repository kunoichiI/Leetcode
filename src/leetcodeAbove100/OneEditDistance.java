package leetcodeAbove100;
/* 161 One Edit Distance
 * Check if edit distance between two strings is one
	An edit between two strings is one of the following changes.
	
	Add a character
	Delete a character
	Change a character
	Given two string s1 and s2, find if s1 can be converted to s2 with exactly one edit. Expected time complexity is O(m+n) where m and n are lengths of two strings.
	
	Examples:
	
	Input:  s1 = "geeks", s2 = "geek"
	Output: yes
	Number of edits is 1
	
	Input:  s1 = "geeks", s2 = "geeks"
	Output: no
	Number of edits is 0
	
	Input:  s1 = "geaks", s2 = "geeks"
	Output: yes
	Number of edits is 1
	
	Input:  s1 = "peaks", s2 = "geeks"
	Output: no
	Number of edits is 2
 */
public class OneEditDistance {
	public static boolean isOneEdit(String s1, String s2) {
        if (s1.equals(s2) || Math.abs(s1.length() - s2.length()) >= 2) return false;
        
        int diff = 0;
        int i = 0, j = 0;
        int m = s1.length(), n = s2.length();
        
        // s1 not equal to s2, and the maximum length diff is 1
            // check how many words difference
        while (i < m && j < n) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (diff == 1) return false;
                
                if (m > n)
                    i++;
                else if (m < n)
                    j++;
                else {
                    i++;
                    j++;
                }
                diff++;
            }
            else {
                i++;
                j++;
            }
        }
        // if last charater is extra, remember to increment diff here
        if (i < m || j < n)
            diff++;
        return diff == 1;
        
    }

    public static void main(String args[]) {
        System.out.println(isOneEdit("geeks", "geaks")); // true 
        System.out.println(isOneEdit("geeks", "geeksfg")); // false
        System.out.println(isOneEdit("geeks", "peaks")); // false
        System.out.println(isOneEdit("geeks", "geek")); // true 
    }
    /*
     * 可以用DP做。。时间复杂度会高，这个是O（N）
     */
}

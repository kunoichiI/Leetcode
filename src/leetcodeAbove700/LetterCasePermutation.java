package leetcodeAbove700;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 784. Letter Case Permutation
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  
 * Return a list of all possible strings we could create.

	Examples:
	Input: S = "a1b2"
	Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
	
	Input: S = "3z4"
	Output: ["3z4", "3Z4"]
	
	Input: S = "12345"
	Output: ["12345"]

 */
/* Time complexity: O(MN) space: O(N)*/
public class LetterCasePermutation {
	public static List<String> letterCasePermutation(String S) {
        Set<String> allCombs = new HashSet<>();
        
        if (S == null) return new ArrayList<String>(allCombs);
        allCombs.add(S);
        
        for (int i = 0; i < S.length(); i++) {
            Set<String> combs = new HashSet<>();
            for (String str : allCombs) {
                char c = str.charAt(i);
                if (Character.isLowerCase(c))
                    combs.add(str.substring(0, i) + Character.toUpperCase(str.charAt(i)) + str.substring(i + 1));
                else
                    combs.add(str.substring(0, i) + Character.toLowerCase(str.charAt(i)) + str.substring(i + 1));
            }
            allCombs.addAll(combs);
        }
        return new ArrayList<String>(allCombs);
    }
	public static void main(String[] args) {
		System.out.println(letterCasePermutation("a1b2")); // [ "a1b2", "A1b2", "a1B2", "A1B2"]
		System.out.println(letterCasePermutation("3z4")); // ["3z4", "3Z4"]
		System.out.println(letterCasePermutation("12345"));  // [ "12345" ]
	}

}

package leetcodeAbove100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 139. Word Break
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words. 
 * You may assume the dictionary does not contain duplicate words.

	For example, given
	s = "leetcode",
	dict = ["leet", "code"].
	
	Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreakBruteForceRecursion {
	public static boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) return true; // base case
        for (int i = 1; i <= s.length();i++) {
            String sub = s.substring(0, i);
            String remain = s.substring(i);
            if (wordDict.contains(sub) && wordBreak(remain, wordDict))
                return true;
        }
        return false;
    }
	public static void main(String[] args) {
		List<String> wordDict = new ArrayList<>();
//		{ i, like, sam, sung, samsung, mobile, ice, 
//			  cream, icecream, man, go, mango}
		wordDict.addAll(Arrays.asList(new String[]{"i", "like", "sung", "samsung", "mobile", "ice", "cream", "icecream", "man", "go", "mango"}));
		wordDict.forEach(s -> System.out.print(s + " "));
		System.out.println();
		System.out.println(wordBreak("ilike", wordDict)); // true
		System.out.println(wordBreak("ilikemangoicecreamcream", wordDict)); // true
		System.out.println(wordBreak("youlike", wordDict)); // false
	}

}

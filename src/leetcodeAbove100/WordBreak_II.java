package leetcodeAbove100;

import java.util.*;
//140. Word Break II  
//Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
//
//Return all such possible sentences.
//
//For example, given
//s = "catsanddog",
//dict = ["cat", "cats", "and", "sand", "dog"].
//
//A solution is ["cats and dog", "cat sand dog"].

public class WordBreak_II {
	public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        return wordBreakHelper(s, wordDict, map);
    }
    
    public ArrayList<String> wordBreakHelper(String s, Set<String> wordDict, Map<String, ArrayList<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        ArrayList<String> result = new ArrayList<>();
        int n = s.length();
        if (n <= 0) return result;
        
        for (int len = 1; len <= n; len++) {
            String sub = s.substring(0, len);
            if (wordDict.contains(sub)) {
                if (len == n)
                    result.add(sub);
                else {
                    String prefix = s.substring(len);
                    ArrayList<String> tmp = wordBreakHelper(prefix, wordDict, memo);
                    for (String item : tmp) {
                        item = sub + " " + item;
                        result.add(item);
                    }
                }
            }
        }
        memo.put(s, result);
        return result;
    }
}

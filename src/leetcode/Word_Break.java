package leetcode;

import java.util.Arrays;
import java.util.Set;

//139. Word Break  
//Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//For example, given
//s = "leetcode",
//dict = ["leet", "code"].
//
//Return true because "leetcode" can be segmented as "leet code".


public class Word_Break {
	public boolean wordBreak(String s, Set<String> wordDict) {
        int[] pos = new int[s.length() + 1];
        
        Arrays.fill(pos, -1);
        pos[0] = 0;  // start status
        
        for (int i = 0; i < s.length(); i ++) {
            if (pos[i] != -1) {
                for (int j = i+1; j<= s.length(); j++) {
                    String sub = s.substring(i, j);
                    if (wordDict.contains(sub)) {
                        pos[j] = i; // pos[j] is the place to break string s
                    }
                }
            }
        }
        return pos[s.length()]!= -1;  // check if string is broken into all words in wordDict
        
    }
}

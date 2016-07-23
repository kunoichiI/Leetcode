package leetcode;

import java.util.HashMap;
import java.util.Map;

//Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
//
//Example:
//Given "bcabc"
//Return "abc"
//
//Given "cbacdcbc"
//Return "acdb"
public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Map<Character, Integer> lastPostMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastPostMap.put(s.charAt(i), i);
        }
        
        char[] res = new char[lastPostMap.size()];
        int begin = 0, end = findMinLastPos(lastPostMap);
        for (int i = 0; i < res.length; i++) {
            char minChar = 'z' + 1;
            for (int k = begin; k <= end; k++) {
                if (lastPostMap.containsKey(s.charAt(k)) && s.charAt(k) < minChar) {
                    minChar = s.charAt(k);
                    begin = k + 1;
                }
            }
            res[i] = minChar;
            if (i == res.length -1) break;
            
            lastPostMap.remove(minChar);
            if (s.charAt(end) == minChar) end = findMinLastPos(lastPostMap);
            
        }
        return new String(res);
    }
    
    private int findMinLastPos(Map<Character, Integer> map) {
        if (map == null || map.isEmpty()) {
            return -1;
        }
        int minLastPos = Integer.MAX_VALUE;
        for (int lastPos: map.values()) {
            minLastPos = Math.min(minLastPos, lastPos);
        }
        return minLastPos;
    }
}

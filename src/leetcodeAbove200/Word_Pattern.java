package leetcodeAbove200;

import java.util.HashMap;

//290. Word Pattern  QuestionEditorial Solution  My Submissions
//Total Accepted: 45635
//Total Submissions: 149860
//Difficulty: Easy
//Given a pattern and a string str, find if str follows the same pattern.
//
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
//
//Examples:
//pattern = "abba", str = "dog cat cat dog" should return true.
//pattern = "abba", str = "dog cat cat fish" should return false.
//pattern = "aaaa", str = "dog cat cat dog" should return false.
//pattern = "abba", str = "dog dog dog dog" should return false.
//Notes:
//You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.


public class Word_Pattern {
	public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if(map.get(c).equals(strs[i])) continue;
                else {return false;}
            }else {
                if (map.values().contains(strs[i])) return false;
                else {
                    map.put(c, strs[i]);
                }
            }
        }
        return true;
    }
}

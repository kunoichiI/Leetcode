package leetcodeAbove200;
/*
 * 205. Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.

	Two strings are isomorphic if the characters in s can be replaced to get t.
	
	All occurrences of a character must be replaced with another character while 
	preserving the order of characters. No two characters may map to the same character 
	but a character may map to itself.
	
	For example,
	Given "egg", "add", return true.
	
	Given "foo", "bar", return false.
	
	Given "paper", "title", return true.
	
	Note:
	You may assume both s and t have the same length.
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStringsSelf {
	// 20ms AC  time: O(n), space: O(n)
	public boolean isIsomorphic(String s, String t) {
		if (s == null && t == null) return true;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (!map.containsKey(c1)) {
                if (set.contains(c2)) return false;
                map.put(c1, c2);
            }
            else {
                if (map.get(c1) != c2)
                    return false;
                
            }
            set.add(c2); // track all nonduplicate values
        }
        return true;
    }
}

package leetcodeAbove600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImplementMagicDictionary {
	static class MagicDictionary {
	    private HashMap<Integer, List<String>> dicts = null;
	    /** Initialize your data structure here. */
	    public MagicDictionary() {
	        dicts = new HashMap<>();
	    }
	    
	    /** Build a dictionary through a list of words */
	    public void buildDict(String[] dict) {
	        for (String str: dict) {
	            int len = str.length();
	            if (!dicts.containsKey(len))
	                dicts.put(len, new ArrayList<String>());
	            dicts.get(len).add(str);
	        }
	    }
	    
	    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
	    public boolean search(String word) {
	        if (word == null) return false;
	        int len = word.length();
	        if (dicts.get(len) == null) return false;
	        List<String> lst = dicts.get(len);
	        for (String s: lst) {
	            int diff = 0;
	            for (int i = 0; i < len; i++) {
	                if (word.charAt(i) != s.charAt(i)) diff++;
	            }
	            if (diff == 1) return true;
	        }
	        return false;
	    }
	}
}

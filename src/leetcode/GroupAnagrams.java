package leetcode;

import java.util.*;

//49. Group Anagrams  
//Given an array of strings, group anagrams together.
//
//For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
//Return:
//
//[
//  ["ate", "eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            String curHash = getHash(str);
            if (!map.containsKey(curHash)) {
                map.put(curHash, new ArrayList<>());
            }
            map.get(curHash).add(str);
        }
        
        Set<String> keyset = map.keySet();
        for (String key: keyset) {
            Collections.sort(map.get(key));
            res.add(map.get(key));
        }
        return res;
    }
    
    public String getHash(String str) {
        char[] strToArr = str.toCharArray();
        Arrays.sort(strToArr);
        return new String(strToArr);
    }
}

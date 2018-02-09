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

public class GroupAnagrams { // k is the max string length, O(klogk) for sorting string characters, n for strs length, so time 
	// complexity is O(nklogk)
	public static List<List<String>> groupAnagrams(String[] strs) {
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
    
    public static String getHash(String str) {
        char[] strToArr = str.toCharArray();
        Arrays.sort(strToArr);
        return new String(strToArr);
    }
    
    public static void main(String[] args) {
    		String[] strs = {"ate", "eat", "tea", "tan", "nat", "bat" };
    		List<List<String>> res = groupAnagrams(strs);
    		res.stream()
    			.forEach(System.out::println); // using stream API
    		System.out.println("-------");
//    		for (List<String> l : res) { // java 7 way of output an list
//    			System.out.println(l.toString());
//    		}
//    		Map<String, Integer> map = new TreeMap<>();
//    		map.put("hello", 1);
//    		map.put("world", 2);
//    		map.put("apple", 0);
//    		System.out.println(map);
    }
}

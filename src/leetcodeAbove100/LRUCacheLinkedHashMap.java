package leetcodeAbove100;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLinkedHashMap {
	// Fastest Leetcode AC, among top 95%
	final int capacity;
    LinkedHashMap<Integer, Integer> map;
    
    public LRUCacheLinkedHashMap(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
                return size() > capacity;
            }
        };  
    }
    
    public int get(int key) {
        Integer val = map.get(key);
        return  val == null ? -1 : val;
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}

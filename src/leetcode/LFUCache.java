package leetcode;

//Question
//
//LFU (Least Frequently Used) is a famous cache eviction algorithm.
//For a cache with capacity k, if the cache is full and need to evict a key in it, the key with the lease frequently used will be kicked out.
//Implement set and get method for LFU cache.

// Example
//Given capacity=3
//set(2,2)
//set(1,1)
//get(2)
//>> 2
//get(1)
//>> 1
//get(2)
//>> 2
//set(3,3)
//set(4,4)
//get(3)
//>> -1
//get(2)
//>> 2
//get(1)
//>> 1
//get(4)
//>> 4
import java.util.*;
public class LFUCache {
	class CacheEntry {
		private String data;
		private int freq;
		
		private CacheEntry() {}
		
		public String getData() {
			return data;
		}
		
		public void setData(String data) {
			this.data = data;
		}
		
		public int getFreq() {
			return freq;
		}
		
		public void setFreq(int freq) {
			this.freq = freq;
		}
	}
	private int initialCapacity = 3;
	private static LinkedHashMap<Integer, CacheEntry> cacheMap = new LinkedHashMap<>();
	/* LinkedHashMap is used because it has features of both HashMap and LinkedList.  
	 * Thus, we can get an entry in O(1) and also, we can iterate over it easily. 
	 * */ 
	
	public LFUCache(int capacity) {
		this.initialCapacity = capacity;
	}
	
	public void set(int key, String data) {
		if(!isFull()) {
			CacheEntry temp = new CacheEntry();
			temp.setData(data);
			temp.setFreq(0);
			cacheMap.put(key, temp);
		}else {
			int entrykeyToBeRemoved = getLFUKey();
			cacheMap.remove(entrykeyToBeRemoved);
			
			CacheEntry tmp = new CacheEntry();
			tmp.setData(data);
			tmp.setFreq(0);
			cacheMap.put(key, tmp);
		}
	}
	
	public int getLFUKey() {
		int key = 0;
		int minFreq = Integer.MAX_VALUE;
		for(Map.Entry<Integer, CacheEntry> entry: cacheMap.entrySet()) {
			if (minFreq > entry.getValue().getFreq()) {
				key = entry.getKey();
				minFreq = entry.getValue().freq;
			}
		}
		return key;
	}
	
	public boolean isFull() {
		if (cacheMap.size() == initialCapacity) {
			return true;
		}
		return false;
	}
	
	public String get(int key) {
		if (cacheMap.containsKey(key)) {
			CacheEntry tmp = cacheMap.get(key);
			tmp.freq++;
			cacheMap.put(key, tmp);
			return tmp.data;
		}
		return null;
	}
	
	public static void main(String[] args) {
		LFUCache lfu = new LFUCache(3);
		lfu.set(2, "2");
		lfu.set(1, "1");
		System.out.println(lfu.get(2));
		System.out.println(lfu.get(1));
		System.out.println(lfu.get(2));
		lfu.set(3, "3");
		lfu.set(4, "4");
		System.out.println(lfu.get(3));
		System.out.println(lfu.get(2));
		System.out.println(lfu.get(1));
		System.out.println(lfu.get(4));
		
		
	}
}

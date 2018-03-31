package leetcodeAbove100;

import java.util.*;

//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
//
//get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

public class LRUCache {
	private HashMap<Integer, DoubleLinkedListNode> map = new HashMap<>();
    private DoubleLinkedListNode head = new DoubleLinkedListNode(-1, -1);
    private DoubleLinkedListNode tail = new DoubleLinkedListNode(-1, -1);
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
        		return -1;
        DoubleLinkedListNode latest = map.get(key);
        latest.prev.next = latest.next;
        latest.next.prev = latest.prev;
        
        moveToTail(latest);
        return map.get(key).val;
    }
    
    private void moveToTail(DoubleLinkedListNode node) {
       node.next = tail;
       tail.prev.next = node;
       node.prev = tail.prev;
       tail.prev = node;
    }
    
    public void put(int key, int value) {
	    	if (get(key) != -1) {
	            map.get(key).val = value;
	            return;
	        }
        if (map.size() == capacity) { // delete node after head
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
        map.put(key, node);
        moveToTail(node);
    }
    
    /**
	 * Entry point for testing LRU Cache.
	 */
	public static void main(String[] args) {
		// Create the cache with capacity 2
		LRUCache cache = new LRUCache(2);

		cache.put(2, 1); // Will add an element with key as 2 and value as 1
		cache.put(3, 2); // Will add an element with key as 3 and value as 2

		// Will add an element with key as 4 and value as 3. Also will remove
		// the element with key 2 as it was added least recently and cache can
		// just have two elements at a time
		cache.put(4, 3);

		// Since element with key 2 was removed, it will return -1
		System.out.println(cache.get(2));

		// It will return value 2 and move the element with key 3 to the head.
		// After this point, element with key 4 will be least recently accessed
		System.out.println(cache.get(3));

		// Will add an element with key as 5 and value as 4. Also will remove
		// the element with key 4 as it was accessed least recently and cache
		// can just have two elements at a time
		cache.put(5, 4);

		// Since element with key 2 was removed, it will return -1
		System.out.println(cache.get(4));
	}
}

class DoubleLinkedListNode {
    public int val;
    public int key;
    public DoubleLinkedListNode prev;
    public DoubleLinkedListNode next;
    
    public DoubleLinkedListNode(int key, int value) {
        this.val = value;
        this.key = key;
    }	
}

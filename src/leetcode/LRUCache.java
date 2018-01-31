package leetcode;

import java.util.*;

//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
//
//get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

public class LRUCache {
	private HashMap<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode end;
    private int capacity;
    private int len;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        len = 0;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode latest = map.get(key);
            removeNode(latest);
            setHead(latest);
            return latest.val;
        }else {
            return -1;
        }
    }
    
    public void removeNode(DoubleLinkedListNode node) {
        DoubleLinkedListNode cur = node;
        DoubleLinkedListNode pre = cur.prev;
        DoubleLinkedListNode nex = cur.next;
        
        if (pre != null) {
            pre.next = nex;
        }else {
            head = nex;
        }
        
        if (nex != null) {
            nex.prev = pre;
        }else {
            end = pre;
        }
    }
    
    public void setHead(DoubleLinkedListNode node) {
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        
        head = node;
        if (end == null) {
            end = node;
        }
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode oldNode = map.get(key);
            oldNode.val = value;
            removeNode(oldNode);
            setHead(oldNode);
        }else {
            DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
            if (len < capacity) {
                setHead(node);
                map.put(key, node);
                len++;
            }else {
                map.remove(end.key);
                end = end.prev;
                if (end != null) {
                    end.next = null;
                }
                setHead(node);
                map.put(key, node);
            }
        }
    }
    
    /**
	 * Entry point for testing LRU Cache.
	 */
	public static void main(String[] args) {
		// Create the cache with capacity 2
		LRUCache cache = new LRUCache(2);

		cache.set(2, 1); // Will add an element with key as 2 and value as 1
		cache.set(3, 2); // Will add an element with key as 3 and value as 2

		// Will add an element with key as 4 and value as 3. Also will remove
		// the element with key 2 as it was added least recently and cache can
		// just have two elements at a time
		cache.set(4, 3);

		// Since element with key 2 was removed, it will return null
		System.out.println(cache.get(2));

		// It will return value 2 and move the element with key 3 to the head.
		// After this point, element with key 4 will be least recently accessed
		System.out.println(cache.get(3));

		// Will add an element with key as 5 and value as 4. Also will remove
		// the element with key 4 as it was accessed least recently and cache
		// can just have two elements at a time
		cache.set(5, 4);

		// Since element with key 2 was removed, it will return null
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

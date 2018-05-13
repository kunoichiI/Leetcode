package leetcodeAbove100;

import java.util.*;

//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
//
//get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

public class LRUCache {
	/*
	 * LC AC among top 30%
	 */
	final int CAPACITY;
    Map<Integer, Node> map;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        map = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node latest = map.get(key);
        latest.prev.next = latest.next;
        latest.next.prev = latest.prev; // get the node out of doubly linked list
        
        moveToHead(latest);
        return latest.val;
    }
    
    private void moveToHead(Node node) {
        // move the recent used node always to after head, node becomes the new firstNode
        Node firstNode = head.next;
        head.next = node;
        node.next = firstNode;
        firstNode.prev = node;
        node.prev = head;
    }
    
    public void put(int key, int value) {
        if (get(key) != -1) {
            Node node = map.get(key);
            node.val = value;
            return;
        }
        if (map.size() == CAPACITY) {
            // evict the least recently used node, which is tail.prev
            map.remove(tail.prev.key);
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        moveToHead(newNode);
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

class Node {
    int key;
    int val;
    Node prev, next;
    Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

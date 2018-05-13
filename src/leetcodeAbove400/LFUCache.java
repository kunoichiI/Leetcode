package leetcodeAbove400;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
	/*
	 * Leetcode AC top 5% java submissions.
	 */
	private final int CAPACITY;
    private int minFreq = 0;
    private Map<Integer, Node> nodeMap; // key: node
    private Map<Integer, DoublyLinkedList> listMap; // freq : doubly linked list
    
    public LFUCache(int capacity) {
        if (capacity < 0) throw new RuntimeException("Capacity cannot be negative!");
        CAPACITY = capacity;
        nodeMap = new HashMap<>(capacity);
        listMap = new HashMap<>(capacity);
    }
    
    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        update(node);
        return node.val;
    }
    
    private void update(Node node) {
        DoublyLinkedList list = listMap.get(node.freq);
        list.remove(node);
        if (list.isEmpty()) {
            if (node.freq != 1)
                listMap.remove(node.freq);
            if (minFreq == node.freq)
                minFreq += 1;
        }
        node.freq++;
        DoublyLinkedList newlist = listMap.get(node.freq);
        if (newlist == null) {
            newlist = new DoublyLinkedList();
            listMap.put(node.freq, newlist);
        }
        newlist.addFirst(node);
    }
    
    public void put(int key, int value) {
        if (CAPACITY == 0) return;
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.val = value;
            update(node);
        }
        else { // insert a new node
            if (nodeMap.size() == CAPACITY) {
                DoublyLinkedList minFreqList = listMap.get(minFreq);
                Node lastNode = minFreqList.removeLast();
                if (minFreq != 1 && minFreqList.isEmpty()) 
                    listMap.remove(minFreq);
                nodeMap.remove(lastNode.key);
            }
            minFreq = 1;
            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            if (!listMap.containsKey(minFreq))
                listMap.put(minFreq, new DoublyLinkedList());
            listMap.get(minFreq).addFirst(newNode);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Node {
    int key;
    int val;
    int freq = 1;
    Node prev, next;
    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

class DoublyLinkedList {
    int size = 0;
    Node head, tail;
    DoublyLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.next = head; // head and tail initially points to each other
    }
    
    boolean isEmpty() {
        return size == 0;
    }
    
    void addFirst(Node node) {
        Node firstNode = head.next;
        head.next = node;
        node.next = firstNode;
        firstNode.prev = node;
        node.prev = head;
        size++;
    }
    
    Node remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
        size--;
        return node;
    }
    
    Node removeLast() {
        return remove(tail.prev);
    }
}

package leetcodeAbove300;

import java.util.Random;

import leetcode.ListNode;

/*
 * 382. Linked List Random Node
 * Given a singly linked list, return a random node's value from the linked list. 
 * Each node must have the same probability of being chosen.
	What if the linked list is extremely large and its length is unknown to you? 
	Could you solve this efficiently without using extra space?
	
	Example:
	
	// Init a singly linked list [1,2,3].
	ListNode head = new ListNode(1);
	head.next = new ListNode(2);
	head.next.next = new ListNode(3);
	Solution solution = new Solution(head);
	
	// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
	solution.getRandom();
 */
public class LinkedListRandomNode {
	private ListNode head;
    private Random random;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        this.random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int ans = 0;
        ListNode p = head;
        int cnt = 1;
        while (p != null) {
            if (random.nextInt(cnt) == 0) ans = p.val;
            p = p.next;
            cnt++;
        }
        return ans;
    }
    /*
     * 这个情况相当于simple reservoir sampling， 蓄水池样本为1. 
     * 在一个不知道多大的stream里抽取一个。每一个接下来的stream element被选中的概率为 1/ N（N是当前stream的大小）
     * 这个算法主要难度在于证明为什么要这么做
     */
}

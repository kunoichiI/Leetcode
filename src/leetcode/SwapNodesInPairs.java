package leetcode;
//24. Swap Nodes in Pairs
//Given a linked list, swap every two adjacent nodes and return its head.
//
//For example,
//Given 1->2->3->4, you should return the list as 2->1->4->3.
//
//Your algorithm should use only constant space. 
//You may not modify the values in the list, only nodes itself can be changed.
public class SwapNodesInPairs { // O(n) time complexity, O(n) space
	public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode first = head;
        ListNode second = head.next;
        ListNode rest = swapPairs(second.next);
        
        second.next = first;
        first.next = rest;
        return second;
    }
}

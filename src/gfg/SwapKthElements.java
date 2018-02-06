package gfg;

import leetcode.ListNode;

//GFG: Given a singly linked list, swap kth node from beginning with kth node from end. 
//Swapping of data is not allowed, only pointers should be changed.
//This requirement may be logical in many situations where the linked list data part is huge 
//(For example student details line Name, RollNo, Address, ..etc). The pointers are always fixed (4 bytes for most of the compilers).
//
//The problem seems simple at first look, but it has many interesting cases.
//
//Let X be the kth node from beginning and Y be the kth node from end. Following are the interesting cases that must be handled.
//1) Y is next to X
//2) X is next to Y
//3) X and Y are same
//4) X and Y don’t exist (k is more than number of nodes in linked list)
public class SwapKthElements {
	public void swapKth(int k, ListNode head) {
		int n = countNodes(head);
		
		// check if k is valid (edge case: what if k is larger than n 
		if (n < k) {
			return;
		}
		
		// check if X and Y are the same node, if so then we don't have to swap them :)
		if (2 * k - 1 == n) {
			return;
		}
		
		// Find the kth node from begining
		ListNode x = head;
		ListNode x_prev = null;
		for (int i = 1; i < k; i++) {
			x_prev = x;
			x = x.next;
		}
		
		// Find the kth node from the end
		ListNode y = head;
		ListNode y_prev = null;
		for (int i = 1; i < n - k + 1; i++) {
			y_prev = y;
			y = y.next;
		}
		
		if (x_prev != null) {
			x_prev.next = y;
		}
		
		if (y_prev != null) {
			y_prev.next = x;
		}
		
		// Swap next pointers of x and y. These statements
        // also break self loop if x->next is y or y->next
        // is x
		ListNode tmp = x.next;
		x.next = y.next;
		y.next = tmp;
		
		if (k == 1) {
			head = y;
		}
		
		if (k == n) {
			head = x;
		}
	}
	
	public int countNodes(ListNode head) {
		int cnt = 0;
		ListNode s = head;
		while(s!= null) {
			cnt++;
			s = s.next;
		}
		return cnt;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		SwapKthElements ske = new SwapKthElements();
		int k = 5;
		for (int i = 0; i < k; i++) {
			ske.swapKth(i, head);
		}
	}

}

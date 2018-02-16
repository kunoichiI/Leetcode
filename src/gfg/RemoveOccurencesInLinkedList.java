package gfg;

import leetcode.ListNode;

//Remove all occurrences of duplicates from a sorted Linked List
//3.2
//Given a sorted linked list, delete all nodes that have duplicate numbers (all occurrences),
//leaving only numbers that appear once in the original list.
//
//Examples:
//
//Input : 23->28->28->35->49->49->53->53
//Output : 23->35
//
//Input : 11->11->11->11->75->75
//Output : empty List
public class RemoveOccurencesInLinkedList {
	public static ListNode removeOccurences(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode curr = head;
		while (curr != null) {
			/* Until the current and previous values are same, keep updating current */
			while (curr.next != null && prev.next.val == curr.next.val) {
				curr = curr.next;
			}
			if (prev.next == curr)
				prev = prev.next;
			else
				prev.next = curr.next;
			curr = curr.next;
		}
		return dummy.next;
		
	}
	public static void printList(ListNode node) {
		while (node != null && node.next != null) {
			System.out.print(node.val + "->");
			node = node.next;
		}
		if (node != null) {
			System.out.print(node.val);
		}
		else {
			System.out.print("");
		}
		
	}
	public static void main(String[] args) {
		/* 23->28->28->35->49->49->53->53 */
		ListNode head1 = new ListNode(23);
		head1.next = new ListNode(28);
		head1.next.next = new ListNode(28);
		head1.next.next.next = new ListNode(35);
		head1.next.next.next.next = new ListNode(49);
		head1.next.next.next.next.next = new ListNode(49);
		head1.next.next.next.next.next.next = new ListNode(53);
		head1.next.next.next.next.next.next.next = new ListNode(53);
		printList(removeOccurences(head1)); // 23 -> 35 
		
		System.out.println();
		/* 11->11->11->11->75->75 */
		ListNode head2 = new ListNode(11);
		head2.next = new ListNode(11);
		head2.next.next = new ListNode(11);
		head2.next.next.next = new ListNode(11);
		head2.next.next.next.next = new ListNode(75);
		head2.next.next.next.next.next = new ListNode(75);
		printList(removeOccurences(head2)); // empty list
	}

}

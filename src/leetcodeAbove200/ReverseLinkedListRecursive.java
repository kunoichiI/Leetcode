package leetcodeAbove200;

import leetcode.ListNode;

public class ReverseLinkedListRecursive { // o(N) time, O(N) space on stack, memory error on Leetcode
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode second = head.next;
		ListNode reversed = reverseList(second);
		second.next = head;
		head.next = null;
		return reversed;
	}
	
	public static void main(String[] args) {
		ListNode node1 = null;
		ListNode n = reverseList(node1); // empty
		System.out.println(n); //  null
		ListNode node2 = new ListNode(1);
		node2.next = new ListNode(2); // 1 -> 2	
		ListNode node3 = new ListNode(5);
		node3.next = new ListNode(6);
		node3.next.next = new ListNode(10); // 5 -> 6 -> 10
		
		
		ListNode n1 = reverseList(node2); // 2 -> 1
		System.out.println(n1.val);
		ListNode n2 = reverseList(node3); // 10 -> 6 -> 5
		System.out.println(n2.val);
	}

}

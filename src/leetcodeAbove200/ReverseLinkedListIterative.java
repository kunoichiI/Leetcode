package leetcodeAbove200;

import leetcode.ListNode;

public class ReverseLinkedListIterative {
	public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
	 
	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	public static void main(String[] args) {
		ListNode node1 = null;
		printList(reverseList(node1)); // empty
		System.out.println();
		ListNode node2 = new ListNode(1);
		node2.next = new ListNode(2); // 1 -> 2	
		ListNode node3 = new ListNode(5);
		node3.next = new ListNode(6);
		node3.next.next = new ListNode(10); // 5 -> 6 -> 10
		
		
		printList(reverseList(node2)); // 2 -> 1
		System.out.println();
		printList(reverseList(node3)); // 10 -> 6 -> 5
	}

}

package leetcode;

// 2. Add Two Numbers 
// You are given two linked lists representing two non-negative numbers. 
// The digits are stored in reverse order and each of their nodes contain a single digit. 
// Add the two numbers and return it as a linked list.
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8

public class AddTwoNumbers { // O(n) time, o(1) space
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null; // This iterative solution gets TLE time running out..
        
        ListNode head = new ListNode(0);
        ListNode point = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = carry + (l1 == null? 0: l1.val) + (l2 == null? 0 : l2.val);
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            point = point.next;
        }
        if (carry != 0) {
            point.next = new ListNode(carry);
        }
        return head.next;
    }
	
	public static void main(String[] args) {
		// l1: 2 -> 4 -> 3
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		// l2: 5 -> 6 -> 4
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode node = addTwoNumbers(l1, l2);
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
}

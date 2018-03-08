package leetcodeAbove400;

import leetcode.ListNode;

//445. Add Two Numbers II
//You are given two non-empty linked lists representing two non-negative integers. 
//The most significant digit comes first and each of their nodes contain a single digit. 
//Add the two numbers and return it as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//Follow up:
//What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
//
//Example:
//
//Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 8 -> 0 -> 7
public class AddTwoNumbersII { // o(n) time, o(n) space
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLen(l1);
        int len2 = getLen(l2);
        ListNode head = new ListNode(1); // build a dummy node as head, pointing to the added list
        head.next = len1 > len2 ? helper(l1, l2, len1 - len2) : helper(l2, l1, len2 - len1);
        if (head.next.val > 9) {
            head.next.val %= 10;
            return head;
        }
        return head.next;
    }
    
    public static ListNode helper(ListNode l1, ListNode l2, int diff) {
        if (l1 == null) return null;
        ListNode res = null, pos = null;
        if (diff == 0) {
            res = new ListNode(l1.val + l2.val);
            pos = helper(l1.next, l2.next, 0);
        }
        else {
            res = new ListNode(l1.val);
            pos = helper(l1.next, l2, diff - 1);
        }
        
        if (pos != null && pos.val > 9) {
            pos.val %= 10;
            res.val++;
        }
        res.next = pos;
        return res;
    }
    
    public static int getLen(ListNode l) {
        int cnt = 0;
        while (l != null) {
            cnt++;
            l = l.next;   
        }
        return cnt;
    }
    
	public static void main(String[] args) {
		// l1: 7 -> 2 -> 4 -> 3
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);
		
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

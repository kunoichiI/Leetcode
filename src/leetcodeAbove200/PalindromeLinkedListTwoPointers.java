package leetcodeAbove200;

import leetcode.ListNode;

public class PalindromeLinkedListTwoPointers {
	public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode slow = head, fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // slow will be the center of this linkedlist
        ListNode center = slow.next;
        slow.next = null;
        
        // reverse the second half of the list and see if it's the same with the first half
        ListNode p1 = center;
        ListNode p2 = p1.next;
        
        while (p1 != null && p2 != null) {
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        center.next = null;
        // now compare both lists
        ListNode p = (p2 == null) ? p1 : p2; // tricky point! if p2 != null, p1 is the thing to return
        ListNode q = head;
        
        while (p != null && q != null) {
            if (p.val != q.val)
                return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

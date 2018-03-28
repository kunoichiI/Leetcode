package leetcodeAbove200;

import leetcode.ListNode;

public class PalindromeLinkedList { // Brute Force: reverse the whole list and compare with original list
	public static boolean isPalindrome(ListNode head) {
        if (head == null)
        		return true;
 
        ListNode p = head;
        ListNode prev = new ListNode(head.val);

        while (p.next != null){
            ListNode temp = new ListNode(p.next.val);
            temp.next = prev;
            prev = temp;
            p = p.next;
        } // copy from OG list to get a reversed list

        ListNode p1 = head;
        ListNode p2 = prev;

        while (p1 != null) {
            if(p1.val != p2.val)
                return false;

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
        }
	public static void main(String[] args) {
		

	}

}

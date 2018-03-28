package leetcodeAbove200;

import leetcode.ListNode;

public class PalindromeLinkedListOptimal {
	 public static boolean isPalindrome(ListNode head) {
	        // fastest solution, no reverse at all, just record pointers
	        ListNode slow = head, revHead = null, temp = null;
	        
	        while (head != null && head.next != null) {
	            temp = slow;
	            slow = slow.next;
	            head = head.next.next;
	            
	            temp.next = revHead;
	            revHead = temp;
	        }
	        
	        if (head != null) {
	            slow = slow.next; // odd number list, slow is the starting node of the reverse part
	        }
	        
	        while (slow != null) {
	            if (slow.val != revHead.val)
	                return false;
	            slow = slow.next;
	            revHead = revHead.next;
	        }
	        return true;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * O(n) time, O(1) space, fastest execution time!
	 * 解题思路：一边遍历一边翻转前半部链表，当找到后一半链表的起始点，就可以滚动指针进行比较数值！
	 */

}

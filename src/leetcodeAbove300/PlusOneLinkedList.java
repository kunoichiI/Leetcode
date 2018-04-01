package leetcodeAbove300;
/* *
 *  369 Plus One Linked List
 *  Given a non-negative number represented as a singly linked list of digits, 
 *  plus one to the number.

	The digits are stored such that the most significant digit is at the head of the list.
	
	Example:
	Input:
	1->2->3
	
	Output:
	1->2->4
 */
import leetcode.ListNode;

public class PlusOneLinkedList {
	public static ListNode plusOne(ListNode head) {
		if (head == null) return null;
		
		ListNode p = head;
		ListNode node = null; 
		while (p != null) { 
			if (p.val != 9) node = p;
			p = p.next;
		}
		if (node == null) {
			node = new ListNode(0);
			node.next = head;
			head = node;
		}
		node.val++;
		p = node.next;
		while (p != null) {
			p.val = 0;
			p = p.next;
		}
		return head;
	}
	public static void main(String[] args) {
		// 1 -> 2 -> 3
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		ListNode node1 = plusOne(head1);
		
		while(node1 != null) {
			if (node1.next == null)
				System.out.print(node1.val);
			else
				System.out.print(node1.val + " -> ");
			node1 = node1.next;
		} // expect: 1 -> 2 -> 4
		
		System.out.println();
		// 1 -> 2 -> 9
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(9);
		ListNode node2 = plusOne(head2);
		
		while(node2 != null) {
			if (node2.next == null)
				System.out.print(node2.val);
			else
				System.out.print(node2.val + " -> ");
			node2 = node2.next;
		} // expect: 1 -> 3 -> 0	
	}
	/*
	 * 解题思路： 由于head是最高位，所以Brute Force解法为翻转reverse list后由最低位进行相加，如果发生进位，则
	 * 计算carry和sum， 这个方法比较巧妙，寻找最右边不为9的node，如果找不到任何，则说明所有node值都为9，
	 * 那就要在head前加上一个List Node（0），然后node.val++， node后面所有node值都变成0
	 */
}

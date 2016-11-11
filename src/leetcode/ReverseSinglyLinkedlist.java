
package leetcode;

public class ReverseSinglyLinkedlist {
	// Recursion solution : will cause large stack call because of recursive function
//	public static ListNode reverseList(ListNode head) {
//		if (head == null || head.next == null) return head;
//		ListNode second = head.next;
//		head.next = null;
//		ListNode reverseRest = reverseList(second);
//		second.next = head;
//		return reverseRest;
//	}
	
	
	// Iterative solution : use one pointer, saves stack call
	// Iterate trough the linked list. In loop, change next to prev, prev to current and current to next.
	
	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
 
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);
 
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		ListNode result = reverseList(n1);
		while(result != null) {
			if (result.equals(n1)) {
				System.out.print(result.val + "->NULL");
				result = null;
			}else {
			System.out.print(result.val + "->");
			result = result.next;
			}
		}
	}

}

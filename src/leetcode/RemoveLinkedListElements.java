package leetcode;
//203. Remove Linked List Elements
//Remove all elements from a linked list of integers that have value val.
//
//Example
//Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
//Return: 1 --> 2 --> 3 --> 4 --> 5
public class RemoveLinkedListElements { // 关键是这个dummy node，这样就不会麻烦判断当前listnode是不是head了！
	public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        
        while (p.next != null) {
        		if (p.next.val == val) 
        			p.next = p.next.next;
        		else
        			p = p.next;
        }
        return dummy.next;
    }
	public static void main(String[] args) {
		// 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next = new ListNode(6);
		
		ListNode node = removeElements(head, 6);
		while (node != null) {
			System.out.println(node.val + " ");
			node = node.next;
		}
		// 1
		ListNode head1 = new ListNode(1);
		ListNode node4 = removeElements(head1, 2);
		System.out.println("node4 is :" + node4.val); // 1 -> null
		// 1
		ListNode head2 = null;
		ListNode node2 = removeElements(head2, 1);
		System.out.println("node2 is :" + node2); // => null
		// 1 -> 2 -> 3 -> 4 -> 5
		ListNode node3 = removeElements(head, 100);
		System.out.println("node3 is :" + node3.val); // => 1
		
		// 1 -> 1
		ListNode head3 = new ListNode(1);
		head3.next = new ListNode(1);
		ListNode node6 = removeElements(head3, 1);
		System.out.println("node6 is :" + node6); // => null
	}

}

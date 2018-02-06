package leetcodeAbove300;

import leetcode.ListNode;

//328. Odd Even Linked List  
//Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
//
//You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
//
//Example:
//Given 1->2->3->4->5->NULL,
//return 1->3->5->2->4->NULL.
//
//Note:
//The relative order inside both the even and odd groups should remain as it was in the input. 
//The first node is considered odd, the second node even and so on ...

public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        
        ListNode res = head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode connectNode = head.next;
        
        while (p1 != null && p2 != null) {
            ListNode t = p2.next;
            if (t == null) break;
            
            p1.next = p2.next;
            p1 = p1.next;
            
            p2.next = p1.next;
            p2 = p2.next;
        }
        p1.next = connectNode;
        return res;
    }
}

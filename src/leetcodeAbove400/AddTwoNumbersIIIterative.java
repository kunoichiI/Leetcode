package leetcodeAbove400;

import leetcode.ListNode;

public class AddTwoNumbersIIIterative {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = getLen(l1);
        int n2 = getLen(l2);
        int diff = Math.abs(n1 - n2);
        if (n1 < n2) {
        		ListNode tmp = l1; // l1 is always the longer linked list.
        		l1 = l2;
        		l2 = tmp;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode tail = curr;
        
        while (diff > 0) { // get all nodes in l1 that are not aligned with l2
            curr.next = new ListNode(l1.val);
            if (l1.val != 9)
                tail = curr.next;
            curr = curr.next;
            l1 = l1.next;
            --diff;
        }
        
        while (l1 != null) {
            int val = l1.val + l2.val;
            if (val > 9) {
                val %= 10;
                tail.val++;
                while (tail.next != null) {
                    tail.next.val = 0;
                    tail = tail.next;
                }
                tail = curr;
            } 
            curr.next = new ListNode(val);
            if (val != 9) tail = curr.next;
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        return dummy.val == 1 ? dummy : dummy.next; 
    }
    
    public static int getLen(ListNode l) {
        int cnt = 0;
        while (l != null) {
            ++cnt;
            l = l.next;
        }
        return cnt;
    }
    
    /* this static swap method won't work if I pass it in addTwoNumbers method, why??? 
    so I directly swapped them in main method instead */
//    public static void swap(ListNode l1, ListNode l2) { 
//        ListNode tmp = l1;
//        l1 = l2;
//        l2 = tmp;
//    } 
	public static void main(String[] args) {
		// l1 : 0
		// l2: 2 -> 7 -> 8   ---> output : 2 -> 7 -> 8
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(2);
		l2.next  = new ListNode(7);
		l2.next.next = new ListNode(8);
		ListNode node = addTwoNumbers(l1, l2);
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
		System.out.println("-------------");
		// l3: 7 -> 2 -> 4 -> 3
		// l4:      5 -> 6 -> 4   ---> output: 7 -> 8 -> 0 -> 7
		ListNode l3 = new ListNode(7);
		l3.next = new ListNode(2);
		l3.next.next = new ListNode(4);
		l3.next.next.next = new ListNode(3);
		
		ListNode l4 = new ListNode(5);
		l4.next = new ListNode(6);
		l4.next.next = new ListNode(4);
		
		ListNode node1 = addTwoNumbers(l3, l4);
		while (node1 != null) {
			System.out.print(node1.val + " ");
			node1 = node1.next;
		}
	}

}

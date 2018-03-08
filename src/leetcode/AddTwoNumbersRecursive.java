package leetcode;

public class AddTwoNumbersRecursive { // o(n) time, O(n) space
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }
    
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        int sum = 0;
        // base case 
        if (l1 == null && l2 == null) {
            if (carry != 0) {
                return new ListNode(carry);
            }
            return null;
        }
        
        if (l1 != null) sum += l1.val;
        if (l2 != null) sum += l2.val;
        sum += carry;
        
        // make a new node with the sum
        ListNode p = new ListNode(sum % 10);
        p.next = addTwoNumbers((l1 == null? null: l1.next), (l2 == null? null : l2.next), sum / 10);
        return p;
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

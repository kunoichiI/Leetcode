package leetcode;

public class AddTwoNumbersI { // Recursive solution passes all test cases;
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }
	
	private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
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
}

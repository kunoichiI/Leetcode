package leetcode;
//21. Merge Two Sorted Lists
//Merge two sorted linked lists and return it as a new list. 
//The new list should be made by splicing together the nodes of the first two lists.
//
//Example:
//
//Input: 1->2->4, 1->3->4
//Output: 1->1->2->3->4->4
public class MergeTwoSortedLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        
        while (l1 != null && l2 != null) {
            // compare l1 value with l2 value, put smaller one as the one after dummy
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next; 
            } else {
                p.next = l1;
                l1 = l1.next;
            } 
            p = p.next;
        }
        
        if (l1 != null)
            p.next = l1;
        if (l2 != null)
            p.next = l2;
        
        return dummy.next;
            
    }
	public static void main(String[] args) {
		/* Input: 1->2->4, 1->3->4  output: 1->1->2->3->4->4*/
		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(2);
		node1.next.next = new ListNode(4);
		
		ListNode node2 = new ListNode(1);
		node2.next = new ListNode(3);
		node2.next.next = new ListNode(4);
		
		ListNode merged1 = mergeTwoLists(node1, node2);
		System.out.println("The merged list is:");
		while (merged1 != null) {
			System.out.print(merged1.val + " ");
			merged1 = merged1.next;
		}
		System.out.println();
		// corner case, input: null, 1, output: 1
		ListNode node3 = null;
		ListNode node4 = new ListNode(1);
		ListNode merged2 = mergeTwoLists(node3, node4);
		System.out.println("The merged list is:");
		while (merged2 != null) {
			System.out.print(merged2.val + " ");
			merged2 = merged2.next;
		}
	}

}

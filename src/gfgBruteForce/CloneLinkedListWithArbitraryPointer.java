package gfgBruteForce;

public class CloneLinkedListWithArbitraryPointer {
	public static ListNodeArb clone(ListNodeArb head) {
		if (head == null) return null;
		
		ListNodeArb copyHead = new ListNodeArb(head.val);
		ListNodeArb p = copyHead;
		ListNodeArb q = head;
		while (q.next != null) {
			q = q.next;
			p.next = new ListNodeArb(q.val);
			p = p.next;
		} // This would create a list of copyHead as the head
		return copyHead;
	}
	public static void main(String[] args) {
		// 1 -> 2 -> 3 -> 4 -> 5
		ListNodeArb head = new ListNodeArb(1);
		head.next = new ListNodeArb(2);
		head.next.next = new ListNodeArb(3);
		head.next.next.next = new ListNodeArb(4);
		head.next.next.next.next = new ListNodeArb(5);
		head.random = head.next.next;  // 1 -> 3
		head.next.random = head;    // 2 -> 1
		head.next.next.random = head.next.next.next.next; // 3 -> 5
		head.next.next.next.random = head.next.next; // 4 -> 3
		head.next.next.next.next.random = head.next; // 5 -> 2
		
		ListNodeArb copyHead = clone(head);
		while (copyHead != null) {
			if (copyHead.next == null)
				System.out.print(copyHead.val);
			else
				System.out.print(copyHead.val + " -> ");
			
			copyHead = copyHead.next;
		} // 1 -> 2 -> 3 -> 4 -> 5
	}
	/*
	 * This method stores the next and arbitrary mappings (of original list) in an array first, 
	 * then modifies the original Linked List (to create copy), creates a copy. 
	 * And finally restores the original list.
	 * 
	 * Steps: 1. Create copy list using original list next pointers
	 * 		 Store the node and its next pointer mappings of original linked list.
	 * 		  2. move original list next pointer pointing to copy list node 
	 * 		  3. point copy list arbitrary pointer to original list node
	 * 		  4. construct copy list arbitrary pointer using:
	 *        copy_list_node.random = copy_list_node.random.random.next;
	 *        copy_list_node = copy_list_node.next; // move to next copy list node
	 *        5. restore original listnode next pointers from the stored list mappings.
	 */
}

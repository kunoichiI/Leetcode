package interviewQ;
//You are given a Double Link List with one pointer of each node pointing to the next node just like in a single link list. 
//The second pointer however CAN point to any node in the list and not just the previous node. 
//Now write a program in O(n) time to duplicate this list. 
//That is, write a program which will create a copy of this list.
//   ---------  --------
//  | 	      |		    |
//  1 -> 2 -> 3 -> 4 -> 5
//  |    |    |    |    |
//   ----     -----     |
//       |			   |
//  		 ---------------
//(1 -> 3, 3 -> 5, 4 -> 3, 2 -> 1, 5 -> 2)
public class DeepCloneLinkedList {
	/*
	 * 思路，在1 和2 之间插入copy1， 然后可以根据 1.next.random(copy1.random) = 1.random.next;
	 * 因为每一个点的任意指向点后面肯定是那个点的copy，可以将自己的copy点的random pointer指向自己random点的下一个
	 * 
	 */
	public static CustomNode deepClone(CustomNode head) {
		CustomNode p = head;
		while (p != null) {
			CustomNode copy = new CustomNode(p.val);
			CustomNode next = p.next;
			p.next = copy;
			copy.next = next;
			p = p.next.next;
		} // end of while, 1 -> copy1 -> 2 -> copy2 -> 3 -> copy3 -> 4 -> copy4 -> 5 -> copy5(random 指向没有画在这里）
		/* Start pointing copy node to its random node */
		CustomNode q = head;
		CustomNode newhead = q.next;
		CustomNode copy = newhead;
		while (q.next != null && copy.next != null) {
			System.out.println("q is: " + q.val);
			q.next.random = q.random.next;
			q.next = q.next.next; // point to its original next node
			q = q.next;
			System.out.println("copy is: " + copy.val);
			copy.next = copy.next.next;
			copy = copy.next;
		}
		return newhead;
	}
	public static void main(String[] args) {
		CustomNode head = new CustomNode(1);
		head.next = new CustomNode(2);
		head.next.next = new CustomNode(3);
		head.next.next.next = new CustomNode(4);
		head.next.next.next.next = new CustomNode(5);
		
		// initialize random pointers
		head.random = head.next.next; // 1 -> 3
		head.next.random = head; // 2 -> 1
		head.next.next.random = head.next.next.next.next; // 3 -> 5
		head.next.next.next.random = head.next.next; // 4 -> 3
		head.next.next.next.next.random = head.next.next; // 5 -> 2
		
		CustomNode newhead = deepClone(head);
		System.out.println(newhead.random.val); //  3
		System.out.println(newhead.next.next.random.val); // 5
		System.out.println();
		while (newhead!= null) {
			System.out.println(newhead.val + " ");
			newhead = newhead.next;
		} // 1 -> 2 -> 3 -> 4 -> 5
		
		
	}

}

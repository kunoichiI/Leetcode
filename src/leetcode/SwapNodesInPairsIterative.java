package leetcode;

public class SwapNodesInPairsIterative {
	public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode p = h;
        
        ListNode p1 = head;
        ListNode p2 = head.next;
        
        while(p1 != null && p2 != null) {
            ListNode next = p2.next;
            p.next = p2;
            p2.next = p1;
            p = p1;
            p1.next = next;
            
            p1 = p1.next;
            if (next != null)
                p2 = next.next;
        }
        return h.next;
    }
	
	/*
	 * 解题思路：制造一个dummy node指向原有head，然后用三个variable存pre node，当前第一个node
	 * 和第二个node，在while loop里，先记录第三个node，然后开始swap 第一和第二个node，
	 * 然后移动p1， p2 直到while loop runs out， 最后返回最先的dummy.next
	 */
}

package leetcode;

import java.util.PriorityQueue;
import java.util.Comparator;

public class MergeKSortedLists {
	
	public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        
        ListNode head = new ListNode(0);
        ListNode p = head;
        
        for (ListNode list: lists) {
            if (list!= null) {
                queue.offer(list);
            }
        }
        while(!queue.isEmpty()) {
            ListNode n = queue.poll();
            p.next = n;
            p = p.next;
            if (n.next != null) {
                queue.offer(n.next);
            }
        }
        return head.next;
    }
}

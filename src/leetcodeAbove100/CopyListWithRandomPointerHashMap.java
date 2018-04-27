package leetcodeAbove100;

import java.util.HashMap;
import gfg.CustomNode;

public class CopyListWithRandomPointerHashMap {
	public CustomNode copyRandomList(CustomNode head) {
		if (head == null) return null;
		HashMap<CustomNode, CustomNode> map = new HashMap<>(); // OG node -> copy node
		CustomNode newHead = new CustomNode(head.val);
		
		CustomNode p = head;
		CustomNode q = newHead;
		map.put(head	, newHead);
		
		p = p.next;
		while (p != null) {
			CustomNode temp = new CustomNode(p.val);
			map.put(p, temp);
			q.next = temp;
			p = p.next;
		}
		p = head;
		q = newHead;
		while (p != null) {
			if (q.random != null)
				q.random = map.get(p.random);
			else 
				q.random = null;
			p = p.next;
			q = q.next;
		}
		return newHead;	
	}
	/*
	 * 解题思路： 和deep clone undirected graph思路很像，使用Hashmap 存储OG node -》 copy node
	 * 然后由hashmap调出所有OG list里的mapping，copy到copy list里。
	 */
}

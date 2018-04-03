package leetcodeAbove100;

import interviewQ.CustomNode;

/*
 * 138. Copy List with Random Pointer
 *  A linked list is given such that each node contains an additional random pointer 
	 which could point to any node in the list or null.
	
	Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {
	public CustomNode copyRandomList(CustomNode head) {
        if (head == null) return null;
        
        CustomNode p = head;
        
        while (p != null) {
        		CustomNode q = new CustomNode(p.val);
        		CustomNode next = p.next;
            p.next = q;
            q.next = next;
            p = p.next.next;
        }
        
        CustomNode q = head;
		// copy random pointers
        while (q != null) {
            if (q.random != null)
                q.next.random = q.random.next;
            q = q.next.next;
        }
        // break two lists 
        CustomNode node = head;
        CustomNode copy = node.next;
        while (node != null && node.next != null) {
        		CustomNode temp = node.next;
            node.next = temp.next;
            node = temp;
        }
        return copy;
    }
	/*
	 * 解题思路： 和deep clone linked list （GFG）一样，不同的是这里的random可能指向null
	 * 所以分配 p.next.random = p.random.next之前，要先用if 检查p.random！= null
	 * 分解两个lists的方法很好，值得再次使用！
	 */
}

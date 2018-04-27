package interviewQ;
/*
 * 上来贴了一个树和一个node结构，说要完成这么个function。我没懂什么顺序，prev_node到底指啥，就问了一下，
 * 最后讨论出来可以按照pre-order顺序看， Order: 1, 2, 5, 8, 6, 9, 10, 3, 4, 7
 *   Example tree:
 *       		1
 *     		/  |   \
 *    	  2   3    4
 *    /   | \       \
 *    5   8  6       7
 *         /  \
 *         9   10
		在这里，input不是root，而是target，可以是tree里任何一个node,找它的prev_node。.
		input：2  output: 1
		input: 3  output: 10
		input: 4  output: 3
 */
public class FindPrevNodeUsePreorderInATree {
	public static CNode findPrevNode(CNode input) { // input is the target node, find its predecessor
		if (input == input.first_sibling) return input.parent;
		else {
			// find input's first sibling node
			CNode head = input.first_sibling;
			CNode curr = head, prev = head;
			while (curr != null) {
				prev = curr;
				curr = curr.next_sibling;
				if (curr == input) { // input and curr are at same level
					// find prev's rightmost node
					while (prev.first_child != null) {
						prev = prev.last_child; // last child is the right most node
					}
					return prev;
 				}
			}
			return null; // if curr is null
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class CNode {
	int val;
	CNode parent;
	CNode first_sibling;
	CNode next_sibling;
	CNode first_child;
	CNode last_child;
	CNode(int v) {
		this.val = v;
	}
}

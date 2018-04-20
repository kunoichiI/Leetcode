package leetcodeAbove100;
/*
 * 116. Populating Next Right Pointers in Each Node
 * 
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, 
the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree 
(ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */
public class PopulatingNextRightPointersInEachNodeConstantSpace {
	public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        TreeLinkNode p = root; // current node
        TreeLinkNode first = null; // next level the first node
        
        while (p != null) {
            if (first == null) first = p.left;
            if (p.left != null) p.left.next = p.right;
            else break;
            
            if (p.next != null) {
                p.right.next = p.next.left;
                p = p.next;
                continue;
            }
            else {
                p = first;
                first = null;
            }
        }
    }
	/*
	 * 解题思路： 记录当前node和下一层的第一个node，然后开始在每一行进行next assign
	 */
}

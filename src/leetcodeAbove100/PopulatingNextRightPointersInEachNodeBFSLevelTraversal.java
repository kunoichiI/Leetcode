package leetcodeAbove100;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeBFSLevelTraversal {
	public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        q.add(null); // end of level traversal
        
        while (!q.isEmpty()) {
            TreeLinkNode p = q.poll();
            if (p != null) {
                p.next = q.peek();
                if (p.left != null) {
                    q.add(p.left);
                }
                if (p.right != null) {
                    q.add(p.right);
                }
            }
            else if (!q.isEmpty()) // this step is important!
                q.add(null);
        }
    }
	/*
	 * 解题思路：BFS level traversal，每一个node的next 指向后一个node。 记得在每个level遍历后加上null node
	 * 
	 */
}

package leetcodeAbove100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeNode;

/*
 * 199. Binary Tree Right Side View
 * Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.

	For example:
	Given the following binary tree,
	   1            <---
	 /   \
	2     3         <---
	 \     \
	  5     4       <---
	You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView { // O(n) space, o(n) time
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ans.add(root.val);
        
        while (!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                    tmp.add(node.right);
                }
            }
            if (tmp.size() >= 1)
                ans.add(tmp.get(tmp.size() - 1).val);
        }
        return ans;
    }
	
	/*
	 * Iterative solution, use BFS do level-order traversal
	 * then always get the rightmost node val and add it to res list.
	 */
}

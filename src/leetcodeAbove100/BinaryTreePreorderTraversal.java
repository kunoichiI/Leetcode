package leetcodeAbove100;

import java.util.*;
// 144. Binary Tree Preorder Traversal   
// Given a binary tree, return the preorder traversal of its nodes' values.
//
// For example:
// Given binary tree {1,#,2,3},
//   1
//    \
//     2
//    /
//   3
// return [1,2,3].
// Note: Recursive solution is trivial, could you do it iteratively?

import leetcode.TreeNode;

public class BinaryTreePreorderTraversal {
	// iterative solution
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		if (root == null) return res;
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			res.add(cur.val);
			
			if (cur.right != null) {
				stack.push(cur.right);
			}
			
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
		return res;
	}
}

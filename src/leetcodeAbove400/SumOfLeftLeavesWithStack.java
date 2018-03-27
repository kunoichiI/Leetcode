package leetcodeAbove400;

import java.util.Stack;

import leetcode.TreeNode;

public class SumOfLeftLeavesWithStack {
	public static int sumOfLeftLeaves(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) return 0;
		
		int res = 0;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.left != null && node.left.left == null && node.left.right == null) res += node.left.val;
			if (node.left != null) stack.push(node.left);
			if (node.right != null) stack.push(node.right);
		}
		return res;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println("sum of left leaves: " + sumOfLeftLeaves(root));
	}
	
	/*
	 * 解题思路：先序遍历preorder 加stack
	 */
}

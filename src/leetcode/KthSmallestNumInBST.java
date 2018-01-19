package leetcode;

import java.util.Stack;
//230. Kth Smallest Element in a BST
//Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
//
//Note: 
//You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
//
//Follow up:
//What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
//		How would you optimize the kthSmallest routine?
public class KthSmallestNumInBST { //  o(n) RT, n is the size of all nodes in the tree
	public int kthSmallest(TreeNode root, int k) {
		TreeNode p = root;
		Stack<TreeNode> stack = new Stack<>();
		
		while (p != null) {
			stack.push(p);
			p = p.left;
		}
		
		int i = 0;
		while (!stack.isEmpty()) {
			TreeNode t = stack.pop();
			i++;
			
			if (i == k) return t.val;
			TreeNode r = t.right;
			while (r != null) {
				stack.push(r);
				r = r.left;
			}
		}
		return -1;
	}
}

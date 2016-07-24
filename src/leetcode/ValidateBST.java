package leetcode;

//98. Validate Binary Search Tree  QuestionEditorial Solution  My Submissions
//Total Accepted: 102578
//Total Submissions: 481002
//Difficulty: Medium
//Given a binary tree, determine if it is a valid binary search tree (BST).
//
//Assume a BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.
//Example 1:
//    2
//   / \
//  1   3
//Binary tree [2,1,3], return true.
//Example 2:
//    1
//   / \
//  2   3
//Binary tree [1,2,3], return false.


public class ValidateBST {
	 public boolean isValidBST(TreeNode root) {
	        return isValid(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	    }
	    
	    public boolean isValid(TreeNode node, double min, double max) {
	        if (node == null) {
	            return true;
	        }
	        if (node.val <= min || node.val >= max) {
	            return false;
	        }
	        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
	    }
}

// Method 2: In-order Traversal and to see if values are in ascending order
//public class Solution {
//	TreeNode root;
//	TreeNode prev = null;
//	public boolean isBST(TreeNode node) {
//		// traverse the tree in in-order fashion and track prevous node
//		if (node != null) {
//			if (!isBST(node.left)) {
//				return false;
//			}
//			if (prev != null && node.val <= prev.val) {
//				return false;
//			}
//			prev = node;
//			return isBST(node.right);
//		}
//		return true;
//	}
//}

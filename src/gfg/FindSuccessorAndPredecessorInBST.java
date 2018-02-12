package gfg;

import leetcode.TreeNode;

//There is BST given with root node with key part as integer only. The structure of each node is as follows:
//Run on IDE
//You need to find the inorder successor and predecessor of a given key. In case the given key is not found in BST, 
//then return the two values within which this key will lie.
public class FindSuccessorAndPredecessorInBST {
	public static void findPreSuc(TreeNode root, TreeNode pre, TreeNode suc, int key) {
		if (root == null) {
			return;
		}
		// if key is found then
		if (root.val == key) {
			if (root.left != null)
				/* if left tree is not null, the predecessor will be the rightmost child of left
				* or the left child itself */
				pre = getPredecessor(root.left);
			if (root.right != null)
				suc = getSuccessor(root.right);
			return;
		}
		
		if (root.val < key) {
			suc = root;
			findPreSuc(root.left, pre, suc, key);
		}
		else {
			pre = root;
			//System.out.println("pre is: " + pre.val);
			findPreSuc(root.right, pre, suc, key);
		}
		
	}

	private static TreeNode getPredecessor(TreeNode node) {
		while (node.right != null)
			node = node.right;
		return node;
	}
	
	private static TreeNode getSuccessor(TreeNode node) {
		while (node.left != null)
			node = node.left;
		return node;
	}
	public static void main(String[] args) {
		// create a binary search tree here, check the notes for the graph or draw it yourself
		
	}

}

package gfgBruteForce;

import leetcode.TreeNode;

/*
 * Given preorder traversal of a BST, construct it.
 * For example, if the given traversal is [10, 5, 1, 7, 40, 50],
 * then the output should be root of following:
 *        10
 *        / \
 *       5  40
 *      /\   \
 *     1  7   50
 */
public class ConstructBSTFromGivenPreorderTraversalON2 {
	int preIndex = 0;
	public TreeNode constructTree(int[] pre) {
		int size = pre.length;
		return construct(pre, preIndex, 0, size - 1, size);
	}
	
	public TreeNode construct(int[] pre, int preIndex, int low, int high, int size) {
		// base case
		if (preIndex >= size || low > high) {
			return null;
		}
		
		// The first node in preorder traversal is always the root. So
		// take the node at preIndex from pre[] and make it root, and
		// increment preIndex
		TreeNode root = new TreeNode(pre[preIndex++]);
		
		// If the current subarray has only one element, no need to recur
		if (low == high) return root;
		
		// search for the first element greater than the root
		int i;
		for (i = low; i < high; ++i) {
			if (pre[i] > root.val) break;
		}
		root.left = construct(pre, preIndex, preIndex, i - 1, size);
		root.right = construct(pre, preIndex, i, high, size);
		return root;
		
	}
	
	public void printInorder(TreeNode root) {
		if (root != null) {
			printInorder(root.left);
			System.out.print(root.val + " ");
			printInorder(root.right);
		}
	}
	public static void main(String[] args) {
		int[] arr = { 10, 5, 1, 7, 40, 50 };
		ConstructBSTFromGivenPreorderTraversalON2 cc = new ConstructBSTFromGivenPreorderTraversalON2();
		TreeNode root = cc.constructTree(arr);
		cc.printInorder(root);
	}

}

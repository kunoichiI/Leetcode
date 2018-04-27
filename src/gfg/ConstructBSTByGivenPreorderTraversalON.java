package gfg;

import leetcode.TreeNode;

/*
 * ref: https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
 */
public class ConstructBSTByGivenPreorderTraversalON {
	int preIndex = 0;
	public TreeNode constructTree(int[] pre) {
		return construct(null, pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public TreeNode construct(TreeNode root, int[] pre, int min, int max) {
		if (preIndex < pre.length && pre[preIndex] <= max && pre[preIndex] >= min)
			root = new TreeNode(pre[preIndex++]);
		else return null;
		root.left = construct(null, pre, min, root.val - 1);
		root.right = construct(null, pre, root.val + 1, max);
		return root;
	}
	
	public void printInorder(TreeNode node) {
		if (node == null) return;
		printInorder(node.left);
		System.out.print(node.val + " ");
		printInorder(node.right);
	}
	public static void main(String[] args) {
		int[] pre = { 10, 5, 1 ,7, 40, 50 };
		ConstructBSTByGivenPreorderTraversalON cc = new ConstructBSTByGivenPreorderTraversalON();
		TreeNode root = cc.constructTree(pre);
		cc.printInorder(root);

	}

}

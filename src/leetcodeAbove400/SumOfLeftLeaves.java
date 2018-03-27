package leetcodeAbove400;

import leetcode.TreeNode;

/*
 * 404. Sum of Left Leaves
 * 	Find the sum of all left leaves in a given binary tree.

	Example:
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	
	There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumOfLeftLeaves {
	public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        if (isLeaf(root.left))
            return root.left.val + sumOfLeftLeaves(root.right);
        
         return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);  
    }
    
    private static boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println("sum of left leaves: " + sumOfLeftLeaves(root));
	}

}

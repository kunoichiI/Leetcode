package leetcodeAbove100;

import leetcode.TreeNode;

/*
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Given inorder and postorder traversal of a tree, construct the binary tree.

	Note:
	You may assume that duplicates do not exist in the tree.
	
	For example, given
	
	inorder = [9,3,15,20,7]
	postorder = [9,15,7,20,3]
	Return the following binary tree:
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
 */
public class ConstructBinaryTreeFromInorderAndPostorder {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    public TreeNode build(int[] inorder, int inStr, int inEnd, int[] postorder, int postStr, int postEnd) {
        if (inStr > inEnd || postStr > postEnd) return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int k = 0;
        for (; k < inorder.length; k++) {
            if (inorder[k] == postorder[postEnd]) {
                break;
            }
        }
        root.right = build(inorder, k + 1, inEnd, postorder, postStr + k - inStr, postEnd - 1);
        root.left = build(inorder, inStr, k - 1, postorder, postStr, postStr + k - inStr - 1);
        return root;
    }
}

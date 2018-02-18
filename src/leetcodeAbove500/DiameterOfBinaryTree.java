package leetcodeAbove500;

//543. Diameter of Binary Tree

//Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
//This path may or may not pass through the root.
//Example:

//Given a binary tree 

//          1

//         / \

//        2   3

//       / \     

//      4   5    
//Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
//Note: The length of path between two nodes is represented by the number of edges between them.

import leetcode.TreeNode;
public class DiameterOfBinaryTree {
	static int max = 0;
	public static int diameterOfBinaryTree(TreeNode root) {
		depth(root);
		return max;
    }
	public static int depth(TreeNode root) {
		if (root == null)
			return 0;
		int left = depth(root.left);
		int right = depth(root.right);
		max = Math.max(left + right, max);
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
	//      1
	//     / \
	//    2   3
	//   / \     
	//  4   5 

	TreeNode root = new TreeNode(1);
	root.left = new TreeNode(2);
	root.right = new TreeNode(3);
	root.left.left = new TreeNode(4);
	root.left.right = new TreeNode(5);
	
	System.out.println("The diameter of this tree is: " + diameterOfBinaryTree(root)); // 3
	}
}





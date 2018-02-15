package leetcodeAbove600;

import leetcode.TreeNode;

//654. Maximum Binary Tree
//Given an integer array with no duplicates. 
//A maximum tree building on this array is defined as follow:
//
//The root is the maximum number in the array.
//The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
//The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
//Construct the maximum tree by the given array and output the root node of this tree.
//
//Example 1:
//Input: [3,2,1,6,0,5]
//Output: return the tree root node representing the following tree:
//
//      6
//    /   \
//   3     5
//    \    / 
//     2  0   
//       \
//        1
//Note:
//The size of the given array will be in the range [1,1000].
public class MaximumBinaryTree {
	public static TreeNode constructMaximumBinaryTree(int[] nums) {
		return construct(nums, 0, nums.length);
	}
	public static TreeNode construct(int[] nums, int start, int end) {
		if (start == end)
			return null;
		int idx = findMax(nums, start, end);
		TreeNode root = new TreeNode(nums[idx]);
		root.left = construct(nums, start, idx);
		root.right = construct(nums, idx + 1, end);
		return root;
	}
	
	private static int findMax(int[] nums, int start, int end) {
		int idx = start;
		for (int i = start; i < end; i++) {
			if (nums[idx] < nums[i])
				idx = i;
		}
		return idx;
	}
	private static void inorder(TreeNode root) {
		if (root == null)
			return;
		else {
			inorder(root.left);
			System.out.print(root.val + " ");
			inorder(root.right);
		}
		
	}
	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 6, 0, 5 };
		TreeNode root = constructMaximumBinaryTree(nums);
		System.out.println("Root node is: " + root.val);
		inorder(root); // 3, 2, 1, 6, 0, 5
	}

}

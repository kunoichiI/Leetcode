package gfg;

import java.util.HashMap;
import java.util.Map;

import leetcode.TreeNode;

// ref: https://www.geeksforgeeks.org/bottom-view-binary-tree/
/*
 * Given a Binary Tree, we need to print the bottom view from left to right. 
 * A node x is there in output if x is the bottommost node at its horizontal distance. 
 * Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, 
 * and that of right child is horizontal distance of x plus 1.

	Examples:
	
	                      20
	                    /    \
	                  8       22
	                /   \      \
	              5      3      25
	                    / \      
	                  10    14
	
	For the above tree the output should be 5, 10, 3, 14, 25.
 */
public class BottomViewOfBinaryTree {
	static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	public static void bottomView(TreeNode root) {
		Map<Integer, int[]> map = new HashMap<>(); // to store horizontal distance as the key,
		// (node value, node height) as the int[] value;
		printBottomView(root, map, 0, 0);
		//System.out.println(map);
//		System.out.println("min : " + min);
//		System.out.println("max : " + max);
		for (int i = min; i <= max; i++) {
			System.out.print(map.get(i)[0] + " ");
		}
	}
	
	public static void printBottomView(TreeNode root, Map<Integer, int[]> map, int cur, int hd) {
		if (root == null) return;
		//System.out.println("current hd: " + hd);
		if (hd < min)
			min = hd;
		if (hd > max)
			max = hd;
		if (!map.containsKey(hd))
			map.put(hd, new int[]{root.val, cur});
		else {
			int[] pair = map.get(hd);
			if (pair[1] <= cur) {
				map.get(hd)[0] = root.val;
				map.get(hd)[1] = cur;
			}
		}
		printBottomView(root.left, map, cur + 1, hd - 1);
		printBottomView(root.right, map, cur + 1, hd + 1);
			
	}
	public static void main(String[] args) {
		System.out.print("Bottom view of the given binary tree :\n");
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(25);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
		bottomView(root);
// 			The constructed tree		
//		  		20
//		  	  /   \
//		  	 8     22
//		  	/ \      \
//		  5    3      25
//		       / \
//		      10   14
		// Bottom view should be [5, 10, 3, 14, 25]
	}
	/*
	 * Two ways to solve this question:
	 * 1. Just like Leetcode Vertical Order Traversal, use queue and hashmap,
	 * track the min horizontal distance and max horizontal distance, iterate though map and output all values;
	 * 2. Use hashmap and recursion. Traverse the tree and label each node with its horizontal distance
	 * 
	 */
}

package leetcodeAbove300;
import java.util.*;
// 314.Binary Tree Vertical Order Traversal
//Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
//
//If two nodes are in the same row and column, the order should be from left to right.
//
//Examples:
//Given binary tree [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
//return its vertical order traversal as:
//
//[
//  [9],
//  [3,15],
//  [20],
//  [7]
//]
// 
//
//Given binary tree [3,9,20,4,5,2,7],
//
//    _3_
//   /   \
//  9    20
// / \   / \
//4   5 2   7
// 
//
//return its vertical order traversal as:
//
//[
//  [4],
//  [9],
//  [3,5,2],
//  [20],
//  [7]
//]

import leetcode.TreeNode;

public class BinaryTreeVerticalOrderTraversal {
	private class TreeColumnNode {
		TreeNode treeNode;
		int col;
		
		public TreeColumnNode(TreeNode node, int col) {
			this.treeNode = node;
			this.col = col;
		}
	}
	
	public List<List<Integer>> verticalOrderTraversal(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) 
			return res; //corner case
		
		Queue<TreeColumnNode> queue = new LinkedList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		queue.offer(new TreeColumnNode(root, 0));
		int min = 0;
		int max = 0; // min max are used to set range for hashmap keys
		
		while(!queue.isEmpty()) {
			TreeColumnNode node = queue.poll();
			if (map.containsKey(node.col)) {
				map.get(node.col).add(node.treeNode.val);
			}else {
				map.put(node.col, new ArrayList<Integer>(Arrays.asList(node.treeNode.val))); // Arrays.asList returns a fixed-size list.. so have to construct a new arraylist based on this
			}
			if (node.treeNode.left != null) {
				queue.offer(new TreeColumnNode(node.treeNode.left, node.col -1)); // get left child node, col - 1
				min = Math.min(node.col-1, min);
			}
			if (node.treeNode.right != null) {
				queue.offer(new TreeColumnNode(node.treeNode.right, node.col + 1)); // get right child node, col + 1
				max = Math.max(node.col+1, max);
			}
		}
		System.out.println("min value:" + min);
		System.out.println("max value:" + max);
		for (int i = min; i <= max; i++) {
			res.add(map.get(i));
		}
		return res;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		BinaryTreeVerticalOrderTraversal btvot = new BinaryTreeVerticalOrderTraversal();
		List<List<Integer>> res = btvot.verticalOrderTraversal(root);
		for (List<Integer> list : res) {
			int i = 0;
			while(i < list.size()) {
				System.out.print(list.get(i) + " ");
				i++;
			}
			
		}
	}
}

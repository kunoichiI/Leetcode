package leetcodeAbove200;

import java.util.LinkedList;
import java.util.List;

import leetcode.TreeNode;

//257. Binary Tree Paths
//Given a binary tree, return all root-to-leaf paths.
//
//For example, given the following binary tree:
//
//   1
// /   \
//2     3
// \
//  5
//All root-to-leaf paths are:
//
//["1->2->5", "1->3"]
public class BinaryTreePaths {
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new LinkedList<>();
		if (root == null)
			return res;
		helper(root, res, new LinkedList<Integer>());
		return res;
	}
	
	private static void helper(TreeNode node, List<String> res, List<Integer> lst) {
		lst.add(node.val);
		// check if node is a leaf node
		if (node.left == null && node.right == null) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < lst.size() - 1; i++) {
				sb.append(lst.get(i) + "->");
			}
			sb.append(lst.get(lst.size() - 1));
			res.add(sb.toString());
		}
		if (node.left != null) {
			helper(node.left, res, lst);
			lst.remove(lst.size() - 1); // backtracking before moving to right side
		}
		if (node.right != null) {
			helper(node.right, res, lst);
			lst.remove(lst.size() - 1);
		}
	}
	public static void main(String[] args) {
		// build a tree of the example
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		
		List<String> res = binaryTreePaths(root);
		res.stream().forEach(System.out::println);
	}

}

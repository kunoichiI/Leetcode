package leetcodeAbove100;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

public class BinaryTreeRightSideViewRecursive { // O(n) time, traverse all tree, o(h) space, h is the height of tree
	static List<Integer> res = new ArrayList<>();
	public static List<Integer> rightSideView(TreeNode root) {
		Max_level max = new Max_level();
		traverse(root, 1, max);
		return res;
	}
	
	public static void traverse(TreeNode node, int level, Max_level maxLevel) {
		if (node == null)
			return;
		if (maxLevel.max_level < level) {
			res.add(node.val);
			maxLevel.max_level = level;
		}
		traverse(node.right, level + 1, maxLevel);
		traverse(node.left, level + 1, maxLevel);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);
		
		rightSideView(root); // Expect [1, 3, 7 , 8]
		res.stream().forEach(it -> System.out.format("This node has value: %d\n", it));
	}
}
class Max_level {
	int max_level;
}

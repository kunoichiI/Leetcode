package leetcodeAbove100;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

public class BinaryTreeLevelOrderTraversalRecursion {
	public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>(); 
        traverse(root, 1, res);
        return res;
    }
    
    public static void traverse(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) return;
        
        if (level > res.size()) res.add(new ArrayList<Integer>());
        res.get(level - 1).add(node.val);
        
        traverse(node.left, level + 1, res);
        traverse(node.right, level + 1, res);
    }
	public static void main(String[] args) {
		

	}
	/*
	 * 解题思路： 用level变量记录每一层，base case是node == null此时直接返回
	 * general case是把当前值加入res，然后遍历其两个child 节点。
	 */

}

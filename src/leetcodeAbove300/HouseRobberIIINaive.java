package leetcodeAbove300;

import leetcode.TreeNode;

public class HouseRobberIIINaive {
	public int rob(TreeNode root) {
        if (root == null) return 0;
        
        int val = 0;
        
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);   
        }
        
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(root.val + val, rob(root.left) + rob(root.right));
    }
}
/*
 * 这个重复了大量相同运算。。所以速度非常慢，怎么分析复杂度？？
 * */

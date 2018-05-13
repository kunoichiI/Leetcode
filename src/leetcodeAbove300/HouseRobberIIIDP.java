package leetcodeAbove300;

import leetcode.TreeNode;

/*
 * 337. House Robber III
 * The thief has found himself a new place for his thievery again. 
 * There is only one entrance to this area, called the "root." Besides the root, 
 * each house has one and only one parent house. After a tour, the smart thief realized that 
 * "all houses in this place forms a binary tree". It will automatically contact the police if 
 * two directly-linked houses were broken into on the same night.

	Determine the maximum amount of money the thief can rob tonight without alerting the police.
	
	Example 1:
	     3
	    / \
	   2   3
	    \   \ 
	     3   1
	Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
	Example 2:
	     3
	    / \
	   4   5
	  / \   \ 
	 1   3   1
	Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class HouseRobberIIIDP {
	public int rob(TreeNode root) {
        int[] res = dfs(root);
        return res[1];
    }
    
    public int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        
        int[] robLeft = dfs(root.left);
        int[] robRight = dfs(root.right);
        int[] rob = new int[2];
        rob[0] = robLeft[1] + robRight[1]; // rob[0] stores the biggest value of robbing from leaves to left and right child nodes, rob[1] stores the biggest value of robbing from leaves to current node
        rob[1] = Math.max(robLeft[0] + robRight[0] + root.val, rob[0]);
        return rob;
    }
}
/*
 * recursion on binary tree, the tricky part is to identify what info to store to avoid duplicate 
 * computation */

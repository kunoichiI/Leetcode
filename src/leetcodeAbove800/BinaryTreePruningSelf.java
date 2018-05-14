package leetcodeAbove800;

import leetcode.TreeNode;

/*
 * 814. Binary Tree Pruning 
 *  We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.

	Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
	
	(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)
	
	Example 1:
	Input: [1,null,0,0,1]
	Output: [1,null,0,null,1]
	 
	Explanation: 
	Only the red nodes satisfy the property "every subtree not containing a 1".
	The diagram on the right represents the answer.
	
	Example 2:
	Input: [1,0,1,0,0,0,1]
	Output: [1,null,1,null,1]
	
	Example 3:
	Input: [1,1,0,1,1,0,1,0]
	Output: [1,1,0,1,1,null,1]

 */
public class BinaryTreePruningSelf {
	public TreeNode pruneTree(TreeNode root) {
        if (root == null || !contains(root)) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root;
    }
    
    public boolean contains(TreeNode node) {
        if (node == null) return false;
        if (node.val == 1) return true;
        return contains(node.left) || contains(node.right);
    }
}
/*
 * 从最小的optimal structure（subproblem）分析，得到contains method， 然后遵循规则进行砍树。
 * 如果root == null或者这颗subtree没有1， 直接砍掉（返回null）， 如果root不为null且含有1，则去左边进行recur
 * 去右边进行 recur，最后返回root。
 */

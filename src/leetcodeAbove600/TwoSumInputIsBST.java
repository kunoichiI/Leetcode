package leetcodeAbove600;
import leetcode.TreeNode;
import java.util.*;
//653. Two Sum IV - Input is a BST
//Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
//
//Example 1:
//Input: 
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 9
//
//Output: True
//Example 2:
//Input: 
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 28
//
//Output: False
/* 解题思路： 用哈希set存访问过的节点值，inorder开始遍历🌲，如果遇到target - value 存在于hashset里，说明有这样一对数加起来等于target*/
public class TwoSumInputIsBST {
	public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return inorder(root, k, set);
    }
    
    public boolean inorder(TreeNode root, int k , Set<Integer> set) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return inorder(root.left, k, set) || inorder(root.right, k, set);
    }
}

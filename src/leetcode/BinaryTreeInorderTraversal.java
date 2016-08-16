package leetcode;
import java.util.*;
//94. Binary Tree Inorder Traversal 
//Given a binary tree, return the inorder traversal of its nodes' values.
//
//For example:
//Given binary tree [1,null,2,3],
//   1
//    \
//     2
//    /
//   3
//return [1,3,2].



public class BinaryTreeInorderTraversal {
	List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            helper(root);
        }
        return res;
    }
    public void helper(TreeNode p) {
        if (p.left != null) {
            helper(p.left);
        }
        res.add(p.val);
        if (p.right != null) {
            helper(p.right);
        }
    }
}

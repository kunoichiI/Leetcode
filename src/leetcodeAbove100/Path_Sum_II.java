package leetcodeAbove100;

import java.util.*;

import leetcode.TreeNode;

//113. Path Sum II  
//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
//For example:
//Given the below binary tree and sum = 22,
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//return
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]

public class Path_Sum_II {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> nodes = new ArrayList<>();
        
        preorderTraversal(root, 0, sum, res, nodes);
        return res;
    }
    
    public void preorderTraversal(TreeNode root, int pathSum, int sum, List<List<Integer>> res, List<Integer> nodes) {
        if (root == null) return;
        nodes.add(root.val);
        pathSum += root.val;
        
        if (root.left == null && root.right == null && pathSum == sum) {
            res.add(nodes);
        }
        preorderTraversal(root.left, pathSum, sum, res, new ArrayList<Integer>(nodes));
        preorderTraversal(root.right, pathSum, sum, res, new ArrayList<Integer>(nodes));
    }
}

package leetcode;
import java.util.*;
//111. Minimum Depth of Binary Tree 
//Given a binary tree, find its minimum depth.
//
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

public class MinDepthOfBT {
	// Solution 1: traverse the tree in preorder
//	public int minDepth(TreeNode root) {
//        if (root == null) {
//            return 0; // corner case
//        }
//        
//        if (root.left == null && root.right == null) {
//            return 1;  // base case
//        }
//        
//        if (root.left == null) {
//            return minDepth(root.right) + 1;
//        }
//        
//        if (root.right == null) {
//            return minDepth(root.left) + 1;
//        }
//        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
//    }
	
	// Best solution 2:
	public int minDepth(TreeNode root) {
        if (root == null) {
            return 0; // corner case
        }
        // create a queue for storing level-traversal nodes
        Queue<qItem> queue = new LinkedList<>();
        queue.offer(new qItem(root, 1));
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                qItem qNode = queue.poll();
                TreeNode node = qNode.node;
                int depth = qNode.depth;
            
                if (node.left == null && node.right == null) { // meet the first leaf node
                    return depth;
                }
            
                if (node.left != null) {
                    queue.offer(new qItem(node.left, depth + 1));
                }
                if (node.right != null) {
                    queue.offer(new qItem(node.right, depth + 1));
                }
            }
        }
        return 0;
    }
}
class qItem {
    TreeNode node;
    int depth;
    public qItem(TreeNode node, int dep) {
        this.node = node;
        this.depth = dep;
    }
}


package leetcodeAbove100;
import java.util.*;
//103. Binary Tree Zigzag Level Order Traversal  
//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its zigzag level order traversal as:
//[
//  [3],
//  [20,9],
//  [15,7]
//]

import leetcode.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>(); 
        if(root==null) return result; 
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        // push first level to first stack s1
        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
        		List<Integer> list = new ArrayList<>();
        		while (!s1.isEmpty()) {
        			TreeNode tmp = s1.pop();
        			list.add(tmp.val);
        			if (tmp.left != null) 
        				s2.push(tmp.left);
        			if (tmp.right != null) 
        				s2.push(tmp.right);
        		}
        		result.add(list);
        		list = new ArrayList<>();
        		while(!s2.isEmpty()) {
        			TreeNode tmp = s2.pop();
        			list.add(tmp.val);
        			if (tmp.right != null) 
        				s1.push(tmp.right);
        			if (tmp.left != null)
        				s1.push(tmp.left);
        		}
        		if (list.size() != 0)
        			result.add(list);	
        }
        return result;
    }
	
	public static void main(String[] args) {
		// [3,9,20,null,null,15,7],
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(9);
		root1.right = (new TreeNode(20));
		root1.right.left = new TreeNode(15);
		root1.right.right = (new TreeNode(7));
		
		// [1,2,3,4,null,null,5]
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = (new TreeNode(3));
		root2.left.left = new TreeNode(4);
		root2.right.right = (new TreeNode(5));
		
		List<List<Integer>> res = zigzagLevelOrder(root1);
		res.stream().forEach(System.out::println); // => [[3], [20, 9], [15, 7]]
		System.out.println("---------------------------");
		List<List<Integer>> res1 = zigzagLevelOrder(root2); 
		res1.stream().forEach(System.out::println); // => [[1], [3, 2], [4, 5]]
	}
}

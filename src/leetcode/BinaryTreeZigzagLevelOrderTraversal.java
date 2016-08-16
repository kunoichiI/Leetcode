package leetcode;
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

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>(); 
        if(root==null) return result; 
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        boolean flag=false; 
        while(!stack.isEmpty())
        {
            Stack<TreeNode> Tpstack=new Stack<TreeNode>();
            List<Integer> list=new ArrayList<Integer>();
            while(!stack.isEmpty())
            {
                TreeNode pop=stack.pop();
                list.add(pop.val); 
                if(!flag) 
                {
                    if(pop.left!=null) Tpstack.push(pop.left);
                    if(pop.right!=null) Tpstack.push(pop.right);
                }else
                {
                    if(pop.right!=null) Tpstack.push(pop.right);
                    if(pop.left!=null) Tpstack.push(pop.left);
                }
            }
            flag=!flag; 
            result.add(list);
            stack=Tpstack; 
        }
        return result; 
    }
}

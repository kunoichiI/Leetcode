package leetcode;
import java.util.Stack;
//Inorder Successor in BST
//Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
//
//Note: If the given node has no in-order successor in the tree, return null.

public class InorderSuccessorInBST {
	 public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	        Stack<TreeNode> stk = new Stack<TreeNode>();
	        TreeNode curr = root;
	        // 找到目标节点并把路径上的节点压入栈
	        while(curr != p){
	            stk.push(curr);
	            if(curr.val > p.val){
	                curr = curr.left;
	            } else {
	                curr = curr.right;
	            }
	        }
	        // 如果目标节点有右节点，则找到其右节点的最左边的节点，就是下一个数
	        if(curr.right != null){
	            curr = curr.right;
	            while(curr.left != null){
	                curr = curr.left;
	            }
	            return curr;
	        } else {
	        // 如果没有右节点，pop栈找到第一个比目标节点大的节点
	            while(!stk.isEmpty() && stk.peek().val < curr.val){
	                stk.pop();
	            }
	            // 如果栈都pop空了还没有比目标节点大的，说明没有更大的了
	            return stk.isEmpty() ? null : stk.pop();
	        }
	    }
}

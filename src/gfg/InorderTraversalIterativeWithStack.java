package gfg;

import java.util.Stack;

import leetcode.TreeNode;
/* time complexity: O(n) n is size of tree. space complexity: o(n) ...
 * worse than recursive inorder traversal which has RT: O(h), the height of tree 
 * space O(1)
 * */
public class InorderTraversalIterativeWithStack {
	public static void inorder(TreeNode root) {
		if (root == null) return;
		Stack<TreeNode> stack = new Stack<>();
		while (root != null) { // push until no left node left
			stack.push(root);
			root = root.left;
		}
		
		while (!stack.isEmpty()) {
			TreeNode t = stack.pop();
			System.out.print(t.val + " ");
			if (t.right != null) {
				TreeNode right = t.right;
				while (right != null) {
					stack.push(right);
					right = right.left;
				}
			}
				
		}
	}
	public static void main(String[] args) {
//						10
//						/ \
//					   5    30
//					  /  \   \
//					 4   8    40
//					/
//					1
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.left.left.left = new TreeNode(1);
		root.right.right = new TreeNode(40);
		
		inorder(root);
	}

}

package leetcodeAbove200;

import leetcode.TreeNode;

//236. Lowest Common Ancestor of a Binary Tree  
//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
//
//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
//
//        _______3______
//       /              \
//    ___5__          ___1__
//   /      \        /      \
//   6      _2       0       8
//         /  \
//         7   4
//For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

public class LCAofBT {
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p == null || q == null) return null;
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // Divide
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // Conquer
        if (left != null && right != null) return root;
        return left == null? right:left;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		TreeNode q = root.left.right;
		TreeNode p = root.left.right.right = new TreeNode(14);
		root.right = new TreeNode(22);
		TreeNode r = null;
		TreeNode s = root.right;
		TreeNode node = lowestCommonAncestor(root, p, q); // on the same left side
		System.out.println(node.val); // => 12
		TreeNode node1 = lowestCommonAncestor(root, q, r); // one of two nodes is null
		System.out.println(node1); // => null
		TreeNode node2 = lowestCommonAncestor(root, p, s); //  nodes on diff sides of tree
		System.out.println(node2.val); // => return root.val 20
	}
}

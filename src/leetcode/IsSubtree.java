package leetcode;

// Check if a binary tree is subtree of another binary tree (GFG)

//Given two binary trees, check if the first tree is subtree of the second one. A subtree of a tree T is a tree S consisting of a node in T and all of its descendants in T. The subtree corresponding to the root node is the entire tree; the subtree corresponding to any other node is called a proper subtree.
//
//For example, in the following case, tree S is a subtree of tree T.
//
//        Tree 2
//          10  
//        /    \ 
//      4       6
//       \
//        30
//
//
//        Tree 1
//              26
//            /   \
//          10     3
//        /    \     \
//      4       6      3
//       \
//        30


public class IsSubtree {
//	// Time Complexity: Time worst case complexity of above solution is O(mn) where m and n are number of nodes in given two trees.
//	public boolean isIdentical(TreeNode n1, TreeNode n2) {
//		if (n1 == null && n2 == null) return true;
//		if (n1 == null || n2 == null) return false;
//		// check if the data of both roots are same and data of left and right subtrees are also same
//		return (n1.val == n2.val) && isIdentical(n1.left, n2.left) && isIdentical(n1.right, n2.right);
//	}
//	
//	// check if root1 is a subtree of root2
//	public boolean isSubtree(TreeNode root1, TreeNode root2) {
//		if (root1 == null) {
//			return true;
//		}
//		if (root2 == null) {
//			return false;
//		}
//		/* Check the tree with root as current node */
//		if (isIdentical(root1, root2)) {
//			return true;
//		}
//		/* If the tree with root as current node doesn't match then
//        try left and right subtrees one by one */
//		return isSubtree(root1, root2.left) || isSubtree(root1, root2.right);
//	}
	
	// O(n) solution as below:
	
}

package leetcode;

public class ValidateBSTInorderTraversal {
	// Method 2: In-order Traversal and to see if values are in ascending order
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root != null) {
            if (!isValidBST(root.left)) {
                return false;
            }
            if (prev!= null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            return isValidBST(root.right);
        }
        return true;
        
    }
}

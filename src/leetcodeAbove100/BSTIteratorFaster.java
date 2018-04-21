package leetcodeAbove100;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

public class BSTIteratorFaster { // 5ms AC, O(1) time on hasNext() & next, but space is O(n)..
	private List<TreeNode> list;
    private int cur;
    public BSTIteratorFaster(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
    }
    
    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            list.add(root);
            inorder(root.right);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur <= list.size() - 1;
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(cur++).val;
    }
}

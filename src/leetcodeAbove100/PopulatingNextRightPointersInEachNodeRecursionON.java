package leetcodeAbove100;

public class PopulatingNextRightPointersInEachNodeRecursionON {
	public void connect(TreeLinkNode root) {
		if (root == null) return;
		if (root.left != null) root.left.next = root.right;
		if (root.right != null) {
			if (root.next != null) {
				root.right.next = root.next.left;
			}
		}
		connect(root.left);
		connect(root.right);
	}
}

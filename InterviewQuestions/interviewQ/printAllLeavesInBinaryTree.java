package interviewQ;

public class printAllLeavesInBinaryTree {
	public static void printLeaves(TreeNode root) {
		if (root == null)
			return;
		
		if (root.left == null && root.right == null)
			System.out.print(root.val + " ");
		printLeaves(root.left);
		printLeaves(root.right);
	}
	public static void main(String[] args) {
		// binary tree 1
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = (new TreeNode(3));
		root1.left.left = new TreeNode(4);
		root1.right.left = new TreeNode(5);
		root1.right.right = (new TreeNode(8));
		root1.right.left.left = new TreeNode(6);
		root1.right.left.right = (new TreeNode(7));
		root1.right.right.left = new TreeNode(9);
		root1.right.right.right = (new TreeNode(10));
		
		TreeNode root2 = null;
		TreeNode root3 = new TreeNode(4);
		
		printLeaves(root1); // expect output: [4, 6, 7, 9, 10]
		System.out.println();
		System.out.println("---------");
		printLeaves(root2); // expect: empty output
		System.out.println("---------");
		printLeaves(root3); // expect: 4
	}

}

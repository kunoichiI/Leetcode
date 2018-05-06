package gfg;

public class LongestConsecutiveSequenceInBinaryTree {
	// question here: why res cannot be passed as an argument parameter?
	// passed as a static property will cause the value stays as it was....
	static int res = 0;
	public static int longestConsecutive(TreeNode root) {
		if (root == null) return res;
		helper(root, 0, root.key);
		return res;
	}
	
	public static void helper(TreeNode root, int curLen, int data) {
		if (root == null) return;
		
		if (root.key == data) curLen++;
		else curLen = 1;
		
		System.out.println("curLen is: " + curLen);
		System.out.println("res here is: " + res);
		res = Math.max(res, curLen);
		
		
		helper(root.left, curLen, root.key + 1);
		System.out.println("res passed here is: " + res);
		helper(root.right, curLen, root.key + 1);
	}
	public static void main(String[] args) {
		// Tree 1
//		 		1
//	        /     \
//	      2        3
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		// Tree 2
//				10
//		
//		        /        \
//		
//		    20          30
//		
//		  /      \       /
//		
//		40      60 90
		TreeNode root2 = new TreeNode(10);
		root2.left = new TreeNode(20);
		root2.right = new TreeNode(30);
		root2.left.left = new TreeNode(40);
		root2.left.right = new TreeNode(60);
		root2.right.left = new TreeNode(90);
		
		System.out.println(longestConsecutive(root1)); // 2
		System.out.println(longestConsecutive(root2)); // 0
	}

}

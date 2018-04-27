package interviewQ;

// FB interview q, 给一个代表BT inorder Traverse array， 要求返回一个minheap tree（LC654相似解法。）
public class MinimumBinaryTree {
	public static TreeNode constructMinimumBinaryTree(int[] nums) {
		return construct(nums, 0, nums.length);
	}
	
	public static TreeNode construct(int[] nums, int start, int end) {
		if (start == end)
			return null;
		int idx = findMin(nums, start, end);
		TreeNode root = new TreeNode(nums[idx]);
		root.left = construct(nums, start, idx);
		root.right = construct(nums, idx + 1, end);
		return root;
	}
	
	public static int findMin(int[] nums, int start, int end) {
		int idx = start;
		for (int i = start; i < end; i++) {
			if (nums[i] < nums[idx])
				idx = i;
		}
		return idx;
	}
	public static void main(String[] args) {
		// Given an array of inorder traversal
		int[] nums = { 1, 3, 6, 0, 4, 2 };
		TreeNode root = constructMinimumBinaryTree(nums);
		System.out.println("Root node is: " + root.val); // => 0
		System.out.println("Root.left node is: " + root.left.val); // => 1
	}

}

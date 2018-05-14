package leetcodeAbove200;

import leetcode.TreeNode;

public class InorderSuccessorInBSTSearch {
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode k)
    {
       if (k.right != null) {
           return minValue(k.right);
       }
       
       TreeNode suc = null;
       TreeNode p = root;
       while (p != null) {
           if (p.val > k.val) {
               // go left, when going left, successor can only be larger than this value k, record all along
               suc = p;
               p = p.left;
           }
           else if (p.val < k.val) {
               // go right
               p = p.right;
           }
           else 
               break;
       }
       return suc;   
    }
	
	private static TreeNode minValue(TreeNode node) {
        TreeNode p = node;
        
        while (p.left != null)
        		p = p.left;
        
        return p;
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(30);
		root.right = new TreeNode(70);
		root.left.left = new TreeNode(20);
		root.right.left = new TreeNode(60);
		root.right.right = new TreeNode(80);
		
//						50
//						/  \
//					  30    70
//					 /     /  \
//					20    60  80
		TreeNode node1 = inorderSuccessor(root, root.left); // (50, 30)
		System.out.println(node1.val); // 50
		
		TreeNode node2 = inorderSuccessor(root, root.left.left); // (50, 20)
		System.out.println(node2.val); // 30
		
		TreeNode node3 = inorderSuccessor(root, root); // (50, 50)
		System.out.println(node3.val); // 60
		
		TreeNode node4 = inorderSuccessor(root, root.right.right); // (50, 80)
		System.out.println(node4 == null ? "null" : node4.val); // null
	}

}

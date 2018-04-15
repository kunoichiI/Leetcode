package leetcodeAbove200;

import java.util.Scanner;

import leetcode.TreeNode;

public class SerializeAndDeserializeBTWithScanner {
	// Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root == null) return "#";
    
        return "" + root.val + " " + serialize(root.left) + " " + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        return build(new Scanner(data));
    }
    
    private static TreeNode build(Scanner sc) {
        if (!sc.hasNext()) return null;
        String s = sc.next();
        if (s.equals("#")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = build(sc);
        root.right = build(sc);
        return root;
    }
    
    public static void main(String[] args) {
    		TreeNode root = new TreeNode(1);
    		root.left = new TreeNode(2);
    		root.right = new TreeNode(3);
    		root.left.left = new TreeNode(4);
    		root.left.right = new TreeNode(5);
    		root.left.left.left = new TreeNode(6);
    		System.out.println(serialize(root)); // 1 2 4 6 # # # 5 # # 3 # #
    }
}

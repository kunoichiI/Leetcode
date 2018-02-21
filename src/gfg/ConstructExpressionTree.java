package gfg;

import java.util.Stack;

public class ConstructExpressionTree {
	public static ExTreeNode constructTree(char[] postfix) {
		if (postfix == null || postfix.length == 0) return null;
		
		Stack<ExTreeNode> stack = new Stack<>();
		for (int idx = 0; idx < postfix.length; idx++) {
			char ch = postfix[idx];
			if (Character.isDigit(ch))
				stack.push(new ExTreeNode(ch));
			else { // meet operator, start calculating here!!
				ExTreeNode a = stack.pop();
				ExTreeNode b = stack.pop();
				ExTreeNode root = new ExTreeNode(ch);
				root.left = b;
				root.right = a;
				stack.push(root);
			}
		}
		return stack.peek();
	}
	
	public static void printInorder(ExTreeNode node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.c + " ");
		printInorder(node.right);
	}
	
	public static void main(String[] args) {
		// given postfix expression: '3' '4' '2' '*' '+'
		char[] postfix = { '3', '4', '2', '*', '+' };
		ExTreeNode root = constructTree(postfix);
		System.out.println("root character is : " + root.c); // '+'
		printInorder(root); // 3 + 4 * 2
		
	}

}

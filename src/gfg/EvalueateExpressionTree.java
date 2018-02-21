package gfg;

public class EvalueateExpressionTree {
	public static int evalExTree(ExTreeNode node) {
		int res = 0;
		if (node == null)
			return 0;
		else if (Character.isDigit(node.c))
			return node.c - '0';
		char operand = node.c;
		int left = evalExTree(node.left);
		int right = evalExTree(node.right);
		switch(operand) {
			case '+':
				res += left + right;
				break;
			case '-':
				res += left - right;
				break;
			case '*':
				res += left * right;
				break;
			case '/':
				res += left / right;
				break;
		}
		return res;
	}
	public static void main(String[] args) {
		//      +
		//    /   \
		//   3     *
		//        / \
		//      +    2
		//     /\
		//    5  9
		ExTreeNode root = new ExTreeNode('+');
		root.left = new ExTreeNode('3');
		root.right = new ExTreeNode('*');
		root.right.left = new ExTreeNode('+');
		root.right.right = new ExTreeNode('2');
		root.right.left.left = new ExTreeNode('5');
		root.right.left.right = new ExTreeNode('9');
		
		ExTreeNode root1 = null;
		
		System.out.println("This expression tree has a value of : " + evalExTree(root)); // 31
		System.out.println("This expression tree has a value of : " + evalExTree(root1)); // 0
	}

}

class ExTreeNode {
	char c;
	ExTreeNode left;
	ExTreeNode right;
	public ExTreeNode(char c) {
		this.c = c;
	}
}

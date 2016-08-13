package leetcode;

import java.util.Stack;
/* A Java program to evaluate a given expression where tokens are separated 
by space.
Test Cases:
  "10 + 2 * 6"            ---> 22
  "100 * 2 + 12"          ---> 212
  "100 * ( 2 + 12 )"      ---> 1400
  "100 * ( 2 + 12 ) / 14" ---> 100    
*/

public class ExpressionEvaluation {

	public static int evaluate(String expression) {
	char[] tokens = expression.toCharArray();
		
		// Stack for numbers: 'values'
		Stack<Integer> values = new Stack<>();
		
		// Stack for operators : 'ops'
		Stack<Character> ops = new Stack<>();
		
		for (int i = 0; i < tokens.length; i++) {
			// Current token is a whitespace, just skip it
			if (tokens[i] == ' ') continue;
			// Current token is a number, push it to values
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuilder sb = new StringBuilder();
				// There may be more than one digit in number
				while(i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
					sb.append(tokens[i++]);
					//System.out.println(sb.toString());
				}
				values.push(Integer.parseInt(sb.toString()));
			}
			
			// Current token is a opening brace '(', push it to ops
			else if (tokens[i] == '(') {
				ops.push(tokens[i]);
			}
			// Current token is a closing brace ')', solve entire brace
			else if (tokens[i] == ')') {
				while (ops.peek() != '(') {
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				}
				ops.pop();
			}
			
			// Current token is an operator
			else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/')
			{
				// While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
				while (!ops.isEmpty() && hasPrecedence(tokens[i], ops.peek())) {
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				}
				ops.push(tokens[i]);
			}
		}
//		System.out.println(values.toString());
//		System.out.println(ops.toString());
		
		// Entire expression has been parsed at this time, apply remaining ops to remain values;
		//int val = 0;
		while(!ops.isEmpty()) {
			//if (!values.isEmpty()) {
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));
			//}
		}
		
		// Top of 'values' contains result, return it
		return values.pop();
	}
	
	// Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
	public static boolean hasPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')') return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return false;
		else 
			return true;
	}
	
	
	public static int applyOp(char op, int b, int a) {
		switch(op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new UnsupportedOperationException("Cannot divide by zero.");
			return a / b;
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		System.out.println(ExpressionEvaluation.evaluate("10 + 2 * 6"));
		System.out.println(ExpressionEvaluation.evaluate("100 * 2 + 12"));
		System.out.println(ExpressionEvaluation.evaluate("100 * ( 2 + 12 )"));
		System.out.println(ExpressionEvaluation.evaluate("100 * ( 2 + 12 ) / 14"));
	}

}

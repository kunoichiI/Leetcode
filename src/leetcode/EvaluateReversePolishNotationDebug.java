package leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotationDebug {
	// why if else is not accepted while switch is accepted in leetcode???
	public static int evalRPN(String[] tokens) {
        int res = 0;
        if (tokens == null || tokens.length == 0)
            return res;
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (Character.isDigit(token.charAt(0))) {
                stack.push(Integer.parseInt(token));
            }
            else {
                int first = stack.pop();
                int second = stack.pop();
                if (token == "+") {
                    stack.push(first + second);
                }
                else if (token == "-") {
                    stack.push(second - first);
                }
                else if (token == "*") {
                    stack.push(first * second);
                }
                else if (token == "/") {
                    stack.push(second / first);
                }  
            }
        }
        return stack.peek();
    }
	public static void main(String[] args) {
		String[] tokens = { "2", "1", "+", "3", "*" };
		System.out.println("value is: " + evalRPN(tokens)); // 9
		
		String[] tokens1 = { "4", "13", "5", "/", "+" };
		System.out.println("value is: " + evalRPN(tokens1)); // 6
		
		String[] tokens2 = { "0", "3", "/" };
		System.out.println("value is: " + evalRPN(tokens2)); // 0
	}

}

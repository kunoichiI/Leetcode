package leetcodeAbove100;

import java.util.Stack;

public class EvaluateReversePolishNotationDebug {
	// why if else is not accepted while switch is accepted in leetcode???
	public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;
        
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

		/*
		 * 这个解法不能通过leetcode， emptyStackException，但是可以在eclipse里运行，原因不明，
		 * 暂时debug无能。留到后面解释，所以遇到这题最好使用switch。。（担心coderpad也无法通过）
		 */
}

package leetcode;
import java.util.*;
//150. Evaluate Reverse Polish Notation  
// Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//Some examples:
//  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6


public class EvaluateReversePolishNotation {
	public static int evalRPN(String[] tokens) {
        int returnValue = 0;
		String operators = "+-*/";
 
		Stack<String> stack = new Stack<String>();
 
		for (String t : tokens) {
			if (!operators.contains(t)) { //push to stack if it is a number
				stack.push(t);
			} else {//pop numbers from stack if it is an operator
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				switch (t) {
				case "+":
					stack.push(String.valueOf(a + b));
					break;
				case "-":
					stack.push(String.valueOf(b - a));
					break;
				case "*":
					stack.push(String.valueOf(a * b));
					break;
				case "/":
					stack.push(String.valueOf(b / a));
					break;
				}
			}
		}
 
		returnValue = Integer.valueOf(stack.pop());
 
		return returnValue;
        
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

package leetcodeAbove200;

import java.util.Stack;

//227. Basic Calculator II 
//Implement a basic calculator to evaluate a simple expression string.
//
//The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
//
//You may assume that the given expression is always valid.
//
//Some examples:
//"3+2*2" = 7
//" 3/2 " = 1
//" 3+5 / 2 " = 5
public class BasicCalculator_II {
	public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur >= '0' && cur <= '9') {
                number = number * 10 + (int)(cur - '0');
            }
            
            if (!Character.isDigit(cur) && cur != ' ' || i == s.length() - 1) {
                switch(sign) {
                    case '+':
                        stack.push(number);
                        break;
                    case '-':
                        stack.push(-number);
                        break;
                    case '*':
                        stack.push(stack.pop() * number);
                        break;
                    case '/':
                        stack.push(stack.pop() / number);
                        break;
                }
                sign = cur;
                number = 0;
            }
        }
        int ans = 0;
        for (int x: stack) {
            ans += x;
        }
        return ans;
    }
	public static void main(String[] args) {
		BasicCalculator_II bc2 = new BasicCalculator_II();
		int res = bc2.calculate(" 3+5 / 2 ");
		System.out.println(res);
		System.out.println(bc2.calculate("3+2*2")); // 7
		System.out.println(bc2.calculate("42")); // 42
	}
}

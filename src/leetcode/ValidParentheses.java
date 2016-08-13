package leetcode;

import java.util.Stack;

//20. Valid Parentheses  
//Difficulty: Easy
//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

public class ValidParentheses {
	public boolean isValid(String s) {
        if (s.length() == 1 || s == null || s.length() == 0) return false;
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }else {
                if (stack.size() == 0) return false;
                char c = stack.pop();
                if (s.charAt(i) == ')' ) {
                    if (c != '(') return false;
                }else if (s.charAt(i) == ']') {
                    if (c != '[') return false;
                }else if (s.charAt(i) == '}') {
                    if (c != '{') return false;
                }
            }
        }
        return stack.size() == 0;
        
    }
}

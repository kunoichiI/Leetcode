package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheseWithHashMap {
	public static boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } 
            else {
                if (!stack.isEmpty() && map.get(stack.peek()) == c)
                    stack.pop();
                else 
                    return false;
            }
        }
        return stack.isEmpty();
    }
	public static void main(String[] args) {
		String s1 = "(]";
		String s2 = "([)]";
		String s3 = "()[]{}";
		String s4 = null;
		
		System.out.println("is valid ? " + isValid(s1)); // false
		System.out.println("is valid ? " + isValid(s2)); // false
		System.out.println("is valid ? " + isValid(s3)); // true
		System.out.println("is valid ? " + isValid(s4)); // true
	}

}

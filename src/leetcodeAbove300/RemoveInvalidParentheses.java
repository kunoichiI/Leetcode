package leetcodeAbove300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses {
	public static List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();
		Set<String> visited = new HashSet<>();
		boolean level = false;
		Queue<String> q = new LinkedList<>();
		System.out.println("The size of res is : " + res.size());
		if (s == null || s.length() == 0)
			return res;
		q.offer(s);
		visited.add(s);
		
		while (!q.isEmpty()) {
			String str = q.poll();
			if (isValidParentheses(str)) {
				res.add(str);
				level = true;
			}
			if (level)
				continue;
			System.out.println(str);
			for (int i = 0; i < str.length(); i++) {
				if (!isParenthesis(str.charAt(i)))
					continue;
				String sub = new StringBuilder(str).deleteCharAt(i).toString(); // this line creates 
				// an empty string when there is only a '(' or ')'
				System.out.println("sub is :" + sub);
				if (!visited.contains(sub)){
					q.offer(sub);
					visited.add(sub);
				}
			}
		}
		return res;
	}
	
	private static boolean isParenthesis(char c) {
		return (c == '(' || c == ')');
	}
	
	private static boolean isValidParentheses(String s) {
		int cnt = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(')
				cnt++;
			else if (c == ')')
				cnt--;
			if (cnt < 0)
				return false;
		}
		return cnt == 0;
	}
	public static void main(String[] args) {
		String str1 = "()())()";
		String str2 = "(a)())()";
		String str3 = ")(";
		
		System.out.println("The result of removing str1 is : " + removeInvalidParentheses(str1));
		System.out.println("The result of removing str2 is : " + removeInvalidParentheses(str2));
		System.out.println("The result of removing str3 is : " + removeInvalidParentheses(str3));
		/* removeInvalidParentheses result is [""] because empty string has been added to queue, too! A
		 * And empty string is valid parentheses! */
	}

}

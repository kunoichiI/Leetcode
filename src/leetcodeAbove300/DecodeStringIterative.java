package leetcodeAbove300;

import java.util.Stack;

public class DecodeStringIterative { // This solution is best for this question!
	public static String decodeString(String s) {
		int n = s.length();
		char[] ss = s.toCharArray();
		Stack<Integer> counts = new Stack<>();
		Stack<String> strings = new Stack<>();
		StringBuilder result = new StringBuilder();
		int count = 0;
		String curString = "";
		
		for (int i = 0; i < n; i++) {
			if (ss[i] >= '0' && ss[i] <= '9') { 
				count = count * 10 + ss[i] - '0';
			} 
			else if (ss[i] == '[') {
				counts.push(count);
				count = 0;
				strings.push(curString);
				curString = "";
			} 
			else if (ss[i] >= 'a' && ss[i] <= 'z') {
				if (!counts.isEmpty())
					curString += ss[i];
				else
					result.append(ss[i]); // if no count is found for alphabet
			}
			else if (ss[i] == ']') {
				int times = counts.pop();
				if (counts.isEmpty()) {
					for (int j = 0; j < times; j++) {
						result.append(curString);
					}
					curString = strings.pop();
				} else {
					String tmp = "";
					for (int j = 0; j < times; j++) {
						tmp += curString;
					}
					curString = strings.pop() + tmp;
				}
			}
		}
		return result.toString();
	}
	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
		System.out.println(decodeString("2[abc]3[cd]ef"));
		System.out.println(decodeString("3[a2[c]]"));
	}

}

package leetcodeAbove300;

import java.util.Stack;

public class DecodeStringIterative { // This solution is best for this question!
	/* 遇到数字时计算count， 遇到字母时，数字栈为空，则直接添加进stringbuilder 结果，
	 * 如果数字栈不为空，则需要叠加 curString； 遇到【 左方括号，把count放入数字栈， 把curString 放入字符栈；
	 * 遇到】 右方括号，数字栈出栈，如果出栈后数字栈为空，则已经来到最外层，一个loop进行计算最终sb，
	 * 如果出栈后数字栈不为空，说明还在里层，pop 字符栈 加上 curString 叠加得到curString， 下一次遇到】时，继续出栈数字栈，直到数字栈为空，得到结果*/
	public static String decodeString(String s) {
		int n = s.length();
		char[] ss = s.toCharArray();
		Stack<Integer> counts = new Stack<>();
		Stack<String> strings = new Stack<>();
		StringBuilder result = new StringBuilder();
		int count = 0; // 关键点一，记录方括号前的重复次数，出栈时loop用
		String curString = ""; // 关键点二，记录不停变化的字符，每次出栈时更新
		
		for (int i = 0; i < n; i++) {
			if (ss[i] >= '0' && ss[i] <= '9') { 
				count = count * 10 + ss[i] - '0';
			} 
			else if (ss[i] == '[') { // 进栈开始
				counts.push(count);
				count = 0;
				strings.push(curString);
				curString = "";
			} 
			else if ((ss[i] >= 'a' && ss[i] <= 'z' )||( ss[i] >= 'A' && ss[i] <= 'Z') ) { 
				/* 大小写字母都要囊括啊！！*/
				if (!counts.isEmpty())
					curString += ss[i];
				else
					result.append(ss[i]); // if no count is found for alphabet
			}
			else if (ss[i] == ']') { // 出栈开始
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
		System.out.println(decodeString("3[a]2[bc]")); // => aaabcbc
		System.out.println(decodeString("2[abc]3[cd]ef")); // => abcabccdcdcdef
		System.out.println(decodeString("3[a2[c]]")); // => accaccacc
	}

}

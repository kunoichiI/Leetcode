package leetcodeAbove100;

import java.util.Arrays;

//186. followup on 121 Given an input string, reverse the string word by word. 
//A word is defined as a sequence of non-space characters.
//
//The input string does not contain leading or trailing spaces and the words 
//are always separated by a single space.
//For example,
//Given s = "the sky is blue",
//return "blue is sky the".
//
//Could you do it in-place without allocating extra space?
public class ReverseWordsInAStringII {
	public static void reverseWords(char[] s) {
		if (s == null || s.length == 0) return;
		int start = 0;
		for (int end = 0; end < s.length; end++) {
			if (s[end] == ' ') {
				reverse(s, start, end - 1);
				start = end + 1;
			}
		}
		reverse(s, start, s.length - 1);
		reverse(s, 0, s.length - 1);
	}
	
	public static void reverse(char[] s, int i, int j) {
		while (i < j) {
			char tmp = s[i];
			s[i] = s[j];
			s[j] = tmp;
			i++;
			j--;
		}
		
	}
 	public static void main(String[] args) {
		String s = "the sky is blue";
		char[] arr = s.toCharArray();
		reverseWords(arr);
		System.out.println(Arrays.toString(arr)); // "blue is sky the"
	}

}

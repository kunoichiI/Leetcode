package pramp;
//Bracket Match
//A string of brackets is considered correctly matched if every opening bracket in the string can be paired up with a later closing bracket, and vice versa. 
//For instance, “(())()” is correctly matched, whereas “)(“ and “((” aren’t. For instance, 
//“((” could become correctly matched by adding two closing brackets at the end, so you’d return 2.
//
//Given a string that consists of brackets, write a function bracketMatch that takes 
//a bracket string as an input and returns the minimum number of brackets you’d need to add to the input in order to make it correctly matched.
//
//Explain the correctness of your code, and analyze its time and space complexities.
public class BracketMatch {
	public static int bracketMatch(String text) { 
	    int open = 0;
	    int close = 0;
	    int ans = 0;
	    for (int i = 0; i < text.length(); i++) {
	      if (text.charAt(i) == '(')
	        open++;
	      else if (text.charAt(i) == ')')
	        close++;
	      
	      if (close > open) {
	        open++;
	        ans++;
	      } 
	    }
	    return open - close + ans;
	  }
	public static void main(String[] args) {
		System.out.println(bracketMatch(")")); // 1
		System.out.println(bracketMatch("(")); // 1
		System.out.println(bracketMatch("(())")); // 0
		System.out.println(bracketMatch("(()")); // 1
		System.out.println(bracketMatch("())(")); // 2
		System.out.println(bracketMatch("))))")); // 4
		System.out.println(bracketMatch(")(")); // 2
		System.out.println(bracketMatch("()()()()")); // 0
	}
	/*
	 * 解题思路：遍历String，在每一个char记录当前open和close bracket个数， 如果close大于open，
	 * 则说明有一个open需要放在当前close的前面，所以在这个点open+ 1， 同时ans + 1，
	 * 最后比较open- close 加上ans的值，是所有需要补足的括号 “（” 或者“）”
	 */

}

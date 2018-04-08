package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesBruteForce {
	/* time complexity :O(N * 2^N) , space complexity:  O(N * 2^N) WHY?? */
	public static List<String> generateParenthesis(int n) {
        List<String> combs = new ArrayList<>();
        generateAll(new char[2 * n], 0, combs);
        return combs;
    }
    
    public static void generateAll(char[] current, int i, List<String> combs) {
        if (i == current.length) {
            if (isValid(current)) {
               combs.add(new String(current));
                return; 
            }
        }
        else {
            current[i] = '(';
            generateAll(current, i + 1, combs);
            current[i] = ')';
            generateAll(current, i + 1, combs);
        }
    }
    
    public static boolean isValid(char[] current) {
        int cnt = 0;
        for (int i = 0; i < current.length; i++) {
            if (current[i] == '(') cnt++;
            else if (current[i] == ')') cnt--;
            if (cnt < 0) return false;
        }
        return cnt == 0;
    }
	public static void main(String[] args) {
		System.out.print(generateParenthesis(4));
		// [(((()))), ((()())), ((())()), ((()))(), (()(())), (()()()), (()())(), (())(()), (())()(), ()((())), ()(()()), ()(())(), ()()(()), ()()()()]
	}
	/*
	 * 
	 */

}

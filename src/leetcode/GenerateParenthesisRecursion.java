package leetcode;

import java.util.ArrayList;
import java.util.List;
/*
 * 2 ms Leetcode AC solution! Build parentheses from scratch.
 */
public class GenerateParenthesisRecursion {
	public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", n, n);
        return res;
    }
    
    public static void dfs(List<String> res, String tmp, int left, int right) {
        if (left > right) return;
        if (left == 0 && right == 0) {
            res.add(tmp);
            return;
        }
        if (left > 0) {
            dfs(res, tmp + "(", left - 1, right);
        }
        if (right > 0) {
            dfs(res, tmp + ")", left, right - 1);
        }
    }
	public static void main(String[] args) {
		System.out.print(generateParenthesis(4));
		// [(((()))), ((()())), ((())()), ((()))(), (()(())), (()()()), (()())(), (())(()), (())()(), ()((())), ()(()()), ()(())(), ()()(()), ()()()()]
	}
	
	/*
	 * 解题思路：n对括号，则有n个（和n 个）
	 * 然后开始进行dfs，每一层进行扩充tmp string，加上（ 或者加上）
	 * 如果left 大于right 则说明塞入的） 大于 （ 个数，不可能paird， invalid string，直接返回 base case 1
	 * base case2为 left == right == 0， 此时把valid string 加入到res list 中。
	 */

}

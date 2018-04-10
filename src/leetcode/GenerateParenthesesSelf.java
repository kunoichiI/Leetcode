package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesesSelf {
	public static List<String> generateParenthesis(int n) {
        Set<String> ans = new HashSet<>();
        if (n == 0) {
            ans.add("");
            return new ArrayList<String>(ans);
        }
        else {
            List<String> prev = generateParenthesis(n - 1);
            for (String str: prev) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(') {
                        String s = insertInside(str, i);
                        ans.add(s);
                    }
                }
                ans.add("()" + str);
            }  
        }
      return new ArrayList<String>(ans);  
    }
    public static String insertInside(String str, int leftIdx) {
        return str.substring(0, leftIdx + 1) + "()" + str.substring(leftIdx + 1);
    }
    public static void main(String[] args) {
    		List<String> ans = generateParenthesis(4);
    		ans.forEach(s -> System.out.print(s + " "));
    }
    /*
     * 这个答案虽然可以生成所有正确的括号组合，但是顺序和Leetcode 的testcase不一样所以无法AC。
     * 思路在于，n的括号组合在n -1括号组合的基础上，遇到（ 则在其后加上一对括号。
     * 还有就是string前后各添加一对括号。用HashSet排重。 
     * 时间复杂度是：O(Nl * 2 ^ N), 空间复杂度是：？ 总之not efficient！
     */
}

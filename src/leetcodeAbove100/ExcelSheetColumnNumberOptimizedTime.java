package leetcodeAbove100;
/*
 * 值得注意的点，Math.pow计算乘n个26，和for loop乘26，前者居然leetcode AC时间更长，
 * 所以Java Math.pow的time complexity值得看源代码分析速度到底是多少，可以认为是O（1）吗？
 */
public class ExcelSheetColumnNumberOptimizedTime {
	public static int titleToNumber(String s) {
        if(s == null || s.length() == 0){
            throw new IllegalArgumentException("Input is not valid!");
        }
 
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int val = s.charAt(i) - 'A' + 1;
            int len = s.length() - i - 1;
            if (len > 0)  {
                for (int j = 0; j < len; j++) {
                    val *= 26;
                }
            }
            ans += val;
        }
 
        return ans;
    }
	public static void main(String[] args) {
		System.out.println(titleToNumber("AA")); //27
		System.out.println(titleToNumber("AZZ")); // 1378
	}

}

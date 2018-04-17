package leetcodeAbove100;

import java.util.List;

public class WordBreakDP {
	public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        
        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                String word = s.substring(j, i);
                if (dp[j] && wordDict.contains(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * 解题思想：dp[i] = true代表 s（0 ～ i - 1）可以被分割
	 * 用dp记录当前index能否被分割。
	 */
}

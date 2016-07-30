package leetcode;

//198. House Robber  QuestionEditorial Solution  My Submissions
//Total Accepted: 81541
//Total Submissions: 229079
//Difficulty: Easy
//You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

// Solution 1: dynamic programming o(n) time, o(n) space
public class HouseRobber {
	public int rob(int[] nums) {
	    if(nums==null||nums.length==0)
	        return 0;
	 
	    if(nums.length==1)
	        return nums[0];
	 
	    int[] dp = new int[nums.length];
	    dp[0]=nums[0];
	    dp[1]=Math.max(nums[0], nums[1]);
	 
	    for(int i=2; i<nums.length; i++){
	        dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
	    }
	 
	    return dp[nums.length-1];
	}
}

// Solution 2: use two variables, o(n) time, o(1) space
//public int rob(int[] num) {
//	if(num==null || num.length == 0)
//		return 0;
// 
//	int even = 0;
//	int odd = 0;
// 
//	for (int i = 0; i < num.length; i++) {
//		if (i % 2 == 0) {
//			even += num[i];
//			even = even > odd ? even : odd;
//		} else {
//			odd += num[i];
//			odd = even > odd ? even : odd;
//		}
//	}
// 
//	return even > odd ? even : odd;
//}

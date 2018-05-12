package leetcodeAbove100;

public class HouseRobberOptimalSolution {
	public int rob(int[] nums) {
        int prev = 0, curr = 0;
        for (int n : nums) {
            int tmp = curr;
            curr = Math.max(prev + n, curr);
            prev = tmp;
        }
        return curr;
    }
}
/*
 * 这个解法十分类似Reverse LinkedList的iteration法。这个记住prev value， 翻转链表是记住next
 */

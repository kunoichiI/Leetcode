package leetcodeAbove500;

import java.util.HashSet;
import java.util.Set;

// Brute Force
public class ArrayNesting {
	public int arrayNesting(int[] nums) {
        // TLE... O(n^2) time, O(n) space, can optimize to O(1) using count variable
        if (nums == null || nums.length == 0) return 0;
        
        int ans = 0;
        
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            int cur = nums[i];
            while (!set.contains(cur)) {
                set.add(cur);
                cur = nums[cur];   
            }
            ans = Math.max(ans, set.size());
        }
        return ans;
    }
}

package leetcodeAbove200;
import java.util.*;
//219. Contains Duplicate II 
//Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
//and the difference between i and j is at most k.

public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length == 1 || k == 0) {
            return false; // corner case
        }
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                if (i - index <= k) {
                    return true;
                }else {
                    map.put(nums[i], i);
                }
            }else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}

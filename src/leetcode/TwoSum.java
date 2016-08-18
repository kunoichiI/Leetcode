package leetcode;

import java.util.HashMap;

//1. Two Sum  
//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//You may assume that each input would have exactly one solution.
//
//Example:
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].

public class TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>(); // Store nums element and index as key and value pair.
        
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];  // Calculate difference 
            if (map.containsKey(diff)) {  // Find the other number
                arr[0] = map.get(diff);   // get(diff) get the first index
                arr[1] = i;
                return arr;
            }
            map.put(nums[i], i);
        }
        return null;
    }
}

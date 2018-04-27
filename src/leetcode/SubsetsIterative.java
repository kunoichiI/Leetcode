package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubsetsIterative { // This is hard man!! The idea is clear though.. Got stuck
	public static List<List<Integer>> subsets(int[] nums) {
        // iterative solution
        if (nums == null || nums.length == 0) return null;
        Arrays.sort(nums); // ascending order
        HashSet<List<Integer>> res = new HashSet<>();
        res.add(new ArrayList<>());
        
        for (int i = 0; i < nums.length; i++) {
        		HashSet<Integer> tmp = new HashSet<>();
            for (List<Integer> l : res) {
            		tmp.addAll(l);
            		tmp.add(nums[i]);
                System.out.println("temp is: " + tmp);
                
            }
            res.add(new ArrayList<Integer>(tmp));
        }
        
        return new ArrayList<List<Integer>>(res);
    }
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		List<List<Integer>> res = subsets(arr);
		System.out.print(res); // [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]

	}

}

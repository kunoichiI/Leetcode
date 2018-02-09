package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum_n3 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return res;
        
        Arrays.sort(nums);
        
        for (int i = 0; i <= nums.length - 3; i++) {
            for (int j = i + 1; j <= nums.length - 2; j++) {
                int low = j + 1;
                int high = nums.length - 1;
                while (low < high) {
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if ( sum == target) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[low]);
                        l.add(nums[high]);
                        if (!set.contains(l)) {
                            set.add(l);
                            res.add(l);
                        }
                        low++;
                        high--;
                    }
                    else if (sum > target) {
                        high--; 
                    }
                    else {
                        low++;
                    }   
                }
            }
        }
        return res;
    }       
	public static void main(String[] args) {
		int[] nums = {1, 0, -1, 0, -2, 2 };
		int target = 0;
		FourSum solution = new FourSum();
		List<List<Integer>> res = solution.fourSum(nums, target);
		res.stream()
			.forEach(System.out::println); // => [-2, 0, 0, 2], [-1, 0, 0, 1], [-2, -1, 1, 2]
		
		int[] nums1 = null;
		int target1 = 1;
		List<List<Integer>> res1 = solution.fourSum(nums1, target1);
		System.out.println("-----------");
		System.out.println("The output should be empty this time :)"); 
		res1.stream()
			.forEach(System.out::println); // => []
		
		int[] nums2 = { 1, 2, 2, 1};
		int target2 = 6;
		List<List<Integer>> res2 = solution.fourSum(nums2, target2);
		System.out.println("-----------");
		res2.stream()
		.forEach(System.out::println); // =>  [1, 1, 2, 2]
		
		int[] nums3 = { 3, 5, 0, -2, -1, 0, -5 };
		int target3 = 0;
		List<List<Integer>> res3 = solution.fourSum(nums3, target3);
		System.out.println("-----------");
		res3.stream()
		.forEach(System.out::println); // => [-2, -1, 0, 3], [-5, 0, 0, 5]
		
		int[] nums4 = {-3, -1, 0, 2, 4, 5};
		int target4 = 0;
		List<List<Integer>> res4 = solution.fourSum(nums4, target4);
		System.out.println("-----------");
		res4.stream()
		.forEach(System.out::println); // => [-3, -1, 0, 4]

	}

}

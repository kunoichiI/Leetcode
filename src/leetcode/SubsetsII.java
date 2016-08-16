package leetcode;
import java.util.*;
//90. Subsets II 
//Given a collection of integers that might contain duplicates, nums, return all possible subsets.
//
//Note: The solution set must not contain duplicate subsets.
//
//For example,
//If nums = [1,2,2], a solution is:
//
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]

public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);  
        
        for (int len = 1; len <= nums.length; len++) {
            subsetsHelper(result, list, nums, 0, len);
        }
        result.add(new ArrayList<Integer>());

        return result;
    }


    private void subsetsHelper(List<List<Integer>> result,
        List<Integer> list, int[] num, int pos, int len) {
        if (list.size() == len) {
            if (!result.contains(list)) {
                result.add(new ArrayList<Integer>(list));
            }
        }

        for (int i = pos; i < num.length; i++) {

            list.add(num[i]);
            subsetsHelper(result, list, num, i + 1, len);
            list.remove(list.size() - 1);
        }
    }
}

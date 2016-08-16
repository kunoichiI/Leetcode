package leetcode;
import java.util.*;
//78. Subsets  
//Given a set of distinct integers, nums, return all possible subsets.
//
//Note: The solution set must not contain duplicate subsets.
//
//For example,
//If nums = [1,2,3], a solution is:
//
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);  
        subsetsHelper(result, list, nums, 0);

        return result;
    }


    private void subsetsHelper(List<List<Integer>> result,
        List<Integer> list, int[] num, int pos) {

        result.add(new ArrayList<Integer>(list));

        for (int i = pos; i < num.length; i++) {

            list.add(num[i]);
            subsetsHelper(result, list, num, i + 1);
            list.remove(list.size() - 1);
        }
    }
}

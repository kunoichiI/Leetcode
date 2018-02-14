package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//47. Permutations II
//Given a collection of numbers that might contain duplicates, 
//return all possible unique permutations.
//
//For example,
//[1,1,2] have the following unique permutations:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
public class PermutationsIIIterative { /* 这个方法比recursive还要难理解。。*/
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> returnList = new ArrayList<>();
	    returnList.add(new ArrayList<Integer>());
 
        for (int i = 0; i < nums.length; i++) {
            Set<ArrayList<Integer>> currentSet = new HashSet<>();
            for (List<Integer> l : returnList) {
                for (int j = 0; j < l.size() + 1; j++) {
                    l.add(j, nums[i]);
                    ArrayList<Integer> T = new ArrayList<Integer>(l);
                    l.remove(j);
                    currentSet.add(T);
                }
            }
            returnList = new ArrayList<List<Integer>>(currentSet);
        }
 
	    return returnList;
	}
	public static void main(String[] args) {
		int[] a = {23, 4, 5, 5, 4, 9, 9, 8};
		System.out.println("The result is: ");
		List<List<Integer>> res = permuteUnique(a);
		res.stream().forEach(System.out::println);
	}

}

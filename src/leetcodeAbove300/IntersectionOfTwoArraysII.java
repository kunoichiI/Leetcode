package leetcodeAbove300;
//350. Intersection of Two Arrays II
//Given two arrays, write a function to compute their intersection.
//
//Example:
//Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
//
//Note:
//Each element in the result should appear as many times as it shows in both arrays.
//The result can be in any order.
//Follow up:
//What if the given array is already sorted? How would you optimize your algorithm?
//What if nums1's size is small compared to nums2's size? Which algorithm is better?
//What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArraysII {

	public static int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int x : nums1) {
			if (map.containsKey(x)){
				map.put(x, map.get(x) +1);
			}else {
				map.put(x, 1);
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i:nums2) {
			if (map.containsKey(i)) {
				if (map.get(i) > 1) {
					map.put(i, map.get(i)-1);
				}else {
					map.remove(i);
				}
				list.add(i);
			}
		}
		
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

    public static void main(String[] args) {
    		int[] nums1 = { 1, 2, 2, 1};
    		int[] nums2 = { 2, 2 };
    		int[] nums3 = { 1}; int[] nums4 = { 1 };
    		int[] res = intersect(nums1, nums2);
    		System.out.println(Arrays.toString(res)); // [2,2]
    		
    		int[] res3= intersect(nums3, nums4);
    		System.out.println(Arrays.toString(res3)); //[1]
    }
}

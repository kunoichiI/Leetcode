package leetcodeAbove300;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArraysWithHashSet {
	public static int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<>();
		HashSet<Integer> set2 = new HashSet<>();
		for (int i : nums1) {
			set1.add(i);
		}
		for (int i : nums2) {
			if (set1.contains(i))
				set2.add(i);
		}
		int[] res = new int[set2.size()];
		int k = 0;
		for (int j: set2) {
			res[k++] = j;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		int[] res1 = intersection(nums1, nums2);
		System.out.print("The intersection of two arrays is: " + Arrays.toString(res1)); // [2]
		System.out.println();
		
		int[] nums3 = { 1, 2, 3, 4, 3, 8, 8, 9 };
		int[] nums4 = { 2, 4, 8, 9, 8 };
		int[] res2 = intersection(nums3, nums4);
		System.out.print("The intersection of two arrays is: " + Arrays.toString(res2)); // [2, 4, 8, 9]
	}

}

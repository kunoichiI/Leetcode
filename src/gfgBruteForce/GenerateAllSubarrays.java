package gfgBruteForce;

import java.util.ArrayList;
import java.util.List;
// Time complexity: O(N ^ 3) Space Complexity: O(N) 
// reference: https://www.geeksforgeeks.org/subarraysubstring-vs-subsequence-and-programs-to-generate-them/
public class GenerateAllSubarrays {
	public static List<List<Integer>> generate(int[] arr) {
		List<List<Integer>> ans = new ArrayList<>();
		if (arr == null || arr.length == 0) return ans;
		for (int i = 0; i < arr.length; i++) { // i is the start index
			for (int j = i; j < arr.length; j++) { // j end index
				List<Integer> tmp = new ArrayList<>();
				for (int k = i; k <= j; k++) { // collect all elements in the subarray
					tmp.add(arr[k]);
				}
				ans.add(tmp); // add subarray to res list
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		List<List<Integer>> ans = generate(arr);
		for (List<Integer> l : ans) {
			System.out.println(l.toString());
		}
	}
	/*
	 * 解题思路： Brute force， i 是start index（0 ～ arr长度-1）， j是end index（i ～ arr长度 - 1）
	 * k loop 从各个subarray的起点到终点， 收集所有arr at index k，
	 * 每一次j loop后，添加tmp进ans， 最后返回ans
	 */
}

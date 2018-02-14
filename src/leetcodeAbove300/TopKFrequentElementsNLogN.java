package leetcodeAbove300;
//347. Top K Frequent Elements
//Given a non-empty array of integers, return the k most frequent elements.
//
//For example,
//Given [1,1,1,2,2,3] and k = 2, return [1,2].
//Note: 
//You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
//Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElementsNLogN {  // O(NLogN) time, o(N) space
	public static List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		// sort the list of map keys and get sublist of k size
		List<Integer> candidates = new ArrayList<>(map.keySet());
		Collections.sort(candidates, (w1, w2) -> map.get(w1) != map.get(w2) ? map.get(w2) - map.get(w1) : w2.compareTo(w1));
		return candidates.subList(0, k);
	}
	public static void main(String[] args) {
		int[] nums = { 1,1,1,2,2,3 };
		int k = 2;
		List<Integer> lst = topKFrequent(nums, k);
		lst.stream().forEach(System.out::println);
	}

}

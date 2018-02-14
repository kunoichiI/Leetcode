package leetcodeAbove300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// better solution for 347 Top K Frequent Elements
public class TopKFrequentElementsNLogK { // O(NLogK) time, O(N) space, using HEAP
	public static List<Integer> topKFrequent(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((i1, i2) -> map.get(i1) != map.get(i2) ? map.get(i2) - map.get(i1) : i2.compareTo(i1));
		for (Integer key : map.keySet()) {
			queue.offer(key);
			if (queue.size() > k) queue.poll(); /* Maintain a heap of k size*/
		}
		List<Integer> lst = new ArrayList<>();
		while (!queue.isEmpty()) lst.add(queue.poll());
		return lst;
	}
	public static void main(String[] args) {
		int[] nums = { 1,1,1,2,2,3 };
		int k = 2;
		List<Integer> lst = topKFrequent(nums, k);
		lst.stream().forEach(System.out::println);
	}

}

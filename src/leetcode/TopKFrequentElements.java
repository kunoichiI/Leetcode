package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Pair {
	int num;
	int count;
	public Pair(int num, int count) {
		this.num = num;
		this.count = count;
	}
}

public class TopKFrequentElements {
	// Given a non-empty array of integers, return the k most frequent elements.
	// For example,
	// Given [1,1,1,2,2,3] and k = 2, return [1,2].
	public List<Integer> topKFrequent(int[] nums, int k) {
		// Count the frequency for each element using hashMap
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num: nums) {
			if (!map.containsKey(num)) {
				map.put(num, 1);
			}else {
				map.put(num, map.get(num) + 1);
			}
		}
		// Create a min heap using priority queue
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>(){
			public int compare(Pair a, Pair b) {
				return a.count - b.count;
			}
		});
		
		// maintain a heap of size k
		for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
			Pair p = new Pair(entry.getKey(), entry.getValue());
			queue.offer(p);
			while (queue.size() > k) {
				queue.poll();
			}
		}
		
		// get all elements in heap
		List<Integer> result = new ArrayList<Integer>();
		while (queue.size() > 0) {
			result.add(queue.poll().num);
		}
		// reverse the order of list
		Collections.reverse(result);
		for (Integer i : result) {
			System.out.print(i + " ");
		}
		
		return result;
	}
	public static void main(String[] args) {
		TopKFrequentElements tkfe = new TopKFrequentElements();
		int[] nums = {1,1,1,2,2,3};
		int k = 3;
		tkfe.topKFrequent(nums, k);

	}

}

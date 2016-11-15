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
	// Time complexity : O(nlogk), n is the array size
	
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
		int k = 2;
		tkfe.topKFrequent(nums, k);

	}
	
	
	
//	public List<Integer> topKFrequent(int[] nums, int k) {
//		// Time complexity: O(n) bucket sort!!
//	    //count the frequency for each element
//	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//	    for(int num: nums){
//	        if(map.containsKey(num)){
//	            map.put(num, map.get(num)+1);
//	        }else{
//	            map.put(num, 1);
//	        }
//	    }
//	 
//	    //get the max frequency
//	    int max = 0;
//	    for(Map.Entry<Integer, Integer> entry: map.entrySet()){
//	        max = Math.max(max, entry.getValue());
//	    }
//	 
//	    //initialize an array of ArrayList. index is frequency, value is list of numbers
//	    ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[max+1];
//	    for(int i=1; i<=max; i++){
//	        arr[i]=new ArrayList<Integer>();
//	    }
//	 
//	    for(Map.Entry<Integer, Integer> entry: map.entrySet()){
//	        int count = entry.getValue();
//	        int number = entry.getKey();
//	        arr[count].add(number);
//	    }
//	 
//	    List<Integer> result = new ArrayList<Integer>();
//	 
//	    //add most frequent numbers to result
//	    for(int j=max; j>=1; j--){
//	        if(arr[j].size()>0){
//	            for(int a: arr[j]){
//	                result.add(a);
//	            }
//	        }
//	 
//	        if(result.size()==k)
//	            break;
//	    }
//	 
//	    return result;
//	}


}

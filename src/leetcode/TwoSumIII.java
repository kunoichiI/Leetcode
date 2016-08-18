package leetcode;

import java.util.HashMap;
import java.util.Map;

//170. Two Sum III - Data structure design Total Accepted: 311 Total Submissions: 1345
//Design and implement a TwoSum class. It should support the following operations:add and find.
//add - Add the number to an internal data structure.
//find - Find if there exists any pair of numbers which sum is equal to the value.
//For example,
//add(1); add(3); add(5);
//find(4) -> true
//find(7) -> false

public class TwoSumIII {
	Map<Integer, Integer> map = new HashMap<>();
	
	public void add(int n) {
		if (map.containsKey(n)) {
			map.put(n, map.get(n)+1);
		}else {
			map.put(n, 1);
		}
	}
	
	public boolean find(int target) {
		for (int key: map.keySet()) {
			int another = target - key;
			if (map.containsKey(another) && another != key) {
				return true;
			}else if (another == key && map.get(key) > 1) {
				return true;
			}
		}
		return false;
	}
}

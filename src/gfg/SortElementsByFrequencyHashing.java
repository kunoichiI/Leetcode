package gfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Sort elements by frequency | Set 1
	Print the elements of an array in the decreasing frequency if 
	2 numbers have same frequency then print the one which came first.
	
	Examples:
	
	Input:  arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
	Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6}
	
	Input: arr[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8}
	Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6, -1, 9999999}
 */
public class SortElementsByFrequencyHashing {
	public static void sortByFreq(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		//map.entrySet().stream().forEach(s -> System.out.println("key is: " + s.getKey() + " value is: " + s.getValue()));
		List<Pair> list = new ArrayList<>();
		for (int key: map.keySet()) {
			int val = map.get(key);
			list.add(new Pair(key, val));
		}
		Collections.sort(list, (p1, p2) -> p2.freq == p1.freq ? p2.name - p1.name : p2.freq - p1.freq);
		// The question asked Print the elements of an array in the decreasing frequency if 
		// 2 numbers have same frequency then print the one which came first.
		// This solution here is not right... we should track first index of each number
		for (Pair p: list) {
			int freq = p.freq;
			for (int i = 0; i < freq; i++) {
				System.out.print(p.name + " ");
			}
		}
	}
	public static void main(String[] args) {
		int[] arr = {2, 5, 2, 8, 5, 6, 8, 8};
		sortByFreq(arr); // {8, 8, 8, 2, 2, 5, 5, 6}
		System.out.println();
		int[] arr1 = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
		sortByFreq(arr1); //
	}

}
class Pair {
	int name;
	int freq;
	public Pair(int key, int fq) {
		name = key;
		freq = fq;
	}
}

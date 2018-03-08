package pramp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Pairs with Specific Difference
//Given an array arr of distinct integers and a nonnegative integer k, 
//write a function findPairsWithGivenDifference that returns an array of all pairs [x,y] in arr, 
//such that x - y = k. If no such pairs exist, return an empty array.
//
//In your solution, try to reduce the memory usage while maintaining time efficiency. 
//Prove the correctness of your solution and analyze its time and space complexities.
//
//Note: the order of the pairs in the output array should maintain the order of the y element in the original array.
//
//Examples:
//
//input:  arr = [0, -1, -2, 2, 1], k = 1
//output: [[1, 0], [0, -1], [-1, -2], [2, 1]]
//
//input:  arr = [1, 7, 5, 3, 32, 17, 12], k = 17
//output: []
//Constraints:
//
//[time limit] 5000ms
//
//[input] array.integer arr
//
//0 ≤ arr.length ≤ 100
//[input]integer k
//
//k ≥ 0
//[output] array.array.integer
public class PairsWithSpecificDifference {
	public static int[][] findPairsWithGivenDifference(int[] arr, int k) {
	    // your code goes here
	    Map<Integer, Integer> map = new HashMap<>();
	    List<APair> list = new ArrayList<>();
	    for (int i = 0; i < arr.length; i++) {
	      map.put(arr[i], i);
	    }
	    for (int key: map.keySet()) {
	      if (map.containsKey(key + k))
	        list.add(new APair(key + k, key)); // use y's order for output
	    }
	    
	    if (list.size() == 0)
	      return new int[][]{};
	    else {
	      int[][] res = new int[list.size()][2];
	      int row = 0;
	      for (APair p : list) {
	        res[row++] = new int[]{p.x, p.y};
	      }
	      return res;
	    }
	  }
	public static void main(String[] args) {
		int[] arr1 = { 4,1 };
		int[] arr2 = { 1, 5, 11, 7 };
		int[] arr3 = { 0, -1, -2, 2, 1 };
		int[] arr4 = { 1, 7, 5, 3, 32, 17, 12 };
		
		System.out.println(Arrays.deepToString(findPairsWithGivenDifference(arr1, 3))); // [[4, 1]]
		System.out.println(Arrays.deepToString(findPairsWithGivenDifference(arr2, 4)));// [[5, 1], [11, 7]]
		System.out.println(Arrays.deepToString(findPairsWithGivenDifference(arr2, 6)));// [[7, 1], [11, 5]]
		System.out.println(Arrays.deepToString(findPairsWithGivenDifference(arr2, 10))); // [[11, 1]]
		System.out.println(Arrays.deepToString(findPairsWithGivenDifference(arr3, 1))); // [[1, 0], [0, -1], [-1, -2], [2, 1]]
		System.out.println(Arrays.deepToString(findPairsWithGivenDifference(arr4, 17))); // []
	}

}

class APair {
	  int x;
	  int y;
	  APair(int x, int y) {
	    this.x = x;
	    this.y = y;
	  }
}

package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/*Given k sorted integer arrays, merge them into one sorted array.
Have you met this question in a real interview? Yes
Example
Given 3 sorted arrays:
[
  [1, 3, 5, 7],
  [2, 4, 6],
  [0, 8, 9, 10, 11]
]
return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].
Challenge
Do it in O(N log k).
N is the total number of integers.
k is the number of arrays.
Tags Expand 
Heap Priority Queue
*/
import java.util.PriorityQueue;

public class MergeKSortedArrays {
	public class aNode {
		int val, x, y; // val: value of aNode, x,y are index
		public aNode(int val, int x, int y) {
			this.val = val;
			this.x = x;
			this.y = y;
		}
	}
	public List<Integer> mergeKarrays(int[][] arr) {
		List<Integer> res = new ArrayList<>();
		if (arr == null || arr.length == 0) {
			return res;
		}
		
		 PriorityQueue<aNode> queue = new PriorityQueue<aNode>(arr.length,
		            new Comparator<aNode>() {
		                public int compare(aNode a, aNode b){
		                    return a.val - b.val;
		                }
		            }
		  );
		 
		 // init
		 for (int i = 0; i < arr.length; i++) {
			 if (arr[i].length != 0) {
				 queue.offer(new aNode(arr[i][0], i, 0));
			 }
		 }
		 
		 aNode node;
		 
		 while(!queue.isEmpty()) {
			 node = queue.poll();
			 res.add(node.val);
			 if (node.y < arr[node.x].length -1) {
				 queue.offer(new aNode(arr[node.x][node.y+1], node.x, node.y+1));
			 }
		 }
		 return res;
	}
	
	
	public static void main(String[] args) {
		int[][] arr = { {1,  3, 5, 7},
						{2, 4, 6, 8, 9},
						{0, 10, 11, 12, 13, 156, 2000}};
		MergeKSortedArrays mksa = new MergeKSortedArrays();
		List<Integer> res = mksa.mergeKarrays(arr);
		for (int i : res) {
			System.out.print(i + " ");
		}
		
	}

}



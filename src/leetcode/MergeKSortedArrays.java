package leetcode;

import java.util.PriorityQueue;

public class MergeKSortedArrays {
	public int[] mergeKarrays(int[][] arr, int k) {
		int num = 0;
		for (int i = 0; i < k; i++) {
			num += arr[i].length;
		}
		int[] res = new int[num];
		
		PriorityQueue<Integer> queue = new PriorityQueue<>(num);
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < arr[i].length;j++) {
				queue.add(arr[i][j]);
			}
		}
		int idx = 0;
		while(!queue.isEmpty()) {
			res[idx++] = queue.poll();
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		int[][] arr = { {1,  3, 5, 7},
						{2, 4, 6, 8, 9},
						{0, 10, 11, 12, 13, 156, 2000}};
		
		MergeKSortedArrays mksa = new MergeKSortedArrays();
		int[] res = mksa.mergeKarrays(arr, 3);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

}



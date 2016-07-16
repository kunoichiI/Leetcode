package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
	
	    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
	        List<int[]> res = new ArrayList<int[]>();  
	        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
	        int amount = Math.min(k, nums1.length*nums2.length);
	        
	        
	        class Sort implements Comparator<int[]> {
	        	public int compare(int[] arr1, int[] arr2) {
	                return nums1[arr1[0]] + nums2[arr1[1]] - nums2[arr2[1]] - nums1[arr2[0]];
	            }
	        }
	        Sort st = new Sort();
	        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(st);
	        
	        queue.offer(new int[]{0,0});
	        while(k > 0 && !queue.isEmpty()) {
	            int[] pair = queue.poll();
	            int i = pair[0];
	            int j = pair[1];
	            res.add(new int[]{nums1[i], nums2[j]});
	            k--;
	            
	            if (j == 0 && i+1 < nums1.length) {
	                queue.offer(new int[]{i+1, 0});
	            }
	            
	            if (j+1 < nums2.length) {
	                queue.offer(new int[]{i, j+1});
	            }
	        }
	        return res;
	    }
	
}

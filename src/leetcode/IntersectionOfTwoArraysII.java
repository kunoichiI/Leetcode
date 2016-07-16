package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArraysII {

	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int x : nums1) {
			if (map.containsKey(x)){
				map.put(x, map.get(x) +1);
			}else {
				map.put(x, 1);
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i:nums2) {
			if (map.containsKey(i)) {
				if (map.get(i) > 1) {
					map.put(i, map.get(i)-1);
				}else {
					map.remove(i);
				}
				list.add(i);
			}
		}
		
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
	
	// If arrays are sorted.
//	public int[] intersect(int[] nums1, int[] nums2) {
//	    Arrays.sort(nums1);
//	    Arrays.sort(nums2);
//	    ArrayList<Integer> list = new ArrayList<Integer>();
//	    int p1=0, p2=0;
//	    while(p1<nums1.length && p2<nums2.length){
//	        if(nums1[p1]<nums2[p2]){
//	            p1++;
//	        }else if(nums1[p1]>nums2[p2]){
//	            p2++;
//	        }else{
//	            list.add(nums1[p1]);
//	            p1++;
//	            p2++;
//	 
//	        }
//	    }
//	 
//	    int[] result = new int[list.size()];
//	    int i=0;
//	    while(i<list.size()){
//	        result[i]=list.get(i);
//	        i++;
//	    }
//	    return result;
//	}

}

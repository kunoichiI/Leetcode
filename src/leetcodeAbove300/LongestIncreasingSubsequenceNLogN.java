package leetcodeAbove300;

import java.util.ArrayList;

// 300
/* 
 * for each num in nums
     if(list.size()==0 || num > last element in list)
          add num to list
     else 
          replace the element in the list which is the smallest yet bigger than num
 */
public class LongestIncreasingSubsequenceNLogN {
	public static int lengthOfLIS(int[] nums) {
		if(nums==null || nums.length==0)
	        return 0;
	 
	    ArrayList<Integer> list = new ArrayList<Integer>(); 
	 
	    for(int num: nums){
	        if(list.size()==0 || num>list.get(list.size()-1)){
	            list.add(num);
	        }else{
	            int i=0; 
	            int j=list.size()-1;
	 
	            while(i<j){ // get the value which closet to num but bigger than it.
	                int mid = (i+j)/2;
	                if(list.get(mid) < num){
	                    i=mid+1;
	                }else{
	                    j=mid;
	                }
	            }
	 
	            list.set(j, num);
	        }
	    }
	 
	    return list.size();
	}
	public static void main(String[] args) {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS(nums)); // 4
	}

}

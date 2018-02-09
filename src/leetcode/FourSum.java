package leetcode;
import java.util.*;
//18. 4Sum  
//Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
//Note: The solution set must not contain duplicate quadruplets.
//
//For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
//
//A solution set is:
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]


// O(n^2 * logn) time complexity 
public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
	         // Since we use set here, we don't need to dedup data
	        Set<List<Integer>> result = new HashSet<List<Integer>>();
	        if (nums == null || nums.length < 4)
	        		return new ArrayList<List<Integer>>(result);
	        Arrays.sort(nums);
	        Map<Integer, Set<PairEle>> map = new HashMap<Integer, Set<PairEle>>();
	        for (int i = 0; i < nums.length; i++) {
	        		//System.out.println("outside loop i is: " + i);
	        		// Here two for loops order really matters!!!!!
		        	for (int j = i + 1; j < nums.length; j++) {
		                int pairSum = nums[i] + nums[j];
//		                System.out.println("pairSum is : " + pairSum);
//		                System.out.println("i is here: " + i + " ,j is here: " + j);
		                if (map.containsKey(target - pairSum)) {
		                		//System.out.println("sum is: " + pairSum + " ,difference is : " + (target - pairSum));
		                    for (PairEle p : map.get(target - pairSum)) {
		                        List<Integer> l = new LinkedList<>();
		                        l.add(p.first);
		                        l.add(p.second);
		                        l.add(nums[i]);
		                        l.add(nums[j]);
		                        result.add(l);
		                    }
		                }
		        }
		        	
	        		for (int j = 0; j < i; j++) {
	        			//System.out.println("j is : " + j);
	        			//System.out.println("i is : " + i);
	        			int a = nums[j], b = nums[i];
	        			if (!map.containsKey(a+b)) {
	        				map.put(a+b, new HashSet<PairEle>());
	        			}
	        			map.get(a+b).add(new PairEle(a, b));
	        		}
	        		
		        
	        }
	            // Note the order of these two for-loops is critical

	            
	            
	        //}
	        return new ArrayList<List<Integer>>(result);
	    }
	
	public static void main(String[] args) {
		int[] nums = {1, 0, -1, 0, -2, 2 };
		int target = 0;
		FourSum solution = new FourSum();
		List<List<Integer>> res = solution.fourSum(nums, target);
		res.stream()
			.forEach(System.out::println); // => [-2, 0, 0, 2], [-1, 0, 0, 1], [-2, -1, 1, 2]
		
		int[] nums1 = null;
		int target1 = 1;
		List<List<Integer>> res1 = solution.fourSum(nums1, target1);
		System.out.println("-----------");
		System.out.println("The output should be empty this time :)"); 
		res1.stream()
			.forEach(System.out::println); // => []
		
		int[] nums2 = { 1, 2, 2, 1};
		int target2 = 6;
		List<List<Integer>> res2 = solution.fourSum(nums2, target2);
		System.out.println("-----------");
		res2.stream()
		.forEach(System.out::println); // =>  [1, 1, 2, 2]
		
		int[] nums3 = { 3, 5, 0, -2, -1, 0, -5 };
		int target3 = 0;
		List<List<Integer>> res3 = solution.fourSum(nums3, target3);
		System.out.println("-----------");
		res3.stream()
		.forEach(System.out::println); // => [-2, -1, 0, 3], [-5, 0, 0, 5]
		
		int[] nums4 = {-3, -1, 0, 2, 4, 5};
		int target4 = 0;
		List<List<Integer>> res4 = solution.fourSum(nums4, target4);
		System.out.println("-----------");
		res4.stream()
		.forEach(System.out::println); // => 	[-3, -1, 0, 4]
	}
}

class PairEle {
		Integer first;
	    Integer second;
	    public PairEle(int first, int second) {
	       this.first = first;
	       this.second = second;
	    }
	        
	    @Override
	    public int hashCode() {
	       return this.first.hashCode() + this.second.hashCode();
	    }
	        
	    @Override
	    public boolean equals(Object d){ 
	       if (!(d instanceof PairEle)) {
	    	   return false;
	       }
	       PairEle p = (PairEle) d;
	       return (this.first == p.first) && (this.second == p.second);
	    }
}
	





//public class FourSum {
//	public List<List<Integer>> fourSum(int[] nums, int target) {
//		List<List<Integer>> result = new ArrayList<List<Integer>>();
//		 
//        if(nums==null|| nums.length<4)
//            return result;
// 
//        Arrays.sort(nums);
// 
//        for(int i=0; i<nums.length-3; i++){
//            if(i!=0 && nums[i]==nums[i-1])
//                continue;
//            for(int j=i+1; j<nums.length-2; j++){
//                if(j!=i+1 && nums[j]==nums[j-1])
//                    continue;
//                int k=j+1;
//                int l=nums.length-1;
//                while(k<l){
//                    if(nums[i]+nums[j]+nums[k]+nums[l]<target){
//                        k++;
//                    }else if(nums[i]+nums[j]+nums[k]+nums[l]>target){
//                        l--;
//                    }else{
//                        List<Integer> t = new ArrayList<Integer>();
//                        t.add(nums[i]);
//                        t.add(nums[j]);
//                        t.add(nums[k]);
//                        t.add(nums[l]);
//                        result.add(t);
// 
//                        k++;
//                        l--;
// 
//                        while(k<l &&nums[l]==nums[l+1] ){
//                            l--;
//                        }
// 
//                        while(k<l &&nums[k]==nums[k-1]){
//                            k++;
//                        }
//                    }
//                }
//            }
//        }
// 
//        return result; 
//	}
//}

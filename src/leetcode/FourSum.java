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


// O(n^2 * logn) time complexity but go TLE (Still don't know why Orz.. To be continued)
//public class FourSum {
//	public List<List<Integer>> fourSum(int[] nums, int target) {
//        // O(n^2 * logn) time complexity
//        
//        List<List<Integer>> res = new ArrayList<>();
//        if (nums == null || nums.length < 4) return res;
//        int n = nums.length;
//        int size = n * (n-1)/2; 
//        PairSum[] aux = new PairSum[size];
//        int k = 0;
//        for (int i = 0; i < n-1; i++) {
//            for (int j = i +1; j < n; j++) {
//                aux[k++] = new PairSum(nums[i], nums[j]);
//            }
//        }
//        
//        Arrays.sort(aux);
//        
//        // initialize two pointers for aux array
//        int l = 0;
//        int r = size - 1;
//        while(l < size && r >= 0) {
//            if (aux[l].sum + aux[r].sum == target && noCommon(aux[l], aux[r])) {
//                List<Integer> list = new ArrayList<>();
//                list.add(aux[l].first);
//                list.add(aux[l].sec);
//                list.add(aux[r].first);
//                list.add(aux[r].sec);
//                if (!res.contains(list)) {
//                    res.add(list);
//                }
//            }else if (aux[l].sum + aux[r].sum < target) {
//                l++;
//            }else {
//                r--;
//            }
//        }
//        return res;
//    }
//    
//    public boolean noCommon(PairSum p1, PairSum p2) {
//        if (p1.first == p2.first || p1.first == p2.sec || p1.sec == p2.sec || p1.sec == p2.first) 
//            return false;
//        return true;
//    }
//	
//	public static void main(String[] args) {
//		FourSum fs = new FourSum();
//		int[] nums = {1, 0, -1, 0, -2, 2};
//		int target = 0;
//		List<List<Integer>> res = fs.fourSum(nums, target);
//		for (List<Integer> list : res) {
//			System.out.println(list.toString());
//		}
//
//	}
//
//}
//
//class PairSum implements Comparable<PairSum> {
//    int first;
//    int sec;
//    int sum;
//    
//    public PairSum(int first, int sec) {
//        this.first = first;
//        this.sec = sec;
//        this.sum = first + sec;
//    }
//    
//    @Override
//    public int compareTo(PairSum p) {
//        return this.sum - p.sum;
//    }
//}

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		 
        if(nums==null|| nums.length<4)
            return result;
 
        Arrays.sort(nums);
 
        for(int i=0; i<nums.length-3; i++){
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1; j<nums.length-2; j++){
                if(j!=i+1 && nums[j]==nums[j-1])
                    continue;
                int k=j+1;
                int l=nums.length-1;
                while(k<l){
                    if(nums[i]+nums[j]+nums[k]+nums[l]<target){
                        k++;
                    }else if(nums[i]+nums[j]+nums[k]+nums[l]>target){
                        l--;
                    }else{
                        List<Integer> t = new ArrayList<Integer>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[k]);
                        t.add(nums[l]);
                        result.add(t);
 
                        k++;
                        l--;
 
                        while(k<l &&nums[l]==nums[l+1] ){
                            l--;
                        }
 
                        while(k<l &&nums[k]==nums[k-1]){
                            k++;
                        }
                    }
                }
            }
        }
 
        return result; 
	}
}

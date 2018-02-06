package leetcodeAbove200;

//287. Find the Duplicate Number  
//Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
//
//Note:
//You must not modify the array (assume the array is read only).
//You must use only constant, O(1) extra space.
//Your runtime complexity should be less than O(n2).
//There is only one duplicate number in the array, but it could be repeated more than once.


// Two solutions (Binary search & Find Cycle)
public class FindDuplicateNumber {
	// 1: Find Cycle, refering to Floyd's circle-finding algorithm
	/**
	public class Solution {
	    public int findDuplicate(int[] nums) {
	        int slow = 0;
	        int fast = 0;
	        // 找到快慢指针相遇的地方
	        do{
	            slow = nums[slow];
	            fast = nums[nums[fast]];
	        } while(slow != fast);
	        int find = 0;
	        // 用一个新指针从头开始，直到和慢指针相遇
	        while(find != slow){
	            slow = nums[slow];
	            find = nums[find];
	        }
	        return find;
	    }
	}
	**/
	
	
	
	// 2: Binary Search Time Complexity O(NlogN) 
	public int findDup(int[] nums) {
		int min = 0, max = nums.length - 1;
		while (min <= max) {
			int mid = min + (max - min) / 2;
			int cnt = 0; // count how many numbers is less than the mid number
			
			for (int i : nums) {
				if (i <= mid) {
					cnt++;
				}
			}
			
			if (cnt > mid) { // if mid is 3 but we have 4 numbers larger than mid, it means there must exist duplicate
				max = mid - 1;
			}else { 
				min = mid + 1;
			}	
		}
		return min;
	}

}

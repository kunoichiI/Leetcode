package leetcode;
//26. Remove Duplicates from Sorted Array
//Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
//Do not allocate extra space for another array, 
//you must do this by modifying the input array in-place with O(1) extra memory.
//
//Example:
//Given nums = [1,1,2],
//
//Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
//It doesn't matter what you leave beyond the new length.
public class RemoveDuplicatesFromSortedArray { // Time: O(n), space :O(1)
	public static int removeDuplicates(int[] nums) {
		if (nums == null) return 0;
        if (nums.length < 2) return nums.length;
        
        int write = 0, read = 1;
        while (read < nums.length) {
            if (nums[write] == nums[read])
                read++;
            else {
                write++;
                nums[write] = nums[read];
                read++;
            }
        }
        return write + 1;  
    }
	
	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[]{1,1,2})); // 2
		System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4})); // 5
	}

}

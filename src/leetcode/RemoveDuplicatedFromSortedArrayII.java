package leetcode;
/*
 * 80. Remove Duplicates from Sorted Array II
 * 
 * Follow up for "Remove Duplicates":
	What if duplicates are allowed at most twice?
	
	For example,
	Given sorted array nums = [1,1,1,2,2,3],
	
	Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
	It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatedFromSortedArrayII {
	public static int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;
        
        int end = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[end - 1]) {
                nums[++end] = nums[i];
            }
        }
        return end + 1;
    }
	public static void main(String[] args) {
		
	}
	/*
	 * 解题思路： http://bangbingsyb.blogspot.com/2014/11/leetcode-remove-duplicates-from-sorted.html
	 */
}

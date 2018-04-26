package leetcodeAbove100;
/*
 * ref: https://www.geeksforgeeks.org/majority-element/
 */
public class MajorityElementMooreVotingAlgorithmUsed {
	/* Moore Voting Algorithm used, time: O(n), space: O(1) */
	public static int majorityElement(int[] nums) {
        if (nums.length <= 2) return nums[0];
        
        int maj_index = 0, cnt = 1;
        
        for (int i = 1; i < nums.length; i++) {
            // Moore Voting Algorithm to find majority element candidate
            // if  nums[maj_index] == nums[i] ,increment cnt by 1, else decrement count by 1
            if (nums[maj_index] == nums[i]) cnt++;
            else cnt--;
            
            // if cnt becomes 0, change maj_index to current index and reset cnt to 1
            if (cnt == 0) {
                maj_index = i;
                cnt = 1;
            }
        }
        int candidate = nums[maj_index];
        cnt = 0;
        
        for (int i: nums) {
        	 	if (i == candidate) cnt++;
        }
        return cnt > nums.length / 2 ? candidate : Integer.MAX_VALUE;
	}
	public static void main(String[] args) {
		int[] arr1 = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
		System.out.println(majorityElement(arr1)); // 4
		int[] arr2 = { 3, 3, 4, 2, 4, 4, 2, 4 };
		System.out.println(majorityElement(arr2)); // Integer.MAX_VALUE, majority element not exist!
	}

}

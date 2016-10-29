package leetcode;

public class FirstMissingPositive {

	public static int firstMissingPositive(int[] nums) {
		// edge case(if nums is null)
        if (nums == null) return 1;
        
        // regular case (By swapping elements to where it should be, we will get an ascending order array)
        for (int i = 0; i < nums.length; i++) { // if the element value is equal to i+1, then it's in its right place in the array
            while(nums[i] > 0 && nums[i] < nums.length && nums[i] != i+1) {
                int tmp = nums[nums[i]-1];
                if (tmp == nums[i]) break;
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        } // After this for loop, we will get an ascending array but may have one inproper element like[1, -1, 3, 4] where -1 is not a right number
        
        for (int i = 0; i < nums.length; i++) {
            // This loop is to find the inproper number if it exists
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        // If there's no such inproper number
        return nums.length + 1;
    }
	public static void main(String[] args) {
		int[] nums = {-1, -2, 1, 2, 5, 1};
		System.out.println(firstMissingPositive(nums));

	}

}

package leetcode;

public class FirstMissingPositive {

	public static int firstMissingPositive(int[] nums) {
        if (nums == null) return 1;
        
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i+1) {
                int tmp = nums[nums[i]-1];
                if (tmp == nums[i]) {
                    break;
                }
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i+1;
            }
        }
        return nums.length + 1;
    }
	public static void main(String[] args) {
		int[] nums = {-1, -2, 1, 2, 5, 1};
		System.out.println(firstMissingPositive(nums));

	}

}

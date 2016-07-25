package leetcode;

public class SortColors {
	public void sortColors(int[] nums) {
        int n = nums.length;
        int redSt = 0, blueSt = n-1;
        int i = 0;
        while (i < blueSt + 1) {
            if (nums[i] == 0) {
                swap(nums, i, redSt);
                redSt++;
                i++;
                continue;
            }
            if (nums[i] == 2) {
                swap(nums, i, blueSt);
                blueSt--;
                continue;
            }
            i++;
        }
    }
    public static void swap(int[] A, int i, int j) {
       int tmp = A[i];
          A[i]=A[j];
          A[j]=tmp;
    }
}

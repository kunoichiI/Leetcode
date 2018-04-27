package interviewQ;

import java.util.Arrays;

// FB interview q
// Given a sorted number array [1, 1, 2, 2, 3, 4, 5, 5, 5] return the total unique numbers and put
// them in the left side. i.e. return 5 and the left 5 numbers will be [1, 2, 3, 4, 5, The_rest_doesnt_matter]
public class RewriteSortedArray {
	public static int rewriteSortedArray(int[] nums) {
		int write = 0;
		int key = nums[0];
		for (int read = 1; read < nums.length; read++) {
			if (nums[read] == key)
				continue;
			key = nums[read];
			nums[++write] = key;	
		}
		System.out.println("array becomes: " + Arrays.toString(nums));
		return write + 1;
	}
	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3, 4, 5, 5, 5 };
		int res = rewriteSortedArray(nums);
		System.out.println("res is : " + res); // 5
	}

}
